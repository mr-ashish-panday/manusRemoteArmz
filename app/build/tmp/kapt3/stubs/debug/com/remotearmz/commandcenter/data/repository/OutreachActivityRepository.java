package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.model.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ#\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\u001f\u001a\u00020 J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000fJ\u001b\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010$\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\u000b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\'0\u000b2\u0006\u0010\u001f\u001a\u00020 J\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u000bJ\f\u00100\u001a\b\u0012\u0004\u0012\u00020\'0\u000bJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020\'0\u000bJ\u0019\u00102\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ!\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u000206H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00107J\u0019\u00108\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00069"}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/OutreachActivityRepository;", "", "outreachActivityDao", "Lcom/remotearmz/commandcenter/data/dao/OutreachActivityDao;", "(Lcom/remotearmz/commandcenter/data/dao/OutreachActivityDao;)V", "deleteOutreachActivity", "", "outreachActivity", "Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "(Lcom/remotearmz/commandcenter/data/model/OutreachActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOutreachActivities", "Lkotlinx/coroutines/flow/Flow;", "", "getFollowUpsInRange", "startTime", "", "endTime", "getLastContactTime", "contactId", "", "contactType", "Lcom/remotearmz/commandcenter/data/model/ContactType;", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/ContactType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutreachActivitiesByContact", "getOutreachActivitiesByDateRange", "startDate", "endDate", "getOutreachActivitiesByOutcome", "outcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "getOutreachActivitiesByType", "type", "Lcom/remotearmz/commandcenter/data/model/OutreachType;", "getOutreachActivitiesRequiringFollowUp", "currentTime", "getOutreachActivityById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutreachCountByOutcome", "", "getOutreachCountByType", "getOutreachCountsByOutcome", "Lcom/remotearmz/commandcenter/data/model/OutcomeCount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutreachCountsByType", "Lcom/remotearmz/commandcenter/data/model/TypeCount;", "getOutreachSuccessRate", "", "getSuccessfulOutreachCount", "getTotalOutreachCount", "insertOutreachActivity", "updateClientLastContactTime", "clientId", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/repository/ClientRepository;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOutreachActivity", "app_debug"})
@javax.inject.Singleton
public final class OutreachActivityRepository {
    private final com.remotearmz.commandcenter.data.dao.OutreachActivityDao outreachActivityDao = null;
    
    @javax.inject.Inject
    public OutreachActivityRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.OutreachActivityDao outreachActivityDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getAllOutreachActivities() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByContact(@org.jetbrains.annotations.NotNull
    java.lang.String contactId, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType contactType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByOutcome(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesRequiringFollowUp(long currentTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByDateRange(long startDate, long endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getFollowUpsInRange(long startTime, long endTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getOutreachCountByOutcome(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getOutreachCountByType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOutreachCountsByType(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.remotearmz.commandcenter.data.model.TypeCount>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOutreachCountsByOutcome(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.remotearmz.commandcenter.data.model.OutcomeCount>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getSuccessfulOutreachCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalOutreachCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getOutreachSuccessRate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOutreachActivityById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.OutreachActivity> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastContactTime(@org.jetbrains.annotations.NotNull
    java.lang.String contactId, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType contactType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateClientLastContactTime(@org.jetbrains.annotations.NotNull
    java.lang.String clientId, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}