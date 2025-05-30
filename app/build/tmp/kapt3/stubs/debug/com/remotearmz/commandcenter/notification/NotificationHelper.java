package com.remotearmz.commandcenter.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.remotearmz.commandcenter.MainActivity;
import com.remotearmz.commandcenter.R;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.Target;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J&\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/remotearmz/commandcenter/notification/NotificationHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createNotificationChannels", "", "showBackupCompletedNotification", "success", "", "message", "", "showBackupScheduledNotification", "enabled", "showBackupStartedNotification", "showFollowUpNotification", "outreachActivity", "Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "contactName", "showTargetCompletedNotification", "target", "Lcom/remotearmz/commandcenter/data/model/Target;", "showTargetDeadlineNotification", "daysRemaining", "", "showWeeklySummaryNotification", "clientCount", "leadCount", "targetProgress", "", "outreachSuccessRate", "Companion", "app_debug"})
@javax.inject.Singleton()
public final class NotificationHelper {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.remotearmz.commandcenter.notification.NotificationHelper.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_FOLLOW_UP = "follow_up_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_TARGET = "target_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_BACKUP = "backup_channel";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CHANNEL_ID_SUMMARY = "summary_channel";
    public static final int NOTIFICATION_ID_FOLLOW_UP = 1000;
    public static final int NOTIFICATION_ID_TARGET_DEADLINE = 2000;
    public static final int NOTIFICATION_ID_TARGET_COMPLETED = 2500;
    public static final int NOTIFICATION_ID_BACKUP_STARTED = 3000;
    public static final int NOTIFICATION_ID_BACKUP_COMPLETED = 3100;
    public static final int NOTIFICATION_ID_BACKUP_SCHEDULED = 3200;
    public static final int NOTIFICATION_ID_WEEKLY_SUMMARY = 4000;
    
    @javax.inject.Inject()
    public NotificationHelper(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    private final void createNotificationChannels() {
    }
    
    public final void showFollowUpNotification(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull()
    java.lang.String contactName) {
    }
    
    public final void showTargetDeadlineNotification(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.Target target, int daysRemaining) {
    }
    
    public final void showTargetCompletedNotification(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.Target target) {
    }
    
    public final void showBackupCompletedNotification(boolean success, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showBackupStartedNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showBackupScheduledNotification(boolean enabled, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public final void showWeeklySummaryNotification(int clientCount, int leadCount, float targetProgress, float outreachSuccessRate) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/remotearmz/commandcenter/notification/NotificationHelper$Companion;", "", "()V", "CHANNEL_ID_BACKUP", "", "CHANNEL_ID_FOLLOW_UP", "CHANNEL_ID_SUMMARY", "CHANNEL_ID_TARGET", "NOTIFICATION_ID_BACKUP_COMPLETED", "", "NOTIFICATION_ID_BACKUP_SCHEDULED", "NOTIFICATION_ID_BACKUP_STARTED", "NOTIFICATION_ID_FOLLOW_UP", "NOTIFICATION_ID_TARGET_COMPLETED", "NOTIFICATION_ID_TARGET_DEADLINE", "NOTIFICATION_ID_WEEKLY_SUMMARY", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}