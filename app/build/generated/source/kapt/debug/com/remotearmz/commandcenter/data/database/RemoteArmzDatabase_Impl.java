package com.remotearmz.commandcenter.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.dao.ActivityLogDao_Impl;
import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.dao.ClientDao_Impl;
import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.dao.LeadDao_Impl;
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao_Impl;
import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.dao.TargetDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class RemoteArmzDatabase_Impl extends RemoteArmzDatabase {
  private volatile ClientDao _clientDao;

  private volatile LeadDao _leadDao;

  private volatile TargetDao _targetDao;

  private volatile OutreachActivityDao _outreachActivityDao;

  private volatile ActivityLogDao _activityLogDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `clients` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `company` TEXT NOT NULL, `phone` TEXT NOT NULL, `email` TEXT NOT NULL, `contractValueUSD` REAL NOT NULL, `status` TEXT NOT NULL, `tags` TEXT NOT NULL, `notes` TEXT NOT NULL, `lastContactDate` INTEGER, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `leads` (`id` TEXT NOT NULL, `contactName` TEXT NOT NULL, `company` TEXT NOT NULL, `phone` TEXT NOT NULL, `email` TEXT NOT NULL, `status` TEXT NOT NULL, `valueUSD` REAL NOT NULL, `probability` INTEGER NOT NULL, `source` TEXT NOT NULL, `expectedCloseDate` INTEGER, `clientId` TEXT, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `targets` (`id` TEXT NOT NULL, `title` TEXT NOT NULL, `category` TEXT NOT NULL, `targetValue` REAL NOT NULL, `currentValue` REAL NOT NULL, `deadline` INTEGER NOT NULL, `description` TEXT NOT NULL, `priority` TEXT NOT NULL, `isCompleted` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `outreach_activities` (`id` TEXT NOT NULL, `type` TEXT NOT NULL, `contactId` TEXT NOT NULL, `contactType` TEXT NOT NULL, `outcome` TEXT NOT NULL, `notes` TEXT NOT NULL, `duration` INTEGER NOT NULL, `followUpRequired` INTEGER NOT NULL, `followUpDate` INTEGER, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS `activity_logs` (`id` TEXT NOT NULL, `action` TEXT NOT NULL, `details` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `userId` TEXT NOT NULL, PRIMARY KEY(`id`))");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'cd765a90b0e23571f8412f130a97b3e8')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `clients`");
        db.execSQL("DROP TABLE IF EXISTS `leads`");
        db.execSQL("DROP TABLE IF EXISTS `targets`");
        db.execSQL("DROP TABLE IF EXISTS `outreach_activities`");
        db.execSQL("DROP TABLE IF EXISTS `activity_logs`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsClients = new HashMap<String, TableInfo.Column>(12);
        _columnsClients.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("company", new TableInfo.Column("company", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("contractValueUSD", new TableInfo.Column("contractValueUSD", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("tags", new TableInfo.Column("tags", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("lastContactDate", new TableInfo.Column("lastContactDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClients.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClients = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClients = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClients = new TableInfo("clients", _columnsClients, _foreignKeysClients, _indicesClients);
        final TableInfo _existingClients = TableInfo.read(db, "clients");
        if (!_infoClients.equals(_existingClients)) {
          return new RoomOpenHelper.ValidationResult(false, "clients(com.remotearmz.commandcenter.data.model.Client).\n"
                  + " Expected:\n" + _infoClients + "\n"
                  + " Found:\n" + _existingClients);
        }
        final HashMap<String, TableInfo.Column> _columnsLeads = new HashMap<String, TableInfo.Column>(13);
        _columnsLeads.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("contactName", new TableInfo.Column("contactName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("company", new TableInfo.Column("company", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("phone", new TableInfo.Column("phone", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("valueUSD", new TableInfo.Column("valueUSD", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("probability", new TableInfo.Column("probability", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("source", new TableInfo.Column("source", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("expectedCloseDate", new TableInfo.Column("expectedCloseDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("clientId", new TableInfo.Column("clientId", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLeads.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLeads = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLeads = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLeads = new TableInfo("leads", _columnsLeads, _foreignKeysLeads, _indicesLeads);
        final TableInfo _existingLeads = TableInfo.read(db, "leads");
        if (!_infoLeads.equals(_existingLeads)) {
          return new RoomOpenHelper.ValidationResult(false, "leads(com.remotearmz.commandcenter.data.model.Lead).\n"
                  + " Expected:\n" + _infoLeads + "\n"
                  + " Found:\n" + _existingLeads);
        }
        final HashMap<String, TableInfo.Column> _columnsTargets = new HashMap<String, TableInfo.Column>(10);
        _columnsTargets.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("targetValue", new TableInfo.Column("targetValue", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("currentValue", new TableInfo.Column("currentValue", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("deadline", new TableInfo.Column("deadline", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("priority", new TableInfo.Column("priority", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("isCompleted", new TableInfo.Column("isCompleted", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTargets.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTargets = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTargets = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTargets = new TableInfo("targets", _columnsTargets, _foreignKeysTargets, _indicesTargets);
        final TableInfo _existingTargets = TableInfo.read(db, "targets");
        if (!_infoTargets.equals(_existingTargets)) {
          return new RoomOpenHelper.ValidationResult(false, "targets(com.remotearmz.commandcenter.data.model.Target).\n"
                  + " Expected:\n" + _infoTargets + "\n"
                  + " Found:\n" + _existingTargets);
        }
        final HashMap<String, TableInfo.Column> _columnsOutreachActivities = new HashMap<String, TableInfo.Column>(10);
        _columnsOutreachActivities.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("contactId", new TableInfo.Column("contactId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("contactType", new TableInfo.Column("contactType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("outcome", new TableInfo.Column("outcome", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("duration", new TableInfo.Column("duration", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("followUpRequired", new TableInfo.Column("followUpRequired", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("followUpDate", new TableInfo.Column("followUpDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOutreachActivities.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOutreachActivities = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOutreachActivities = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOutreachActivities = new TableInfo("outreach_activities", _columnsOutreachActivities, _foreignKeysOutreachActivities, _indicesOutreachActivities);
        final TableInfo _existingOutreachActivities = TableInfo.read(db, "outreach_activities");
        if (!_infoOutreachActivities.equals(_existingOutreachActivities)) {
          return new RoomOpenHelper.ValidationResult(false, "outreach_activities(com.remotearmz.commandcenter.data.model.OutreachActivity).\n"
                  + " Expected:\n" + _infoOutreachActivities + "\n"
                  + " Found:\n" + _existingOutreachActivities);
        }
        final HashMap<String, TableInfo.Column> _columnsActivityLogs = new HashMap<String, TableInfo.Column>(5);
        _columnsActivityLogs.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("action", new TableInfo.Column("action", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("details", new TableInfo.Column("details", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsActivityLogs.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysActivityLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesActivityLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoActivityLogs = new TableInfo("activity_logs", _columnsActivityLogs, _foreignKeysActivityLogs, _indicesActivityLogs);
        final TableInfo _existingActivityLogs = TableInfo.read(db, "activity_logs");
        if (!_infoActivityLogs.equals(_existingActivityLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "activity_logs(com.remotearmz.commandcenter.data.model.ActivityLog).\n"
                  + " Expected:\n" + _infoActivityLogs + "\n"
                  + " Found:\n" + _existingActivityLogs);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "cd765a90b0e23571f8412f130a97b3e8", "45aeb01e9a2f20fc2b669d809f8c8f6e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "clients","leads","targets","outreach_activities","activity_logs");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `clients`");
      _db.execSQL("DELETE FROM `leads`");
      _db.execSQL("DELETE FROM `targets`");
      _db.execSQL("DELETE FROM `outreach_activities`");
      _db.execSQL("DELETE FROM `activity_logs`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ClientDao.class, ClientDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(LeadDao.class, LeadDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TargetDao.class, TargetDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OutreachActivityDao.class, OutreachActivityDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ActivityLogDao.class, ActivityLogDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ClientDao clientDao() {
    if (_clientDao != null) {
      return _clientDao;
    } else {
      synchronized(this) {
        if(_clientDao == null) {
          _clientDao = new ClientDao_Impl(this);
        }
        return _clientDao;
      }
    }
  }

  @Override
  public LeadDao leadDao() {
    if (_leadDao != null) {
      return _leadDao;
    } else {
      synchronized(this) {
        if(_leadDao == null) {
          _leadDao = new LeadDao_Impl(this);
        }
        return _leadDao;
      }
    }
  }

  @Override
  public TargetDao targetDao() {
    if (_targetDao != null) {
      return _targetDao;
    } else {
      synchronized(this) {
        if(_targetDao == null) {
          _targetDao = new TargetDao_Impl(this);
        }
        return _targetDao;
      }
    }
  }

  @Override
  public OutreachActivityDao outreachActivityDao() {
    if (_outreachActivityDao != null) {
      return _outreachActivityDao;
    } else {
      synchronized(this) {
        if(_outreachActivityDao == null) {
          _outreachActivityDao = new OutreachActivityDao_Impl(this);
        }
        return _outreachActivityDao;
      }
    }
  }

  @Override
  public ActivityLogDao activityLogDao() {
    if (_activityLogDao != null) {
      return _activityLogDao;
    } else {
      synchronized(this) {
        if(_activityLogDao == null) {
          _activityLogDao = new ActivityLogDao_Impl(this);
        }
        return _activityLogDao;
      }
    }
  }
}
