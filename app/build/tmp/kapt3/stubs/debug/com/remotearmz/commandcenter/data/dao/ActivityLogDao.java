package com.remotearmz.commandcenter.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import com.remotearmz.commandcenter.data.model.ActivityLog;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\f2\u0006\u0010\u0016\u001a\u00020\u000fH\'J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\fH\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00110\f2\u0006\u0010\u0019\u001a\u00020\rH\'J\u0019\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/remotearmz/commandcenter/data/dao/ActivityLogDao;", "", "deleteActivityLog", "", "activityLog", "Lcom/remotearmz/commandcenter/data/model/ActivityLog;", "(Lcom/remotearmz/commandcenter/data/model/ActivityLog;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldActivityLogs", "cutoffTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActionCount", "Lkotlinx/coroutines/flow/Flow;", "", "actionType", "", "getActivityLogsByActionType", "", "getActivityLogsByTimeRange", "startTime", "endTime", "getActivityLogsByUser", "userId", "getAllActivityLogs", "getRecentActivityLogs", "limit", "insertActivityLog", "app_debug"})
public abstract interface ActivityLogDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertActivityLog(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ActivityLog activityLog, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteActivityLog(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ActivityLog activityLog, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM activity_logs ORDER BY timestamp DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getAllActivityLogs();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM activity_logs WHERE action LIKE \'%\' || :actionType || \'%\' ORDER BY timestamp DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByActionType(@org.jetbrains.annotations.NotNull
    java.lang.String actionType);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM activity_logs WHERE userId = :userId ORDER BY timestamp DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByUser(@org.jetbrains.annotations.NotNull
    java.lang.String userId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM activity_logs WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getActivityLogsByTimeRange(long startTime, long endTime);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM activity_logs ORDER BY timestamp DESC LIMIT :limit")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.ActivityLog>> getRecentActivityLogs(int limit);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "DELETE FROM activity_logs WHERE timestamp < :cutoffTime")
    public abstract java.lang.Object deleteOldActivityLogs(long cutoffTime, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM activity_logs WHERE action LIKE \'%\' || :actionType || \'%\'")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getActionCount(@org.jetbrains.annotations.NotNull
    java.lang.String actionType);
}