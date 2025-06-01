package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000fJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\"\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cJ\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000f2\u0006\u0010\u001f\u001a\u00020 J\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000f2\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u0010J\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000fJ\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000fJ\u0019\u0010\'\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u001a\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u000f2\u0006\u0010)\u001a\u00020\nJ\u0019\u0010*\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "", "leadDao", "Lcom/remotearmz/commandcenter/data/dao/LeadDao;", "(Lcom/remotearmz/commandcenter/data/dao/LeadDao;)V", "convertLeadToClient", "", "lead", "Lcom/remotearmz/commandcenter/data/model/Lead;", "clientId", "", "(Lcom/remotearmz/commandcenter/data/model/Lead;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteLead", "(Lcom/remotearmz/commandcenter/data/model/Lead;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveLeadCount", "Lkotlinx/coroutines/flow/Flow;", "", "getAllLeads", "", "getLeadById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLeadCount", "getLeadCountByStatus", "status", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "getLeadsByExpectedCloseDateRange", "startDate", "", "endDate", "getLeadsByMinValue", "minValue", "", "getLeadsByProbabilityRange", "minProbability", "maxProbability", "getLeadsByStatus", "getTotalLeadValueUSD", "getWeightedLeadValueUSD", "insertLead", "searchLeads", "query", "updateLead", "app_debug"})
@javax.inject.Singleton
public final class LeadRepository {
    private final com.remotearmz.commandcenter.data.dao.LeadDao leadDao = null;
    
    @javax.inject.Inject
    public LeadRepository(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.dao.LeadDao leadDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getAllLeads() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> searchLeads(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByProbabilityRange(int minProbability, int maxProbability) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByMinValue(double minValue) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeadsByExpectedCloseDateRange(long startDate, long endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getLeadCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getActiveLeadCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getLeadCountByStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalLeadValueUSD() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> getWeightedLeadValueUSD() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLeadById(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.remotearmz.commandcenter.data.model.Lead> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object convertLeadToClient(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    java.lang.String clientId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}