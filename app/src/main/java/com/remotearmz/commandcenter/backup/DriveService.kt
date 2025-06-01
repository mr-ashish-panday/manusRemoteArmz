package com.remotearmz.commandcenter.backup

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.api.client.extensions.android.http.AndroidHttp
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential
import com.google.api.client.json.gson.GsonFactory
import com.google.api.services.drive.Drive
import com.google.api.services.drive.DriveScopes
import com.google.api.services.drive.model.File
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
import java.util.Collections
import java.util.Date
import java.util.Locale
import javax.inject.Inject
import javax.inject.Singleton

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
                context, Collections.singleton(DriveScopes.DRIVE_FILE)
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
    
    suspend fun uploadBackup(data: String, fileName: String? = null): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                _backupStatus.value = BackupStatus.InProgress("Uploading backup...")
                
                val driveService = drive ?: run {
                    _backupStatus.value = BackupStatus.Failed("Not signed in")
                    return@withContext false
                }
                
                val backupFileName = if (fileName != null) {
                    fileName
                } else {
                    val dateFormat = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault())
                    "remotearmz_backup_${dateFormat.format(Date())}.json"
                }
                
                val fileMetadata = File()
                fileMetadata.name = backupFileName
                fileMetadata.mimeType = "application/json"
                
                val contentStream = ByteArrayOutputStream()
                contentStream.write(data.toByteArray())
                
                val mediaContent = com.google.api.client.http.ByteArrayContent
                    .fromString("application/json", data)
                
                val file = driveService.files().create(fileMetadata, mediaContent)
                    .setFields("id, name, createdTime")
                    .execute()
                
                _lastBackupTime.value = System.currentTimeMillis()
                _backupStatus.value = BackupStatus.Success("Backup completed successfully")
                true
            } catch (e: IOException) {
                _backupStatus.value = BackupStatus.Failed(e.message ?: "Unknown error")
                false
            }
        }
    }
    
    suspend fun listBackups(): List<DriveBackupFile> {
        return withContext(Dispatchers.IO) {
            try {
                val driveService = drive ?: return@withContext emptyList()
                
                val result = driveService.files().list()
                    .setQ("name contains 'remotearmz_backup' and mimeType = 'application/json'")
                    .setSpaces("drive")
                    .setFields("files(id, name, createdTime)")
                    .execute()
                
                result.files.map { file ->
                    DriveBackupFile(
                        id = file.id,
                        name = file.name,
                        createdTime = file.createdTime.value
                    )
                }
            } catch (e: IOException) {
                emptyList()
            }
        }
    }
    
    suspend fun downloadBackup(fileId: String): String? {
        return withContext(Dispatchers.IO) {
            try {
                val driveService = drive ?: return@withContext null
                
                val outputStream = ByteArrayOutputStream()
                driveService.files().get(fileId).executeMediaAndDownloadTo(outputStream)
                
                String(outputStream.toByteArray())
            } catch (e: IOException) {
                null
            }
        }
    }
}

sealed class BackupStatus {
    object Idle : BackupStatus()
    data class InProgress(val message: String = "In progress...") : BackupStatus()
    data class Success(val message: String) : BackupStatus()
    data class Failed(val error: String) : BackupStatus()
}

data class DriveBackupFile(
    val id: String,
    val name: String,
    val createdTime: Long
)
