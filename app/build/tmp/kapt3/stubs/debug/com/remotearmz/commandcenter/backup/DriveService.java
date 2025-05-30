package com.remotearmz.commandcenter.backup;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.remotearmz.commandcenter.R;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00172\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/remotearmz/commandcenter/backup/DriveService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_backupStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "_lastBackupTime", "", "backupStatus", "Lkotlinx/coroutines/flow/StateFlow;", "getBackupStatus", "()Lkotlinx/coroutines/flow/StateFlow;", "drive", "Lcom/google/api/services/drive/Drive;", "getDrive", "()Lcom/google/api/services/drive/Drive;", "drive$delegate", "Lkotlin/Lazy;", "lastBackupTime", "getLastBackupTime", "downloadBackup", "", "fileId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listBackups", "", "Lcom/remotearmz/commandcenter/backup/DriveBackupFile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadBackup", "", "data", "fileName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@javax.inject.Singleton()
public final class DriveService {
    private final android.content.Context context = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.backup.BackupStatus> _backupStatus = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> backupStatus = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Long> _lastBackupTime = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> lastBackupTime = null;
    private final kotlin.Lazy drive$delegate = null;
    
    @javax.inject.Inject()
    public DriveService(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> getBackupStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getLastBackupTime() {
        return null;
    }
    
    private final com.google.api.services.drive.Drive getDrive() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object uploadBackup(@org.jetbrains.annotations.NotNull()
    java.lang.String data, @org.jetbrains.annotations.Nullable()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object listBackups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.remotearmz.commandcenter.backup.DriveBackupFile>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object downloadBackup(@org.jetbrains.annotations.NotNull()
    java.lang.String fileId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
}