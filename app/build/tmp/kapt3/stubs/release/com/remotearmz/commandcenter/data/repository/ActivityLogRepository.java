package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.model.ActivityLog;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u000f2\u0006\u0010\u0011\u001a\u00020\u0012J\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u000f2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\fJ\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u000f2\u0006\u0010\u0019\u001a\u00020\u0012J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u000fJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00140\u000f2\b\b\u0002\u0010\u001c\u001a\u00020\u0010J\u0019\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ)\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "", "activityLogDao", "Lcom/remotearmz/commandcenter/data/dao/ActivityLogDao;", "(Lcom/remotearmz/commandcenter/data/dao/ActivityLogDao;)V", "deleteActivityLog", "", "activityLog", "Lcom/remotearmz/commandcenter/data/model/ActivityLog;", "(Lcom/remotearmz/commandcenter/data/model/ActivityLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldActivityLogs", "cutoffTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionCount", "Lkotlinx/coroutines/flow/Flow;", "", "actionType", "", "getActivityLogsByActionType", "", "getActivityLogsByTimeRange", "startTime", "endTime", "getActivityLogsByUser", "userId", "getAllActivityLogs", "getRecentActivityLogs", "limit", "insertActivityLog", "logActivity", "action", "details", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@javax.inject.Singleton
public final class ActivityLogRepository {
    private final com.remotearmz.commandcenter.data.dao.ActivityLogDao activityLogDao = null;
    
    @javax.inject.Inject
    public ActivityLogRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.ActivityLogDao activityLogDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getAllActivityLogs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByActionType(@org.jetbrains.annotations.NotNull
    java.lang.String actionType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByTimeRange(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getRecentActivityLogs(int limit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getActionCount(@org.jetbrains.annotations.NotNull
    java.lang.String actionType) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertActivityLog(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ActivityLog activityLog, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteActivityLog(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ActivityLog activityLog, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteOldActivityLogs(long cutoffTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object logActivity(@org.jetbrains.annotations.NotNull
    java.lang.String action, @org.jetbrains.annotations.NotNull
    java.lang.String details, @org.jetbrains.annotations.NotNull
    java.lang.String userId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}