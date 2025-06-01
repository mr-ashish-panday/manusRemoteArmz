package com.remotearmz.commandcenter.backup;

import android.content.Context;
import androidx.hilt.work.HiltWorker;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import com.remotearmz.commandcenter.notification.NotificationHelper;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import kotlinx.coroutines.Dispatchers;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@androidx.hilt.work.HiltWorker
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001BS\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010\u0017\u001a\u00020\u0018H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0011\u0010\u001a\u001a\u00020\u001bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/remotearmz/commandcenter/backup/BackupWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "leadRepository", "Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "targetRepository", "Lcom/remotearmz/commandcenter/data/repository/TargetRepository;", "outreachRepository", "Lcom/remotearmz/commandcenter/data/repository/OutreachRepository;", "activityLogRepository", "Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "driveService", "Lcom/remotearmz/commandcenter/backup/DriveService;", "notificationHelper", "Lcom/remotearmz/commandcenter/notification/NotificationHelper;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/remotearmz/commandcenter/data/repository/ClientRepository;Lcom/remotearmz/commandcenter/data/repository/LeadRepository;Lcom/remotearmz/commandcenter/data/repository/TargetRepository;Lcom/remotearmz/commandcenter/data/repository/OutreachRepository;Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;Lcom/remotearmz/commandcenter/backup/DriveService;Lcom/remotearmz/commandcenter/notification/NotificationHelper;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "createBackupData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "Landroidx/work/ListenableWorker$Result;", "app_release"})
public final class BackupWorker extends androidx.work.CoroutineWorker {
    private final com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository = null;
    private final com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository = null;
    private final com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository = null;
    private final com.remotearmz.commandcenter.data.repository.OutreachRepository outreachRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository = null;
    private final com.remotearmz.commandcenter.backup.DriveService driveService = null;
    private final com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper = null;
    private final java.text.SimpleDateFormat dateFormat = null;
    
    @dagger.assisted.AssistedInject
    public BackupWorker(@org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted
    android.content.Context context, @org.jetbrains.annotations.NotNull
    @dagger.assisted.Assisted
    androidx.work.WorkerParameters params, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.OutreachRepository outreachRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.backup.DriveService driveService, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    private final java.lang.Object createBackupData(kotlin.coroutines.Continuation<? super java.lang.String> continuation) {
        return null;
    }
}