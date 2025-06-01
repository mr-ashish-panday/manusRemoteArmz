package com.remotearmz.commandcenter.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.remotearmz.commandcenter.data.model.Target;
import com.remotearmz.commandcenter.data.model.TargetCategory;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b2\u0006\u0010\f\u001a\u00020\rH\'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\f\u001a\u00020\rH\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0019\u001a\u00020\u001aH\'J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0012H\'J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bH\'J\u001c\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0019\u0010 \u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\"\u001a\u00020\u0015H\'J\u0019\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/remotearmz/commandcenter/data/dao/TargetDao;", "", "deleteTarget", "", "target", "Lcom/remotearmz/commandcenter/data/model/Target;", "(Lcom/remotearmz/commandcenter/data/model/Target;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTargets", "Lkotlinx/coroutines/flow/Flow;", "", "getAverageProgressByCategory", "", "category", "Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "getCompletedTargetCount", "", "getOverdueTargets", "currentTime", "", "getTargetById", "targetId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetsByCategory", "getTargetsByCompletionStatus", "isCompleted", "", "getTargetsByDeadlineRange", "startDate", "endDate", "getTotalTargetCount", "getUpcomingTargets", "insertTarget", "searchTargets", "query", "updateTarget", "app_release"})
public abstract interface TargetDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets ORDER BY deadline ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getAllTargets();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM targets WHERE id = :targetId")
    public abstract java.lang.Object getTargetById(@org.jetbrains.annotations.NotNull
    java.lang.String targetId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Target> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE category = :category ORDER BY deadline ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByCategory(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.TargetCategory category);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE isCompleted = :isCompleted ORDER BY deadline ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByCompletionStatus(boolean isCompleted);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE deadline BETWEEN :startDate AND :endDate ORDER BY deadline ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByDeadlineRange(long startDate, long endDate);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE title LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\'")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> searchTargets(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM targets WHERE isCompleted = 1")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getCompletedTargetCount();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM targets")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalTargetCount();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE deadline > :currentTime AND isCompleted = 0 ORDER BY deadline ASC LIMIT 5")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getUpcomingTargets(long currentTime);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM targets WHERE deadline < :currentTime AND isCompleted = 0 ORDER BY deadline ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getOverdueTargets(long currentTime);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT AVG(currentValue / targetValue * 100) FROM targets WHERE category = :category")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getAverageProgressByCategory(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.TargetCategory category);
}