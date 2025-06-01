package com.remotearmz.commandcenter.backup;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.remotearmz.commandcenter.notification.NotificationHelper;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010\'\u001a\u00020&J\u0019\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u0006\u0010,\u001a\u00020\u001eJ\u0006\u0010-\u001a\u00020\u001eR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupManager;", "", "context", "Landroid/content/Context;", "driveService", "Lcom/remotearmz/commandcenter/backup/DriveService;", "notificationHelper", "Lcom/remotearmz/commandcenter/notification/NotificationHelper;", "(Landroid/content/Context;Lcom/remotearmz/commandcenter/backup/DriveService;Lcom/remotearmz/commandcenter/notification/NotificationHelper;)V", "_backupInProgress", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_isScheduledBackupEnabled", "_lastBackupStatus", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "backupInProgress", "Lkotlinx/coroutines/flow/StateFlow;", "getBackupInProgress", "()Lkotlinx/coroutines/flow/StateFlow;", "backupStatus", "getBackupStatus", "isScheduledBackupEnabled", "lastBackupStatus", "getLastBackupStatus", "lastBackupTime", "", "getLastBackupTime", "workManager", "Landroidx/work/WorkManager;", "cancelPeriodicBackup", "", "checkScheduledBackupStatus", "getBackupWorkStatus", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/work/WorkInfo;", "observeBackupWork", "workId", "Ljava/util/UUID;", "performManualBackup", "restoreFromBackup", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleAutomaticBackups", "schedulePeriodicBackup", "Companion", "app_release"})
@javax.inject.Singleton
public final class BackupManager {
    private final android.content.Context context = null;
    private final com.remotearmz.commandcenter.backup.DriveService driveService = null;
    private final com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper = null;
    private final androidx.work.WorkManager workManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _backupInProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> backupInProgress = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.backup.BackupStatus> _lastBackupStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> lastBackupStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> backupStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> lastBackupTime = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isScheduledBackupEnabled = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isScheduledBackupEnabled = null;
    @org.jetbrains.annotations.NotNull
    public static final com.remotearmz.commandcenter.backup.BackupManager.Companion Companion = null;
    private static final java.lang.String BACKUP_WORK_NAME = "periodic_backup_work";
    private static final java.lang.String MANUAL_BACKUP_WORK_NAME = "manual_backup_work";
    private static final java.lang.String MANUAL_BACKUP_TAG = "manual_backup";
    
    @javax.inject.Inject
    public BackupManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.backup.DriveService driveService, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getBackupInProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> getLastBackupStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> getBackupStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getLastBackupTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isScheduledBackupEnabled() {
        return null;
    }
    
    public final void schedulePeriodicBackup() {
    }
    
    public final void cancelPeriodicBackup() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.UUID performManualBackup() {
        return null;
    }
    
    /**
     * Schedule automatic backups based on user preferences
     */
    public final void scheduleAutomaticBackups() {
    }
    
    /**
     * Check if scheduled backup is enabled
     */
    public final void checkScheduledBackupStatus() {
    }
    
    /**
     * Observe the status of a backup work request
     */
    private final void observeBackupWork(java.util.UUID workId) {
    }
    
    /**
     * Get the status of all backup work
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<androidx.work.WorkInfo>> getBackupWorkStatus() {
        return null;
    }
    
    /**
     * Restore data from a backup file
     * @param fileId The ID of the backup file to restore from
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object restoreFromBackup(@org.jetbrains.annotations.NotNull
    java.lang.String fileId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupManager$Companion;", "", "()V", "BACKUP_WORK_NAME", "", "MANUAL_BACKUP_TAG", "MANUAL_BACKUP_WORK_NAME", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}