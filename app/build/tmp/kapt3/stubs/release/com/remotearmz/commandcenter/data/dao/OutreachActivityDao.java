package com.remotearmz.commandcenter.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.remotearmz.commandcenter.data.model.ContactType;
import com.remotearmz.commandcenter.data.model.OutcomeCount;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.OutreachOutcome;
import com.remotearmz.commandcenter.data.model.OutreachType;
import com.remotearmz.commandcenter.data.model.TypeCount;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\'J#\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J$\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\'J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\'J\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u001c\u001a\u00020\u001dH\'J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u001f\u001a\u00020 H\'J\u001c\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\"\u001a\u00020\rH\'J\u001b\u0010#\u001a\u0004\u0018\u00010\u00052\u0006\u0010$\u001a\u00020\u0011H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\'0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u0010\u001c\u001a\u00020\u001dH\'J\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\b2\u0006\u0010\u001f\u001a\u00020 H\'J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\bH\'J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\b2\b\b\u0002\u0010/\u001a\u00020\u001dH\'J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020)0\bH\'J\u0019\u00101\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u00103\u001a\u00020\u0011H\'J\u0019\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/remotearmz/commandcenter/data/dao/OutreachActivityDao;", "", "deleteOutreachActivity", "", "outreachActivity", "Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "(Lcom/remotearmz/commandcenter/data/model/OutreachActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOutreachActivities", "Lkotlinx/coroutines/flow/Flow;", "", "getFollowUpActivities", "getFollowUpsInRange", "startTime", "", "endTime", "getLastContactTime", "contactId", "", "contactType", "Lcom/remotearmz/commandcenter/data/model/ContactType;", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/ContactType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutreachActivitiesByContact", "getOutreachActivitiesByContactId", "getOutreachActivitiesByContactType", "getOutreachActivitiesByDateRange", "startDate", "endDate", "getOutreachActivitiesByOutcome", "outcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "getOutreachActivitiesByType", "type", "Lcom/remotearmz/commandcenter/data/model/OutreachType;", "getOutreachActivitiesRequiringFollowUp", "currentTime", "getOutreachActivityById", "outreachActivityId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOutreachCountByOutcome", "Lcom/remotearmz/commandcenter/data/model/OutcomeCount;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "getOutreachCountByType", "Lcom/remotearmz/commandcenter/data/model/TypeCount;", "getOutreachSuccessRate", "", "getSuccessfulOutreachCount", "successOutcome", "getTotalOutreachCount", "insertOutreachActivity", "searchOutreachActivities", "query", "updateOutreachActivity", "app_release"})
public abstract interface OutreachActivityDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getAllOutreachActivities();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE id = :outreachActivityId")
    public abstract java.lang.Object getOutreachActivityById(@org.jetbrains.annotations.NotNull
    java.lang.String outreachActivityId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.OutreachActivity> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE contactId = :contactId AND contactType = :contactType ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByContact(@org.jetbrains.annotations.NotNull
    java.lang.String contactId, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType contactType);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE type = :type ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachType type);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE outcome = :outcome ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByOutcome(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND (followUpDate IS NULL OR followUpDate <= :currentTime) ORDER BY CASE WHEN followUpDate IS NULL THEN 1 ELSE 0 END, followUpDate ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesRequiringFollowUp(long currentTime);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND followUpDate BETWEEN :startTime AND :endTime ORDER BY followUpDate ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getFollowUpsInRange(long startTime, long endTime);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE followUpRequired = 1 ORDER BY followUpDate ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getFollowUpActivities();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE createdAt BETWEEN :startDate AND :endDate ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByDateRange(long startDate, long endDate);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM outreach_activities WHERE outcome = :outcome")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getOutreachCountByOutcome(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM outreach_activities WHERE type = :type")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getOutreachCountByType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachType type);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM outreach_activities WHERE outcome = :successOutcome")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getSuccessfulOutreachCount(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome successOutcome);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM outreach_activities")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalOutreachCount();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE notes LIKE \'%\' || :query || \'%\' ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> searchOutreachActivities(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE contactId = :contactId ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByContactId(@org.jetbrains.annotations.NotNull
    java.lang.String contactId);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM outreach_activities WHERE contactType = :contactType ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivitiesByContactType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType contactType);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT CASE WHEN COUNT(*) = 0 THEN 0 ELSE CAST(COUNT(CASE WHEN outcome = \'SUCCESSFUL\' OR outcome = \'INTERESTED\' THEN 1 END) AS FLOAT) / COUNT(*) * 100 END FROM outreach_activities")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getOutreachSuccessRate();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT type, COUNT(*) as count FROM outreach_activities GROUP BY type")
    public abstract java.lang.Object getOutreachCountByType(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.remotearmz.commandcenter.data.model.TypeCount>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT outcome, COUNT(*) as count FROM outreach_activities GROUP BY outcome")
    public abstract java.lang.Object getOutreachCountByOutcome(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.remotearmz.commandcenter.data.model.OutcomeCount>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT MAX(createdAt) FROM outreach_activities WHERE contactId = :contactId AND contactType = :contactType")
    public abstract java.lang.Object getLastContactTime(@org.jetbrains.annotations.NotNull
    java.lang.String contactId, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType contactType, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}