package com.remotearmz.commandcenter.di

import android.content.Context
import com.remotearmz.commandcenter.notification.NotificationHelper
import com.remotearmz.commandcenter.notification.NotificationManager
import com.remotearmz.commandcenter.util.CsvExporter
import com.remotearmz.commandcenter.util.DateCountdownUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
    @Provides
    @Singleton
    fun provideNotificationHelper(
        @ApplicationContext context: Context
    ): NotificationHelper = NotificationHelper(context)
    
    @Provides
    @Singleton
    fun provideNotificationManager(
        @ApplicationContext context: Context
    ): NotificationManager = NotificationManager(context)
    
    @Provides
    @Singleton
    fun provideCsvExporter(
        @ApplicationContext context: Context
    ): CsvExporter = CsvExporter(context)
}
