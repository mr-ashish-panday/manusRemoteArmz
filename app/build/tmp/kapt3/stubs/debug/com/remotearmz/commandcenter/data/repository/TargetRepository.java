package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.model.Target;
import com.remotearmz.commandcenter.data.model.TargetCategory;
import com.remotearmz.commandcenter.util.DateCountdownUtil;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bJ\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0012J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u001d\u001a\u00020\u001eJ\"\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120\u000bJ\u001c\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0019\u0010$\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u001a\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010&\u001a\u00020\u0019J\u0019\u0010\'\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/TargetRepository;", "", "targetDao", "Lcom/remotearmz/commandcenter/data/dao/TargetDao;", "(Lcom/remotearmz/commandcenter/data/dao/TargetDao;)V", "deleteTarget", "", "target", "Lcom/remotearmz/commandcenter/data/model/Target;", "(Lcom/remotearmz/commandcenter/data/model/Target;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTargets", "Lkotlinx/coroutines/flow/Flow;", "", "getAverageProgressByCategory", "", "category", "Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "getCompletedTargetCount", "", "getOverdueTargets", "currentTime", "", "getRemainingDaysCounter", "getTargetById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTargetsByCategory", "getTargetsByCompletionStatus", "isCompleted", "", "getTargetsByDeadlineRange", "startDate", "endDate", "getTotalTargetCount", "getUpcomingTargets", "insertTarget", "searchTargets", "query", "updateTarget", "updateTargetProgress", "targetId", "newValue", "", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@javax.inject.Singleton
public final class TargetRepository {
    private final com.remotearmz.commandcenter.data.dao.TargetDao targetDao = null;
    
    @javax.inject.Inject
    public TargetRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.TargetDao targetDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getAllTargets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByCategory(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.TargetCategory category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByCompletionStatus(boolean isCompleted) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargetsByDeadlineRange(long startDate, long endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> searchTargets(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getCompletedTargetCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalTargetCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getUpcomingTargets(long currentTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getOverdueTargets(long currentTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getAverageProgressByCategory(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.TargetCategory category) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTargetById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Target> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTargetProgress(@org.jetbrains.annotations.NotNull
    java.lang.String targetId, double newValue, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    public final int getRemainingDaysCounter() {
        return 0;
    }
}