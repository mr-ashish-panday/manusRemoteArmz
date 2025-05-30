package com.remotearmz.commandcenter

import android.app.Application
import com.remotearmz.commandcenter.backup.BackupManager
import com.remotearmz.commandcenter.notification.NotificationManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class RemoteArmzApplication : Application() {
    
    @Inject
    lateinit var notificationManager: NotificationManager
    
    @Inject
    lateinit var backupManager: BackupManager
    
    override fun onCreate() {
        super.onCreate()
        
        // Schedule daily notifications
        notificationManager.scheduleDailyNotifications()
        
        // Schedule automatic backups
        backupManager.scheduleAutomaticBackups()
    }
}
