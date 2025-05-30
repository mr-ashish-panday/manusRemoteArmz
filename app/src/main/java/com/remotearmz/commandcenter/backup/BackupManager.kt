package com.remotearmz.commandcenter.backup

import android.content.Context
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import java.util.UUID
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BackupManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val driveService: DriveService,
    private val notificationHelper: NotificationHelper
) {
    private val workManager = WorkManager.getInstance(context)
    
    private val _backupInProgress = MutableStateFlow(false)
    val backupInProgress: StateFlow<Boolean> = _backupInProgress.asStateFlow()
    
    private val _lastBackupStatus = MutableStateFlow<BackupStatus>(BackupStatus.Idle)
    val lastBackupStatus: StateFlow<BackupStatus> = _lastBackupStatus.asStateFlow()
    
    // Forward the backup status from DriveService
    val backupStatus: StateFlow<BackupStatus> = driveService.backupStatus
    val lastBackupTime: StateFlow<Long?> = driveService.lastBackupTime
    
    // Track if scheduled backup is enabled
    private val _isScheduledBackupEnabled = MutableStateFlow(false)
    val isScheduledBackupEnabled: StateFlow<Boolean> = _isScheduledBackupEnabled.asStateFlow()
    
    fun schedulePeriodicBackup() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build()
        
        val backupWorkRequest = PeriodicWorkRequestBuilder<BackupWorker>(
            repeatInterval = 24,
            repeatIntervalTimeUnit = TimeUnit.HOURS
        )
            .setConstraints(constraints)
            .build()
        
        workManager.enqueueUniquePeriodicWork(
            BACKUP_WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            backupWorkRequest
        )
        
        _isScheduledBackupEnabled.value = true
        notificationHelper.showBackupScheduledNotification(true, "Daily backup scheduled")
    }
    
    fun cancelPeriodicBackup() {
        workManager.cancelUniqueWork(BACKUP_WORK_NAME)
        _isScheduledBackupEnabled.value = false
        notificationHelper.showBackupScheduledNotification(false, "Daily backup disabled")
    }
    
    fun performManualBackup(): UUID {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        
        val backupWorkRequest = OneTimeWorkRequestBuilder<BackupWorker>()
            .setConstraints(constraints)
            .addTag(MANUAL_BACKUP_TAG)
            .build()
        
        _backupInProgress.value = true
        notificationHelper.showBackupStartedNotification("Manual backup started")
        
        // Enqueue the work request
        workManager.enqueueUniqueWork(
            MANUAL_BACKUP_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            backupWorkRequest
        )
        
        // Observe the work status
        observeBackupWork(backupWorkRequest.id)
        
        return backupWorkRequest.id
    }
    
    /**
     * Schedule automatic backups based on user preferences
     */
    fun scheduleAutomaticBackups() {
        // By default, schedule daily backups
        schedulePeriodicBackup()
    }
    
    /**
     * Check if scheduled backup is enabled
     */
    fun checkScheduledBackupStatus() {
        val workInfos = workManager.getWorkInfosForUniqueWork(BACKUP_WORK_NAME).get()
        _isScheduledBackupEnabled.value = workInfos.isNotEmpty() && 
                workInfos.any { it.state != WorkInfo.State.CANCELLED }
    }
    
    /**
     * Observe the status of a backup work request
     */
    private fun observeBackupWork(workId: UUID) {
        workManager.getWorkInfoByIdLiveData(workId).observeForever { workInfo ->
            if (workInfo != null) {
                when (workInfo.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        _backupInProgress.value = false
                        _lastBackupStatus.value = BackupStatus.Success("Backup completed successfully")
                    }
                    WorkInfo.State.FAILED -> {
                        _backupInProgress.value = false
                        _lastBackupStatus.value = BackupStatus.Failed("Backup failed")
                    }
                    WorkInfo.State.CANCELLED -> {
                        _backupInProgress.value = false
                        _lastBackupStatus.value = BackupStatus.Failed("Backup was cancelled")
                    }
                    else -> {
                        // Work in progress or queued
                        if (workInfo.state == WorkInfo.State.RUNNING) {
                            _backupInProgress.value = true
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Get the status of all backup work
     */
    fun getBackupWorkStatus(): Flow<List<WorkInfo>> {
        return workManager.getWorkInfosByTagFlow(MANUAL_BACKUP_TAG)
    }
    
    companion object {
        private const val BACKUP_WORK_NAME = "periodic_backup_work"
        private const val MANUAL_BACKUP_WORK_NAME = "manual_backup_work"
        private const val MANUAL_BACKUP_TAG = "manual_backup"
    }
}
