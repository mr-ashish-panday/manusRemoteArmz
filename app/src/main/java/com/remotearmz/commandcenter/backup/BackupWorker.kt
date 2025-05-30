package com.remotearmz.commandcenter.backup

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import com.remotearmz.commandcenter.data.repository.OutreachRepository
import com.remotearmz.commandcenter.data.repository.TargetRepository
import com.remotearmz.commandcenter.notification.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@HiltWorker
class BackupWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val clientRepository: ClientRepository,
    private val leadRepository: LeadRepository,
    private val targetRepository: TargetRepository,
    private val outreachRepository: OutreachRepository,
    private val activityLogRepository: ActivityLogRepository,
    private val driveService: DriveService,
    private val notificationHelper: NotificationHelper
) : CoroutineWorker(context, params) {
    
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.getDefault())
    
    override suspend fun doWork(): Result {
        return try {
            // Create a backup of all data
            val backupData = createBackupData()
            
            // Upload backup to Google Drive
            val timestamp = dateFormat.format(Date())
            val backupFileName = "remotearmz_backup_$timestamp.json"
            val success = driveService.uploadBackup(backupData, backupFileName)
            
            // Show notification about backup status
            val message = if (success) {
                "Backup completed successfully"
            } else {
                "Backup failed. Will retry later."
            }
            notificationHelper.showBackupCompletedNotification(success, message)
            
            if (success) Result.success() else Result.retry()
        } catch (e: Exception) {
            e.printStackTrace()
            notificationHelper.showBackupCompletedNotification(
                false, 
                "Backup failed: ${e.message}. Will retry later."
            )
            Result.retry()
        }
    }
    
    private suspend fun createBackupData(): String = withContext(Dispatchers.IO) {
        val backup = mutableMapOf<String, Any>()
        
        // Get all entities from repositories
        val clients = clientRepository.getAllClients().first()
        val leads = leadRepository.getAllLeads().first()
        val targets = targetRepository.getAllTargets().first()
        val outreachActivities = outreachRepository.getAllOutreachActivities().first()
        val activityLogs = activityLogRepository.getAllActivityLogs().first()
        
        // Add entities to backup data
        backup["clients"] = clients
        backup["leads"] = leads
        backup["targets"] = targets
        backup["outreach_activities"] = outreachActivities
        backup["activity_logs"] = activityLogs
        backup["backup_timestamp"] = System.currentTimeMillis()
        backup["app_version"] = "1.0.0" // Replace with actual app version
        
        // Convert to JSON
        return@withContext Json.encodeToString(backup)
    }
}
