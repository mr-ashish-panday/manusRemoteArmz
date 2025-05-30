package com.remotearmz.commandcenter.notification;

import android.content.Context;
import androidx.hilt.work.HiltWorker;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

@androidx.hilt.work.HiltWorker()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018BC\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0015\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0016\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/remotearmz/commandcenter/notification/NotificationWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "params", "Landroidx/work/WorkerParameters;", "outreachRepository", "Lcom/remotearmz/commandcenter/data/repository/OutreachRepository;", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "leadRepository", "Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "targetRepository", "Lcom/remotearmz/commandcenter/data/repository/TargetRepository;", "notificationHelper", "Lcom/remotearmz/commandcenter/notification/NotificationHelper;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/remotearmz/commandcenter/data/repository/OutreachRepository;Lcom/remotearmz/commandcenter/data/repository/ClientRepository;Lcom/remotearmz/commandcenter/data/repository/LeadRepository;Lcom/remotearmz/commandcenter/data/repository/TargetRepository;Lcom/remotearmz/commandcenter/notification/NotificationHelper;)V", "checkFollowUps", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkTargetDeadlines", "checkWeeklySummary", "doWork", "Landroidx/work/ListenableWorker$Result;", "Companion", "app_debug"})
public final class NotificationWorker extends androidx.work.CoroutineWorker {
    private final com.remotearmz.commandcenter.data.repository.OutreachRepository outreachRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository = null;
    private final com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository = null;
    private final com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository = null;
    private final com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.remotearmz.commandcenter.notification.NotificationWorker.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_NAME = "notification_worker";
    
    @dagger.assisted.AssistedInject()
    public NotificationWorker(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    androidx.work.WorkerParameters params, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.repository.OutreachRepository outreachRepository, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.notification.NotificationHelper notificationHelper) {
        super(null, null);
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> continuation) {
        return null;
    }
    
    private final java.lang.Object checkFollowUps(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object checkTargetDeadlines(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object checkWeeklySummary(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/remotearmz/commandcenter/notification/NotificationWorker$Companion;", "", "()V", "WORK_NAME", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}