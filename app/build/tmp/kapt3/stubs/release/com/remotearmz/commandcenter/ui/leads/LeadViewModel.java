package com.remotearmz.commandcenter.ui.leads;

import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0015J!\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0015J\u0016\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\tJ\u000e\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u000bJ\u0010\u0010&\u001a\u00020\u001a2\b\u0010\'\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/remotearmz/commandcenter/ui/leads/LeadViewModel;", "Landroidx/lifecycle/ViewModel;", "leadRepository", "Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "activityLogRepository", "Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "(Lcom/remotearmz/commandcenter/data/repository/LeadRepository;Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;)V", "_filterStatus", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "_searchQuery", "", "_uiState", "Lcom/remotearmz/commandcenter/ui/leads/LeadUiState;", "leadStats", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/remotearmz/commandcenter/ui/leads/LeadStats;", "getLeadStats", "()Lkotlinx/coroutines/flow/StateFlow;", "leads", "", "Lcom/remotearmz/commandcenter/data/model/Lead;", "getLeads", "uiState", "getUiState", "clearError", "", "deleteLead", "lead", "logLeadActivity", "action", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/Lead;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetSaveState", "saveLead", "updateLeadStatus", "newStatus", "updateSearchQuery", "query", "updateStatusFilter", "status", "app_release"})
public final class LeadViewModel extends androidx.lifecycle.ViewModel {
    private final com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.ui.leads.LeadUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.leads.LeadUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.LeadStatus> _filterStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> leads = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.leads.LeadStats> leadStats = null;
    
    @javax.inject.Inject
    public LeadViewModel(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.leads.LeadUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeads() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.leads.LeadStats> getLeadStats() {
        return null;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void updateStatusFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.LeadStatus status) {
    }
    
    public final void saveLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead) {
    }
    
    public final void deleteLead(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead) {
    }
    
    public final void updateLeadStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus newStatus) {
    }
    
    private final java.lang.Object logLeadActivity(java.lang.String action, com.remotearmz.commandcenter.data.model.Lead lead, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void resetSaveState() {
    }
    
    public final void clearError() {
    }
}