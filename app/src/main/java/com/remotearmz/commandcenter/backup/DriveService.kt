package com.remotearmz.commandcenter.backup

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.services.drive.model.File as DriveFile
import com.remotearmz.commandcenter.R
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Service for interacting with Google Drive for backup and restore functionality.
 */
@Singleton
class DriveService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val _backupStatus = MutableStateFlow<BackupStatus>(BackupStatus.Idle)
    val backupStatus: StateFlow<BackupStatus> = _backupStatus.asStateFlow()
    
    private val _lastBackupTime = MutableStateFlow<Long?>(null)
    val lastBackupTime: StateFlow<Long?> = _lastBackupTime.asStateFlow()
    
    private val drive: Drive? by lazy {
        val account = GoogleSignIn.getLastSignedInAccount(context)
        if (account != null) {
            val credential = GoogleAccountCredential.usingOAuth2(
                context, setOf(DriveScopes.DRIVE_FILE)
            )
            credential.selectedAccount = account.account
            
            Drive.Builder(
                AndroidHttp.newCompatibleTransport(),
                GsonFactory(),
                credential
            )
                .setApplicationName(context.getString(R.string.app_name))
                .build()
        } else {
            null
        }
    }
    
    /**
     * Uploads a backup to Google Drive.
     *
     * @param data The data to backup as a JSON string
     * @param fileName Optional custom file name (without extension)
     * @return true if the backup was successful, false otherwise
     */
    suspend fun uploadBackup(data: String, fileName: String? = null): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                _backupStatus.value = BackupStatus.InProgress("Uploading backup...")
                
                val driveService = drive ?: run {
                    _backupStatus.value = BackupStatus.Failed("Not signed in to Google Drive")
                    return@withContext false
                }
                
                val backupFileName = if (fileName != null) {
                    "${fileName}.json"
                } else {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault())
                    "remotearmz_backup_${dateFormat.format(Date())}.json"
                }
                
                val fileMetadata = DriveFile()
                fileMetadata.name = backupFileName
                fileMetadata.mimeType = "application/json"
                
                // Add app folder property for better organization
                fileMetadata.parents = listOf("appDataFolder")
                
                val mediaContent = com.google.api.client.http.ByteArrayContent
                    .fromString("application/json", data)
                
                val file = driveService.files().create(fileMetadata, mediaContent)
                    .setFields("id, name, modifiedTime, size")
                    .execute()
                
                // Update last backup time
                val modifiedTime = file.modifiedTime?.value ?: System.currentTimeMillis()
                _lastBackupTime.value = modifiedTime
                
                _backupStatus.value = BackupStatus.success("Backup completed successfully")
                true
            } catch (e: IOException) {
                _backupStatus.value = BackupStatus.failed("Backup failed: ${e.message ?: "Unknown error"}", e)
                false
            } catch (e: Exception) {
                _backupStatus.value = BackupStatus.failed("Unexpected error: ${e.message ?: "Unknown error"}", e)
                false
            }
        }
    }
    
    /**
     * Lists all available backups in the user's Google Drive.
     *
     * @return List of [DriveBackupFile] objects representing the backups
     */
    suspend fun listBackups(): List<DriveBackupFile> {
        return withContext(Dispatchers.IO) {
            try {
                val driveService = drive ?: return@withContext emptyList()
                
                val result = driveService.files().list()
                    .setQ("name contains 'remotearmz_backup' and mimeType = 'application/json' and 'appDataFolder' in parents")
                    .setSpaces("appDataFolder")
                    .setFields("files(id, name, size, modifiedTime, mimeType)")
                    .setOrderBy("modifiedTime desc") // Most recent first
                    .execute()
                
                result.files?.map { file ->
                    DriveBackupFile(
                        id = file.id,
                        name = file.name.replace(".json", ""),
                        size = file.size ?: 0,
                        modifiedTime = file.modifiedTime?.value ?: 0,
                        mimeType = file.mimeType ?: "application/json"
                    )
                } ?: emptyList()
            } catch (e: Exception) {
                _backupStatus.value = BackupStatus.failed("Failed to list backups: ${e.message ?: "Unknown error"}", e)
                emptyList()
            }
        }
    }
    
    /**
     * Downloads a backup file from Google Drive.
     *
     * @param fileId The ID of the file to download
     * @return The file contents as a string, or null if the download failed
     */
    suspend fun downloadBackup(fileId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val driveService = drive ?: return@withContext null
                
                val outputStream = ByteArrayOutputStream()
                driveService.files().get(fileId)
                    .executeMediaAndDownloadTo(outputStream)
                
                String(outputStream.toByteArray())
            } catch (e: Exception) {
                _backupStatus.value = BackupStatus.failed("Failed to download backup: ${e.message ?: "Unknown error"}", e)
                null
            }
        }
    }
    
    /**
     * Deletes a backup file from Google Drive.
     *
     * @param fileId The ID of the file to delete
     * @return true if the deletion was successful, false otherwise
     */
    suspend fun deleteBackup(fileId: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val driveService = drive ?: return@withContext false
                
                driveService.files().delete(fileId).execute()
                true
            } catch (e: Exception) {
                _backupStatus.value = BackupStatus.failed("Failed to delete backup: ${e.message ?: "Unknown error"}", e)
                false
            }
        }
    }
    
    /**
     * Clears the current backup status.
     */
    fun clearStatus() {
        _backupStatus.value = BackupStatus.Idle
    }
}
