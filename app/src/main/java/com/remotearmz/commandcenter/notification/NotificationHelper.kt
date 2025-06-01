package com.remotearmz.commandcenter.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.remotearmz.commandcenter.MainActivity
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.Target
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val CHANNEL_ID_FOLLOW_UP = "follow_up_channel"
        const val CHANNEL_ID_TARGET = "target_channel"
        const val CHANNEL_ID_BACKUP = "backup_channel"
        const val CHANNEL_ID_SUMMARY = "summary_channel"
        
        const val NOTIFICATION_ID_FOLLOW_UP = 1000
        const val NOTIFICATION_ID_TARGET_DEADLINE = 2000
        const val NOTIFICATION_ID_TARGET_COMPLETED = 2500
        const val NOTIFICATION_ID_BACKUP_STARTED = 3000
        const val NOTIFICATION_ID_BACKUP_COMPLETED = 3100
        const val NOTIFICATION_ID_BACKUP_SCHEDULED = 3200
        const val NOTIFICATION_ID_WEEKLY_SUMMARY = 4000
    }
    
    init {
        createNotificationChannels()
    }
    
    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val followUpChannel = NotificationChannel(
                CHANNEL_ID_FOLLOW_UP,
                "Follow-up Reminders",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for follow-up activities"
            }
            
            val targetChannel = NotificationChannel(
                CHANNEL_ID_TARGET,
                "Target Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Notifications for target deadlines and completions"
            }
            
            val backupChannel = NotificationChannel(
                CHANNEL_ID_BACKUP,
                "Backup Notifications",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Notifications for backup status"
            }
            
            val summaryChannel = NotificationChannel(
                CHANNEL_ID_SUMMARY,
                "Summary Reports",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Weekly and monthly summary reports"
            }
            
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannels(listOf(
                followUpChannel,
                targetChannel,
                backupChannel,
                summaryChannel
            ))
        }
    }
    
    fun showFollowUpNotification(outreachActivity: OutreachActivity, contactName: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "outreach")
            putExtra("outreachId", outreachActivity.id)
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_FOLLOW_UP)
            .setSmallIcon(R.drawable.ic_outreach)
            .setContentTitle("Follow-up Reminder")
            .setContentText("Time to follow up with $contactName")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("You have a scheduled follow-up for your ${outreachActivity.type.name.lowercase()} with $contactName. Tap to view details."))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_FOLLOW_UP + outreachActivity.id.hashCode(), builder.build())
        }
    }
    
    fun showTargetDeadlineNotification(target: Target, daysRemaining: Int) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "targets")
            putExtra("targetId", target.id)
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_TARGET)
            .setSmallIcon(R.drawable.ic_targets)
            .setContentTitle("Target Deadline Approaching")
            .setContentText("${target.title} deadline in $daysRemaining days")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Your target '${target.title}' is due in $daysRemaining days. Current progress: ${target.progressPercentage.toInt()}%. Tap to view details."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_TARGET_DEADLINE + target.id.hashCode(), builder.build())
        }
    }
    
    fun showTargetCompletedNotification(target: Target) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "targets")
            putExtra("targetId", target.id)
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_TARGET)
            .setSmallIcon(R.drawable.ic_targets)
            .setContentTitle("Target Completed!")
            .setContentText("Congratulations! You've completed ${target.title}")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("Congratulations! You've successfully completed your target '${target.title}'. Tap to view details and set new targets."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_TARGET_COMPLETED + target.id.hashCode(), builder.build())
        }
    }
    
    fun showBackupCompletedNotification(success: Boolean, message: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "settings")
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val title = if (success) "Backup Completed" else "Backup Failed"
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_BACKUP)
            .setSmallIcon(R.drawable.ic_settings)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_BACKUP_COMPLETED, builder.build())
        }
    }
    
    fun showBackupStartedNotification(message: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "settings")
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_BACKUP)
            .setSmallIcon(R.drawable.ic_settings)
            .setContentTitle("Backup Started")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_BACKUP_STARTED, builder.build())
        }
    }
    
    fun showBackupScheduledNotification(enabled: Boolean, message: String) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "settings")
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val title = if (enabled) "Backup Scheduled" else "Backup Schedule Disabled"
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_BACKUP)
            .setSmallIcon(R.drawable.ic_settings)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_LOW)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_BACKUP_SCHEDULED, builder.build())
        }
    }
    
    fun showWeeklySummaryNotification(
        clientCount: Int,
        leadCount: Int,
        targetProgress: Float,
        outreachSuccessRate: Float
    ) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("destination", "dashboard")
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        val summaryText = "Weekly Summary:\n" +
                "u2022 Total Clients: $clientCount\n" +
                "u2022 Active Leads: $leadCount\n" +
                "u2022 Target Progress: ${targetProgress.toInt()}%\n" +
                "u2022 Outreach Success Rate: ${outreachSuccessRate.toInt()}%"
        
        val builder = NotificationCompat.Builder(context, CHANNEL_ID_SUMMARY)
            .setSmallIcon(R.drawable.ic_dashboard)
            .setContentTitle("Weekly Performance Summary")
            .setContentText("View your weekly performance metrics")
            .setStyle(NotificationCompat.BigTextStyle().bigText(summaryText))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
        
        with(NotificationManagerCompat.from(context)) {
            // TODO: Check for POST_NOTIFICATIONS permission on Android 13+ before calling notify()
            // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && !areNotificationsEnabled()) { /* Handle permission needed */ return }
            notify(NOTIFICATION_ID_WEEKLY_SUMMARY, builder.build())
        }
    }
}
