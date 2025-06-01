package com.remotearmz.commandcenter.notification

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    /**
     * Schedule daily notification checks for follow-ups, target deadlines, etc.
     */
    fun scheduleDailyNotifications() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        
        val notificationWorkRequest = PeriodicWorkRequestBuilder<NotificationWorker>(
            1, TimeUnit.DAYS
        )
            .setConstraints(constraints)
            .build()
        
        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            NotificationWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            notificationWorkRequest
        )
    }
    
    /**
     * Cancel all scheduled notifications
     */
    fun cancelAllNotifications() {
        WorkManager.getInstance(context).cancelUniqueWork(NotificationWorker.WORK_NAME)
    }
    
    /**
     * Check for notifications immediately (for testing or manual refresh)
     */
    fun checkNotificationsNow() {
        // Use OneTimeWorkRequestBuilder for an immediate check
        val notificationWorkRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .build()
        
        WorkManager.getInstance(context).enqueue(notificationWorkRequest)
    }
}
