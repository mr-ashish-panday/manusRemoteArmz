package com.remotearmz.commandcenter.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.remotearmz.commandcenter.data.database.Converters;
import com.remotearmz.commandcenter.data.model.ContactType;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.OutreachOutcome;
import com.remotearmz.commandcenter.data.model.OutreachType;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class OutreachActivityDao_Impl implements OutreachActivityDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<OutreachActivity> __insertionAdapterOfOutreachActivity;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<OutreachActivity> __deletionAdapterOfOutreachActivity;

  private final EntityDeletionOrUpdateAdapter<OutreachActivity> __updateAdapterOfOutreachActivity;

  public OutreachActivityDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOutreachActivity = new EntityInsertionAdapter<OutreachActivity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `outreach_activities` (`id`,`type`,`contactId`,`contactType`,`outcome`,`notes`,`duration`,`followUpRequired`,`followUpDate`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OutreachActivity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        final String _tmp = __converters.fromOutreachType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, _tmp);
        }
        if (entity.getContactId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContactId());
        }
        final String _tmp_1 = __converters.fromContactType(entity.getContactType());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.fromOutreachOutcome(entity.getOutcome());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_2);
        }
        if (entity.getNotes() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getNotes());
        }
        statement.bindLong(7, entity.getDuration());
        final int _tmp_3 = entity.getFollowUpRequired() ? 1 : 0;
        statement.bindLong(8, _tmp_3);
        if (entity.getFollowUpDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getFollowUpDate());
        }
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfOutreachActivity = new EntityDeletionOrUpdateAdapter<OutreachActivity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `outreach_activities` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OutreachActivity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfOutreachActivity = new EntityDeletionOrUpdateAdapter<OutreachActivity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `outreach_activities` SET `id` = ?,`type` = ?,`contactId` = ?,`contactType` = ?,`outcome` = ?,`notes` = ?,`duration` = ?,`followUpRequired` = ?,`followUpDate` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final OutreachActivity entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        final String _tmp = __converters.fromOutreachType(entity.getType());
        if (_tmp == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, _tmp);
        }
        if (entity.getContactId() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getContactId());
        }
        final String _tmp_1 = __converters.fromContactType(entity.getContactType());
        if (_tmp_1 == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, _tmp_1);
        }
        final String _tmp_2 = __converters.fromOutreachOutcome(entity.getOutcome());
        if (_tmp_2 == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, _tmp_2);
        }
        if (entity.getNotes() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getNotes());
        }
        statement.bindLong(7, entity.getDuration());
        final int _tmp_3 = entity.getFollowUpRequired() ? 1 : 0;
        statement.bindLong(8, _tmp_3);
        if (entity.getFollowUpDate() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getFollowUpDate());
        }
        statement.bindLong(10, entity.getCreatedAt());
        if (entity.getId() == null) {
          statement.bindNull(11);
        } else {
          statement.bindString(11, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertOutreachActivity(final OutreachActivity outreachActivity,
      final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfOutreachActivity.insertAndReturnId(outreachActivity);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteOutreachActivity(final OutreachActivity outreachActivity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfOutreachActivity.handle(outreachActivity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateOutreachActivity(final OutreachActivity outreachActivity,
      final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfOutreachActivity.handle(outreachActivity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<OutreachActivity>> getAllOutreachActivities() {
    final String _sql = "SELECT * FROM outreach_activities ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getOutreachActivityById(final String outreachActivityId,
      final Continuation<? super OutreachActivity> continuation) {
    final String _sql = "SELECT * FROM outreach_activities WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (outreachActivityId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, outreachActivityId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<OutreachActivity>() {
      @Override
      @Nullable
      public OutreachActivity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final OutreachActivity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByContact(final String contactId,
      final ContactType contactType) {
    final String _sql = "SELECT * FROM outreach_activities WHERE contactId = ? AND contactType = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (contactId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contactId);
    }
    _argIndex = 2;
    final String _tmp = __converters.fromContactType(contactType);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp_1);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_2);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_3);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_4 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByType(final OutreachType type) {
    final String _sql = "SELECT * FROM outreach_activities WHERE type = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromOutreachType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp_1);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_2);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_3);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_4 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByOutcome(
      final OutreachOutcome outcome) {
    final String _sql = "SELECT * FROM outreach_activities WHERE outcome = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromOutreachOutcome(outcome);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp_1);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_2);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_3);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_4 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesRequiringFollowUp(
      final long currentTime) {
    final String _sql = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND (followUpDate IS NULL OR followUpDate <= ?) ORDER BY followUpDate ASC NULLS LAST";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getFollowUpsInRange(final long startTime,
      final long endTime) {
    final String _sql = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND followUpDate BETWEEN ? AND ? ORDER BY followUpDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startTime);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getFollowUpActivities() {
    final String _sql = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 ORDER BY followUpDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByDateRange(final long startDate,
      final long endDate) {
    final String _sql = "SELECT * FROM outreach_activities WHERE createdAt BETWEEN ? AND ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getOutreachCountByOutcome(final OutreachOutcome outcome) {
    final String _sql = "SELECT COUNT(*) FROM outreach_activities WHERE outcome = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromOutreachOutcome(outcome);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Map<OutreachOutcome, Integer>> getOutreachCountByOutcome() {
    final String _sql = "SELECT outcome, COUNT(*) as count FROM outreach_activities GROUP BY outcome";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Map<OutreachOutcome, Integer>>() {
      @Override
      @NonNull
      public Map<OutreachOutcome, Integer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Map<OutreachOutcome, Integer> _result = new LinkedHashMap<OutreachOutcome, Integer>();
          while (_cursor.moveToNext()) {
            final OutreachOutcome _key;
            _key = new OutreachOutcome();
            if () {
              _result.put(_key, null);
              continue;
            }
            final Integer _value;
            _value = new Integer(null);
            if (!_result.containsKey(_key)) {
              _result.put(_key, _value);
            }
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getOutreachCountByType(final OutreachType type) {
    final String _sql = "SELECT COUNT(*) FROM outreach_activities WHERE type = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromOutreachType(type);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Map<OutreachType, Integer>> getOutreachCountByType() {
    final String _sql = "SELECT type, COUNT(*) as count FROM outreach_activities GROUP BY type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Map<OutreachType, Integer>>() {
      @Override
      @NonNull
      public Map<OutreachType, Integer> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Map<OutreachType, Integer> _result = new LinkedHashMap<OutreachType, Integer>();
          while (_cursor.moveToNext()) {
            final OutreachType _key;
            _key = new OutreachType();
            if () {
              _result.put(_key, null);
              continue;
            }
            final Integer _value;
            _value = new Integer(null);
            if (!_result.containsKey(_key)) {
              _result.put(_key, _value);
            }
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getSuccessfulOutreachCount(final OutreachOutcome successOutcome) {
    final String _sql = "SELECT COUNT(*) FROM outreach_activities WHERE outcome = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromOutreachOutcome(successOutcome);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Integer> getTotalOutreachCount() {
    final String _sql = "SELECT COUNT(*) FROM outreach_activities";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> searchOutreachActivities(final String query) {
    final String _sql = "SELECT * FROM outreach_activities WHERE notes LIKE '%' || ? || '%' ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByContactId(final String contactId) {
    final String _sql = "SELECT * FROM outreach_activities WHERE contactId = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (contactId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contactId);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_1);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_3 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<OutreachActivity>> getOutreachActivitiesByContactType(
      final ContactType contactType) {
    final String _sql = "SELECT * FROM outreach_activities WHERE contactType = ? ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromContactType(contactType);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<List<OutreachActivity>>() {
      @Override
      @NonNull
      public List<OutreachActivity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfContactId = CursorUtil.getColumnIndexOrThrow(_cursor, "contactId");
          final int _cursorIndexOfContactType = CursorUtil.getColumnIndexOrThrow(_cursor, "contactType");
          final int _cursorIndexOfOutcome = CursorUtil.getColumnIndexOrThrow(_cursor, "outcome");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "duration");
          final int _cursorIndexOfFollowUpRequired = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpRequired");
          final int _cursorIndexOfFollowUpDate = CursorUtil.getColumnIndexOrThrow(_cursor, "followUpDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<OutreachActivity> _result = new ArrayList<OutreachActivity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final OutreachActivity _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final OutreachType _tmpType;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfType);
            }
            _tmpType = __converters.toOutreachType(_tmp_1);
            final String _tmpContactId;
            if (_cursor.isNull(_cursorIndexOfContactId)) {
              _tmpContactId = null;
            } else {
              _tmpContactId = _cursor.getString(_cursorIndexOfContactId);
            }
            final ContactType _tmpContactType;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfContactType)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfContactType);
            }
            _tmpContactType = __converters.toContactType(_tmp_2);
            final OutreachOutcome _tmpOutcome;
            final String _tmp_3;
            if (_cursor.isNull(_cursorIndexOfOutcome)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getString(_cursorIndexOfOutcome);
            }
            _tmpOutcome = __converters.toOutreachOutcome(_tmp_3);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final int _tmpDuration;
            _tmpDuration = _cursor.getInt(_cursorIndexOfDuration);
            final boolean _tmpFollowUpRequired;
            final int _tmp_4;
            _tmp_4 = _cursor.getInt(_cursorIndexOfFollowUpRequired);
            _tmpFollowUpRequired = _tmp_4 != 0;
            final Long _tmpFollowUpDate;
            if (_cursor.isNull(_cursorIndexOfFollowUpDate)) {
              _tmpFollowUpDate = null;
            } else {
              _tmpFollowUpDate = _cursor.getLong(_cursorIndexOfFollowUpDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new OutreachActivity(_tmpId,_tmpType,_tmpContactId,_tmpContactType,_tmpOutcome,_tmpNotes,_tmpDuration,_tmpFollowUpRequired,_tmpFollowUpDate,_tmpCreatedAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<Float> getOutreachSuccessRate() {
    final String _sql = "SELECT CASE WHEN COUNT(*) = 0 THEN 0 ELSE CAST(COUNT(CASE WHEN outcome = 'SUCCESSFUL' OR outcome = 'INTERESTED' THEN 1 END) AS FLOAT) / COUNT(*) * 100 END FROM outreach_activities";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"outreach_activities"}, new Callable<Float>() {
      @Override
      @NonNull
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getLastContactTime(final String contactId, final ContactType contactType,
      final Continuation<? super Long> continuation) {
    final String _sql = "SELECT MAX(createdAt) FROM outreach_activities WHERE contactId = ? AND contactType = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (contactId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, contactId);
    }
    _argIndex = 2;
    final String _tmp = __converters.fromContactType(contactType);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Long>() {
      @Override
      @Nullable
      public Long call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Long _result;
          if (_cursor.moveToFirst()) {
            final Long _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(0);
            }
            _result = _tmp_1;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, continuation);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
