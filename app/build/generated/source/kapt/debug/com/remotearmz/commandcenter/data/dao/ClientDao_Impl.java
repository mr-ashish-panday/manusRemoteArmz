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
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import java.lang.Class;
import java.lang.Exception;
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
public final class ClientDao_Impl implements ClientDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Client> __insertionAdapterOfClient;

  private final Converters __converters = new Converters();

  private final EntityDeletionOrUpdateAdapter<Client> __deletionAdapterOfClient;

  private final EntityDeletionOrUpdateAdapter<Client> __updateAdapterOfClient;

  public ClientDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClient = new EntityInsertionAdapter<Client>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `clients` (`id`,`name`,`company`,`phone`,`email`,`contractValueUSD`,`status`,`tags`,`notes`,`lastContactDate`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Client entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCompany() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCompany());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEmail());
        }
        statement.bindDouble(6, entity.getContractValueUSD());
        final String _tmp = __converters.fromClientStatus(entity.getStatus());
        if (_tmp == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getTags());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        if (entity.getNotes() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNotes());
        }
        if (entity.getLastContactDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getLastContactDate());
        }
        statement.bindLong(11, entity.getCreatedAt());
        statement.bindLong(12, entity.getUpdatedAt());
      }
    };
    this.__deletionAdapterOfClient = new EntityDeletionOrUpdateAdapter<Client>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `clients` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Client entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfClient = new EntityDeletionOrUpdateAdapter<Client>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `clients` SET `id` = ?,`name` = ?,`company` = ?,`phone` = ?,`email` = ?,`contractValueUSD` = ?,`status` = ?,`tags` = ?,`notes` = ?,`lastContactDate` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Client entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getId());
        }
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getCompany() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getCompany());
        }
        if (entity.getPhone() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPhone());
        }
        if (entity.getEmail() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getEmail());
        }
        statement.bindDouble(6, entity.getContractValueUSD());
        final String _tmp = __converters.fromClientStatus(entity.getStatus());
        if (_tmp == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, _tmp);
        }
        final String _tmp_1 = __converters.fromStringList(entity.getTags());
        if (_tmp_1 == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, _tmp_1);
        }
        if (entity.getNotes() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getNotes());
        }
        if (entity.getLastContactDate() == null) {
          statement.bindNull(10);
        } else {
          statement.bindLong(10, entity.getLastContactDate());
        }
        statement.bindLong(11, entity.getCreatedAt());
        statement.bindLong(12, entity.getUpdatedAt());
        if (entity.getId() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getId());
        }
      }
    };
  }

  @Override
  public Object insertClient(final Client client, final Continuation<? super Long> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfClient.insertAndReturnId(client);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteClient(final Client client, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfClient.handle(client);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateClient(final Client client, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfClient.handle(client);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Client>> getAllClients() {
    final String _sql = "SELECT `clients`.`id` AS `id`, `clients`.`name` AS `name`, `clients`.`company` AS `company`, `clients`.`phone` AS `phone`, `clients`.`email` AS `email`, `clients`.`contractValueUSD` AS `contractValueUSD`, `clients`.`status` AS `status`, `clients`.`tags` AS `tags`, `clients`.`notes` AS `notes`, `clients`.`lastContactDate` AS `lastContactDate`, `clients`.`createdAt` AS `createdAt`, `clients`.`updatedAt` AS `updatedAt` FROM clients ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clients"}, new Callable<List<Client>>() {
      @Override
      @NonNull
      public List<Client> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = 0;
          final int _cursorIndexOfName = 1;
          final int _cursorIndexOfCompany = 2;
          final int _cursorIndexOfPhone = 3;
          final int _cursorIndexOfEmail = 4;
          final int _cursorIndexOfContractValueUSD = 5;
          final int _cursorIndexOfStatus = 6;
          final int _cursorIndexOfTags = 7;
          final int _cursorIndexOfNotes = 8;
          final int _cursorIndexOfLastContactDate = 9;
          final int _cursorIndexOfCreatedAt = 10;
          final int _cursorIndexOfUpdatedAt = 11;
          final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Client _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getString(_cursorIndexOfCompany);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final double _tmpContractValueUSD;
            _tmpContractValueUSD = _cursor.getDouble(_cursorIndexOfContractValueUSD);
            final ClientStatus _tmpStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toClientStatus(_tmp);
            final List<String> _tmpTags;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __converters.toStringList(_tmp_1);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final Long _tmpLastContactDate;
            if (_cursor.isNull(_cursorIndexOfLastContactDate)) {
              _tmpLastContactDate = null;
            } else {
              _tmpLastContactDate = _cursor.getLong(_cursorIndexOfLastContactDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Client(_tmpId,_tmpName,_tmpCompany,_tmpPhone,_tmpEmail,_tmpContractValueUSD,_tmpStatus,_tmpTags,_tmpNotes,_tmpLastContactDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Object getClientById(final String clientId,
      final Continuation<? super Client> continuation) {
    final String _sql = "SELECT * FROM clients WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (clientId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, clientId);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Client>() {
      @Override
      @Nullable
      public Client call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCompany = CursorUtil.getColumnIndexOrThrow(_cursor, "company");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContractValueUSD = CursorUtil.getColumnIndexOrThrow(_cursor, "contractValueUSD");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfLastContactDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastContactDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final Client _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getString(_cursorIndexOfCompany);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final double _tmpContractValueUSD;
            _tmpContractValueUSD = _cursor.getDouble(_cursorIndexOfContractValueUSD);
            final ClientStatus _tmpStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toClientStatus(_tmp);
            final List<String> _tmpTags;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __converters.toStringList(_tmp_1);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final Long _tmpLastContactDate;
            if (_cursor.isNull(_cursorIndexOfLastContactDate)) {
              _tmpLastContactDate = null;
            } else {
              _tmpLastContactDate = _cursor.getLong(_cursorIndexOfLastContactDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _result = new Client(_tmpId,_tmpName,_tmpCompany,_tmpPhone,_tmpEmail,_tmpContractValueUSD,_tmpStatus,_tmpTags,_tmpNotes,_tmpLastContactDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Client>> searchClients(final String query) {
    final String _sql = "SELECT * FROM clients WHERE name LIKE '%' || ? || '%' OR company LIKE '%' || ? || '%'";
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
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clients"}, new Callable<List<Client>>() {
      @Override
      @NonNull
      public List<Client> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCompany = CursorUtil.getColumnIndexOrThrow(_cursor, "company");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContractValueUSD = CursorUtil.getColumnIndexOrThrow(_cursor, "contractValueUSD");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfLastContactDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastContactDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Client _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getString(_cursorIndexOfCompany);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final double _tmpContractValueUSD;
            _tmpContractValueUSD = _cursor.getDouble(_cursorIndexOfContractValueUSD);
            final ClientStatus _tmpStatus;
            final String _tmp;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toClientStatus(_tmp);
            final List<String> _tmpTags;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __converters.toStringList(_tmp_1);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final Long _tmpLastContactDate;
            if (_cursor.isNull(_cursorIndexOfLastContactDate)) {
              _tmpLastContactDate = null;
            } else {
              _tmpLastContactDate = _cursor.getLong(_cursorIndexOfLastContactDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Client(_tmpId,_tmpName,_tmpCompany,_tmpPhone,_tmpEmail,_tmpContractValueUSD,_tmpStatus,_tmpTags,_tmpNotes,_tmpLastContactDate,_tmpCreatedAt,_tmpUpdatedAt);
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
  public Flow<List<Client>> getClientsByStatus(final ClientStatus status) {
    final String _sql = "SELECT * FROM clients WHERE status = ? ORDER BY name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final String _tmp = __converters.fromClientStatus(status);
    if (_tmp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, _tmp);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clients"}, new Callable<List<Client>>() {
      @Override
      @NonNull
      public List<Client> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfCompany = CursorUtil.getColumnIndexOrThrow(_cursor, "company");
          final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfContractValueUSD = CursorUtil.getColumnIndexOrThrow(_cursor, "contractValueUSD");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfTags = CursorUtil.getColumnIndexOrThrow(_cursor, "tags");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfLastContactDate = CursorUtil.getColumnIndexOrThrow(_cursor, "lastContactDate");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
          final List<Client> _result = new ArrayList<Client>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Client _item;
            final String _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getString(_cursorIndexOfId);
            }
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpCompany;
            if (_cursor.isNull(_cursorIndexOfCompany)) {
              _tmpCompany = null;
            } else {
              _tmpCompany = _cursor.getString(_cursorIndexOfCompany);
            }
            final String _tmpPhone;
            if (_cursor.isNull(_cursorIndexOfPhone)) {
              _tmpPhone = null;
            } else {
              _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
            }
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final double _tmpContractValueUSD;
            _tmpContractValueUSD = _cursor.getDouble(_cursorIndexOfContractValueUSD);
            final ClientStatus _tmpStatus;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfStatus);
            }
            _tmpStatus = __converters.toClientStatus(_tmp_1);
            final List<String> _tmpTags;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfTags)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfTags);
            }
            _tmpTags = __converters.toStringList(_tmp_2);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final Long _tmpLastContactDate;
            if (_cursor.isNull(_cursorIndexOfLastContactDate)) {
              _tmpLastContactDate = null;
            } else {
              _tmpLastContactDate = _cursor.getLong(_cursorIndexOfLastContactDate);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            final long _tmpUpdatedAt;
            _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt);
            _item = new Client(_tmpId,_tmpName,_tmpCompany,_tmpPhone,_tmpEmail,_tmpContractValueUSD,_tmpStatus,_tmpTags,_tmpNotes,_tmpLastContactDate,_tmpCreatedAt,_tmpUpdatedAt);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
