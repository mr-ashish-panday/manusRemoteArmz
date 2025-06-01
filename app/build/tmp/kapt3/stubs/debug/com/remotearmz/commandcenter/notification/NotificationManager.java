package com.remotearmz.commandcenter.notification;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.WorkManager;
import dagger.hilt.android.qualifiers.ApplicationContext;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/remotearmz/commandcenter/notification/NotificationManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelAllNotifications", "", "checkNotificationsNow", "scheduleDailyNotifications", "app_debug"})
@javax.inject.Singleton
public final class NotificationManager {
    private final android.content.Context context = null;
    
    @javax.inject.Inject
    public NotificationManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    /**
     * Schedule daily notification checks for follow-ups, target deadlines, etc.
     */
    public final void scheduleDailyNotifications() {
    }
    
    /**
     * Cancel all scheduled notifications
     */
    public final void cancelAllNotifications() {
    }
    
    /**
     * Check for notifications immediately (for testing or manual refresh)
     */
    public final void checkNotificationsNow() {
    }
}