package com.remotearmz.commandcenter;

import android.app.Application;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.notification.NotificationManager;
import dagger.hilt.android.HiltAndroidApp;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/remotearmz/commandcenter/RemoteArmzApplication;", "Landroid/app/Application;", "()V", "backupManager", "Lcom/remotearmz/commandcenter/backup/BackupManager;", "getBackupManager", "()Lcom/remotearmz/commandcenter/backup/BackupManager;", "setBackupManager", "(Lcom/remotearmz/commandcenter/backup/BackupManager;)V", "notificationManager", "Lcom/remotearmz/commandcenter/notification/NotificationManager;", "getNotificationManager", "()Lcom/remotearmz/commandcenter/notification/NotificationManager;", "setNotificationManager", "(Lcom/remotearmz/commandcenter/notification/NotificationManager;)V", "onCreate", "", "app_debug"})
@dagger.hilt.android.HiltAndroidApp
public final class RemoteArmzApplication extends android.app.Application {
    @javax.inject.Inject
    public com.remotearmz.commandcenter.notification.NotificationManager notificationManager;
    @javax.inject.Inject
    public com.remotearmz.commandcenter.backup.BackupManager backupManager;
    
    public RemoteArmzApplication() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.notification.NotificationManager getNotificationManager() {
        return null;
    }
    
    public final void setNotificationManager(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.notification.NotificationManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.backup.BackupManager getBackupManager() {
        return null;
    }
    
    public final void setBackupManager(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.backup.BackupManager p0) {
    }
    
    @java.lang.Override
    public void onCreate() {
    }
}