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
import com.remotearmz.commandcenter.data.model.Priority;
import com.remotearmz.commandcenter.data.model.Target;
import com.remotearmz.commandcenter.data.model.TargetCategory;
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
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TargetDao_Impl implements TargetDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Target> __insertionAdapterOfTarget;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Target> __deletionAdapterOfTarget;

  private final EntityDeletionOrUpdateAdapter<Target> __updateAdapterOfTarget;

  public TargetDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTarget = new EntityInsertionAdapter<Target>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `targets` (`id`,`title`,`category`,`targetValue`,`currentValue`,`deadline`,`description`,`priority`,`isCompleted`,`createdAt`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Target entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        final String _tmp = __converters.fromTargetCategory(entity.getCategory());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        statement.bindDouble(4, entity.getTargetValue());
        statement.bindDouble(5, entity.getCurrentValue());
        statement.bindLong(6, entity.getDeadline());
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription());
        }
        final String _tmp_1 = __converters.fromPriority(entity.getPriority());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        final int _tmp_2 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(9, _tmp_2);
        statement.bindLong(10, entity.getCreatedAt());
      }
    };
    this.__deletionAdapterOfTarget = new EntityDeletionOrUpdateAdapter<Target>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `targets` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Target entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfTarget = new EntityDeletionOrUpdateAdapter<Target>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `targets` SET `id` = ?,`title` = ?,`category` = ?,`targetValue` = ?,`currentValue` = ?,`deadline` = ?,`description` = ?,`priority` = ?,`isCompleted` = ?,`createdAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Target entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        final String _tmp = __converters.fromTargetCategory(entity.getCategory());
        if (_tmp == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, _tmp);
        }
        statement.bindDouble(4, entity.getTargetValue());
        statement.bindDouble(5, entity.getCurrentValue());
        statement.bindLong(6, entity.getDeadline());
        if (entity.getDescription() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getDescription());
        }
        final String _tmp_1 = __converters.fromPriority(entity.getPriority());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        final int _tmp_2 = entity.isCompleted() ? 1 : 0;
        statement.bindLong(9, _tmp_2);
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
  public Object insertTarget(final Target target, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfTarget.insertAndReturnId(target);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteTarget(final Target target, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfTarget.handle(target);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateTarget(final Target target, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfTarget.handle(target);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Target>> getAllTargets() {
    final String _sql = "SELECT `targets`.`id` AS `id`, `targets`.`title` AS `title`, `targets`.`category` AS `category`, `targets`.`targetValue` AS `targetValue`, `targets`.`currentValue` AS `currentValue`, `targets`.`deadline` AS `deadline`, `targets`.`description` AS `description`, `targets`.`priority` AS `priority`, `targets`.`isCompleted` AS `isCompleted`, `targets`.`createdAt` AS `createdAt` FROM targets ORDER BY deadline ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfTitle = 1;
          final int _cursorIndexOfCategory = 2;
          final int _cursorIndexOfTargetValue = 3;
          final int _cursorIndexOfCurrentValue = 4;
          final int _cursorIndexOfDeadline = 5;
          final int _cursorIndexOfDescription = 6;
          final int _cursorIndexOfPriority = 7;
          final int _cursorIndexOfIsCompleted = 8;
          final int _cursorIndexOfCreatedAt = 9;
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Object getTargetById(final String targetId,
      final Continuation<? super Target> continuation) {
    final String _sql = "SELECT * FROM targets WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (targetId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, targetId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Target>() {
      @Override
      @Nullable
      public Target call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final Target _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _result = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<List<Target>> getTargetsByCategory(final TargetCategory category) {
    final String _sql = "SELECT * FROM targets WHERE category = ? ORDER BY deadline ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromTargetCategory(category);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp_1);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_2);
            final boolean _tmpIsCompleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_3 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<List<Target>> getTargetsByCompletionStatus(final boolean isCompleted) {
    final String _sql = "SELECT * FROM targets WHERE isCompleted = ? ORDER BY deadline ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isCompleted ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp_1);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_2);
            final boolean _tmpIsCompleted;
            final int _tmp_3;
            _tmp_3 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_3 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<List<Target>> getTargetsByDeadlineRange(final long startDate, final long endDate) {
    final String _sql = "SELECT * FROM targets WHERE deadline BETWEEN ? AND ? ORDER BY deadline ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, startDate);
    _argIndex = 2;
    _statement.bindLong(_argIndex, endDate);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<List<Target>> searchTargets(final String query) {
    final String _sql = "SELECT * FROM targets WHERE title LIKE '%' || ? || '%' OR description LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<Integer> getCompletedTargetCount() {
    final String _sql = "SELECT COUNT(*) FROM targets WHERE isCompleted = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<Integer>() {
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
  public Flow<Integer> getTotalTargetCount() {
    final String _sql = "SELECT COUNT(*) FROM targets";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<Integer>() {
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
  public Flow<List<Target>> getUpcomingTargets(final long currentTime) {
    final String _sql = "SELECT * FROM targets WHERE deadline > ? AND isCompleted = 0 ORDER BY deadline ASC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<List<Target>> getOverdueTargets(final long currentTime) {
    final String _sql = "SELECT * FROM targets WHERE deadline < ? AND isCompleted = 0 ORDER BY deadline ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<List<Target>>() {
      @Override
      @NonNull
      public List<Target> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfTargetValue = CursorUtil.getColumnIndexOrThrow(_cursor, "targetValue");
          final int _cursorIndexOfCurrentValue = CursorUtil.getColumnIndexOrThrow(_cursor, "currentValue");
          final int _cursorIndexOfDeadline = CursorUtil.getColumnIndexOrThrow(_cursor, "deadline");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPriority = CursorUtil.getColumnIndexOrThrow(_cursor, "priority");
          final int _cursorIndexOfIsCompleted = CursorUtil.getColumnIndexOrThrow(_cursor, "isCompleted");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<Target> _result = new ArrayList<Target>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Target _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final TargetCategory _tmpCategory;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfCategory);
            }
            _tmpCategory = __converters.toTargetCategory(_tmp);
            final double _tmpTargetValue;
            _tmpTargetValue = _cursor.getDouble(_cursorIndexOfTargetValue);
            final double _tmpCurrentValue;
            _tmpCurrentValue = _cursor.getDouble(_cursorIndexOfCurrentValue);
            final long _tmpDeadline;
            _tmpDeadline = _cursor.getLong(_cursorIndexOfDeadline);
            final String _tmpDescription;
            if (_cursor.isNull(_cursorIndexOfDescription)) {
              _tmpDescription = null;
            } else {
              _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            }
            final Priority _tmpPriority;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfPriority)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfPriority);
            }
            _tmpPriority = __converters.toPriority(_tmp_1);
            final boolean _tmpIsCompleted;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsCompleted);
            _tmpIsCompleted = _tmp_2 != 0;
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new Target(_tmpId,_tmpTitle,_tmpCategory,_tmpTargetValue,_tmpCurrentValue,_tmpDeadline,_tmpDescription,_tmpPriority,_tmpIsCompleted,_tmpCreatedAt);
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
  public Flow<Float> getAverageProgressByCategory(final TargetCategory category) {
    final String _sql = "SELECT AVG(currentValue / targetValue * 100) FROM targets WHERE category = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromTargetCategory(category);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"targets"}, new Callable<Float>() {
      @Override
      @Nullable
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getFloat(0);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
