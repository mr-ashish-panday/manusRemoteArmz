package com.remotearmz.commandcenter.di;

import android.content.Context;
import androidx.room.Room;
import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.database.RemoteArmzDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\fH\u0007\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0007J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/remotearmz/commandcenter/di/DatabaseModule;", "", "()V", "provideActivityLogDao", "error/NonExistentClass", "database", "Lcom/remotearmz/commandcenter/data/database/RemoteArmzDatabase;", "(Lcom/remotearmz/commandcenter/data/database/RemoteArmzDatabase;)Lerror/NonExistentClass;", "provideActivityLogRepository", "activityLogDao", "(Lerror/NonExistentClass;)Lerror/NonExistentClass;", "provideClientDao", "Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "provideClientRepository", "clientDao", "(Lcom/remotearmz/commandcenter/data/dao/ClientDao;)Lerror/NonExistentClass;", "provideDatabase", "context", "Landroid/content/Context;", "provideLeadDao", "provideLeadRepository", "leadDao", "provideOutreachActivityDao", "provideOutreachActivityRepository", "outreachActivityDao", "provideTargetDao", "provideTargetRepository", "targetDao", "app_debug"})
@dagger.Module()
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.remotearmz.commandcenter.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.remotearmz.commandcenter.data.database.RemoteArmzDatabase provideDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final com.remotearmz.commandcenter.data.dao.ClientDao provideClientDao(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final LeadDao provideLeadDao(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final TargetDao provideTargetDao(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final OutreachActivityDao provideOutreachActivityDao(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final ActivityLogDao provideActivityLogDao(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.database.RemoteArmzDatabase database) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final ClientRepository provideClientRepository(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.dao.ClientDao clientDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final LeadRepository provideLeadRepository(@org.jetbrains.annotations.NotNull()
    LeadDao leadDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final TargetRepository provideTargetRepository(@org.jetbrains.annotations.NotNull()
    TargetDao targetDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final OutreachActivityRepository provideOutreachActivityRepository(@org.jetbrains.annotations.NotNull()
    OutreachActivityDao outreachActivityDao) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final ActivityLogRepository provideActivityLogRepository(@org.jetbrains.annotations.NotNull()
    ActivityLogDao activityLogDao) {
        return null;
    }
}