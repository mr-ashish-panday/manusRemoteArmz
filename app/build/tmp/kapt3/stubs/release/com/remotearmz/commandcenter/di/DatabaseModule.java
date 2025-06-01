package com.remotearmz.commandcenter.di;

import android.content.Context;
import androidx.room.Room;
import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.database.RemoteArmzDatabase;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007J\u0012\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001dH\u0007\u00a8\u0006!"}, d2 = {"Lcom/remotearmz/commandcenter/di/DatabaseModule;", "", "()V", "provideActivityLogDao", "Lcom/remotearmz/commandcenter/data/dao/ActivityLogDao;", "database", "Lcom/remotearmz/commandcenter/data/database/RemoteArmzDatabase;", "provideActivityLogRepository", "Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "activityLogDao", "provideClientDao", "Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "provideClientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "clientDao", "provideDatabase", "context", "Landroid/content/Context;", "provideLeadDao", "Lcom/remotearmz/commandcenter/data/dao/LeadDao;", "provideLeadRepository", "Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "leadDao", "provideOutreachActivityDao", "Lcom/remotearmz/commandcenter/data/dao/OutreachActivityDao;", "provideOutreachActivityRepository", "Lcom/remotearmz/commandcenter/data/repository/OutreachActivityRepository;", "outreachActivityDao", "provideTargetDao", "Lcom/remotearmz/commandcenter/data/dao/TargetDao;", "provideTargetRepository", "Lcom/remotearmz/commandcenter/data/repository/TargetRepository;", "targetDao", "app_release"})
@dagger.Module
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.remotearmz.commandcenter.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.database.RemoteArmzDatabase provideDatabase(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.dao.ClientDao provideClientDao(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.dao.LeadDao provideLeadDao(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.dao.TargetDao provideTargetDao(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.dao.OutreachActivityDao provideOutreachActivityDao(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.dao.ActivityLogDao provideActivityLogDao(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.repository.ClientRepository provideClientRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.ClientDao clientDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.repository.LeadRepository provideLeadRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.LeadDao leadDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.repository.TargetRepository provideTargetRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.TargetDao targetDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.repository.OutreachActivityRepository provideOutreachActivityRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.OutreachActivityDao outreachActivityDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.remotearmz.commandcenter.data.repository.ActivityLogRepository provideActivityLogRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.ActivityLogDao activityLogDao) {
        return null;
    }
}