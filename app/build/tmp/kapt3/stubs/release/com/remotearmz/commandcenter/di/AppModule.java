package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.remotearmz.commandcenter.notification.NotificationHelper;
import com.remotearmz.commandcenter.notification.NotificationManager;
import com.remotearmz.commandcenter.util.CsvExporter;
import com.remotearmz.commandcenter.util.DateCountdownUtil;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/remotearmz/commandcenter/di/AppModule;", "", "()V", "provideCsvExporter", "Lcom/remotearmz/commandcenter/util/CsvExporter;", "context", "Landroid/content/Context;", "provideNotificationHelper", "Lcom/remotearmz/commandcenter/notification/NotificationHelper;", "provideNotificationManager", "Lcom/remotearmz/commandcenter/notification/NotificationManager;", "app_release"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.remotearmz.commandcenter.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.notification.NotificationHelper provideNotificationHelper(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.notification.NotificationManager provideNotificationManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.util.CsvExporter provideCsvExporter(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
}