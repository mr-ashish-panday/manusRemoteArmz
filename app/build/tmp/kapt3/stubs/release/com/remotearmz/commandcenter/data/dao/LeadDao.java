package com.remotearmz.commandcenter.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import kotlinx.coroutines.flow.Flow;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\bH\'J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\'J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\'J\u001c\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\b2\u0006\u0010\u0019\u001a\u00020\u001aH\'J$\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\b2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\'J\u001c\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\'J\u0010\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\bH\'J\u0010\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\bH\'J\u0019\u0010!\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\b2\u0006\u0010#\u001a\u00020\u000eH\'J\u0019\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/remotearmz/commandcenter/data/dao/LeadDao;", "", "deleteLead", "", "lead", "Lcom/remotearmz/commandcenter/data/model/Lead;", "(Lcom/remotearmz/commandcenter/data/model/Lead;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveLeadCount", "Lkotlinx/coroutines/flow/Flow;", "", "getAllLeads", "", "getLeadById", "leadId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeadCount", "getLeadCountByStatus", "status", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "getLeadsByExpectedCloseDateRange", "startDate", "", "endDate", "getLeadsByMinValue", "minValue", "", "getLeadsByProbabilityRange", "minProbability", "maxProbability", "getLeadsByStatus", "getTotalLeadValueUSD", "getWeightedLeadValueUSD", "insertLead", "searchLeads", "query", "updateLead", "app_release"})
public abstract interface LeadDao {
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Update
    public abstract java.lang.Object updateLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Delete
    public abstract java.lang.Object deleteLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getAllLeads();
    
    @org.jetbrains.annotations.Nullable
    @androidx.room.Query(value = "SELECT * FROM leads WHERE id = :leadId")
    public abstract java.lang.Object getLeadById(@org.jetbrains.annotations.NotNull
    java.lang.String leadId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Lead> continuation);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads WHERE status = :status ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads WHERE contactName LIKE \'%\' || :query || \'%\' OR company LIKE \'%\' || :query || \'%\' OR email LIKE \'%\' || :query || \'%\' ORDER BY createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> searchLeads(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads WHERE probability BETWEEN :minProbability AND :maxProbability ORDER BY probability DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByProbabilityRange(int minProbability, int maxProbability);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads WHERE valueUSD >= :minValue ORDER BY valueUSD DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByMinValue(double minValue);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM leads WHERE expectedCloseDate BETWEEN :startDate AND :endDate")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByExpectedCloseDateRange(long startDate, long endDate);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM leads")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getLeadCount();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM leads WHERE status NOT IN (\'WON\', \'LOST\')")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getActiveLeadCount();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT COUNT(*) FROM leads WHERE status = :status")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getLeadCountByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT SUM(valueUSD) FROM leads")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalLeadValueUSD();
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT SUM(valueUSD * (probability / 100.0)) FROM leads")
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getWeightedLeadValueUSD();
}