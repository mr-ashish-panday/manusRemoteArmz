package com.remotearmz.commandcenter.di

import android.content.Context
import androidx.room.Room
import com.remotearmz.commandcenter.data.dao.ClientDao
import com.remotearmz.commandcenter.data.database.RemoteArmzDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RemoteArmzDatabase {
        return Room.databaseBuilder(
            context,
            RemoteArmzDatabase::class.java,
            "remotearmz_database"
        ).fallbackToDestructiveMigration().build()
    }
    
    // Provide DAOs
    @Provides
    fun provideClientDao(database: RemoteArmzDatabase): ClientDao = database.clientDao()
    
    @Provides
    fun provideLeadDao(database: RemoteArmzDatabase): LeadDao = database.leadDao()
    
    @Provides
    fun provideTargetDao(database: RemoteArmzDatabase): TargetDao = database.targetDao()
    
    @Provides
    fun provideOutreachActivityDao(database: RemoteArmzDatabase): OutreachActivityDao = database.outreachActivityDao()
    
    @Provides
    fun provideActivityLogDao(database: RemoteArmzDatabase): ActivityLogDao = database.activityLogDao()
    
    // Provide Repositories
    @Provides
    @Singleton
    fun provideClientRepository(clientDao: ClientDao): ClientRepository = ClientRepository(clientDao)
    
    @Provides
    @Singleton
    fun provideLeadRepository(leadDao: LeadDao): LeadRepository = LeadRepository(leadDao)
    
    @Provides
    @Singleton
    fun provideTargetRepository(targetDao: TargetDao): TargetRepository = TargetRepository(targetDao)
    
    @Provides
    @Singleton
    fun provideOutreachActivityRepository(outreachActivityDao: OutreachActivityDao): OutreachActivityRepository = 
        OutreachActivityRepository(outreachActivityDao)
    
    @Provides
    @Singleton
    fun provideActivityLogRepository(activityLogDao: ActivityLogDao): ActivityLogRepository = 
        ActivityLogRepository(activityLogDao)
}
