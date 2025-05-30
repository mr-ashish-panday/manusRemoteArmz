package com.remotearmz.commandcenter.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.remotearmz.commandcenter.data.dao.ActivityLogDao
import com.remotearmz.commandcenter.data.dao.ClientDao
import com.remotearmz.commandcenter.data.dao.LeadDao
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao
import com.remotearmz.commandcenter.data.dao.TargetDao
import com.remotearmz.commandcenter.data.model.ActivityLog
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.Target

@Database(
    entities = [
        Client::class,
        Lead::class,
        Target::class,
        OutreachActivity::class,
        ActivityLog::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RemoteArmzDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun leadDao(): LeadDao
    abstract fun targetDao(): TargetDao
    abstract fun outreachActivityDao(): OutreachActivityDao
    abstract fun activityLogDao(): ActivityLogDao
}
