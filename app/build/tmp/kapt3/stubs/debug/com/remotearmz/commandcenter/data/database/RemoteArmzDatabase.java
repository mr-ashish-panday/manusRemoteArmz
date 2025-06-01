package com.remotearmz.commandcenter.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.model.ActivityLog;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.Target;

@androidx.room.TypeConverters(value = {com.remotearmz.commandcenter.data.database.Converters.class})
@androidx.room.Database(entities = {com.remotearmz.commandcenter.data.model.Client.class, com.remotearmz.commandcenter.data.model.Lead.class, com.remotearmz.commandcenter.data.model.Target.class, com.remotearmz.commandcenter.data.model.OutreachActivity.class, com.remotearmz.commandcenter.data.model.ActivityLog.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/remotearmz/commandcenter/data/database/RemoteArmzDatabase;", "Landroidx/room/RoomDatabase;", "()V", "activityLogDao", "Lcom/remotearmz/commandcenter/data/dao/ActivityLogDao;", "clientDao", "Lcom/remotearmz/commandcenter/data/dao/ClientDao;", "leadDao", "Lcom/remotearmz/commandcenter/data/dao/LeadDao;", "outreachActivityDao", "Lcom/remotearmz/commandcenter/data/dao/OutreachActivityDao;", "targetDao", "Lcom/remotearmz/commandcenter/data/dao/TargetDao;", "app_debug"})
public abstract class RemoteArmzDatabase extends androidx.room.RoomDatabase {
    
    public RemoteArmzDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.remotearmz.commandcenter.data.dao.ClientDao clientDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.remotearmz.commandcenter.data.dao.LeadDao leadDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.remotearmz.commandcenter.data.dao.TargetDao targetDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.remotearmz.commandcenter.data.dao.OutreachActivityDao outreachActivityDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.remotearmz.commandcenter.data.dao.ActivityLogDao activityLogDao();
}