package com.remotearmz.commandcenter.ui.outreach;

import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.data.model.ContactType;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.OutreachOutcome;
import com.remotearmz.commandcenter.data.model.OutreachType;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import java.util.Calendar;
import java.util.UUID;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0006\u0010-\u001a\u00020.J\u000e\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020!J\b\u00101\u001a\u00020.H\u0002J\b\u00102\u001a\u00020.H\u0002J\u000e\u00103\u001a\u00020.2\u0006\u00100\u001a\u00020!J\u0006\u00104\u001a\u00020.J\u000e\u00105\u001a\u00020.2\u0006\u00100\u001a\u00020!J\u0010\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u00010\u0010J\u0010\u00108\u001a\u00020.2\b\u00109\u001a\u0004\u0018\u00010\u0012J\u000e\u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020\u0017J\u0010\u0010<\u001a\u00020.2\b\u0010=\u001a\u0004\u0018\u00010\u0014R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0 0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001e\u00a8\u0006>"}, d2 = {"Lcom/remotearmz/commandcenter/ui/outreach/OutreachViewModel;", "Landroidx/lifecycle/ViewModel;", "outreachActivityRepository", "Lcom/remotearmz/commandcenter/data/repository/OutreachActivityRepository;", "clientRepository", "Lcom/remotearmz/commandcenter/data/repository/ClientRepository;", "leadRepository", "Lcom/remotearmz/commandcenter/data/repository/LeadRepository;", "activityLogRepository", "Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "(Lcom/remotearmz/commandcenter/data/repository/OutreachActivityRepository;Lcom/remotearmz/commandcenter/data/repository/ClientRepository;Lcom/remotearmz/commandcenter/data/repository/LeadRepository;Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;)V", "_callCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_emailCount", "_filterContactType", "Lcom/remotearmz/commandcenter/data/model/ContactType;", "_filterOutcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "_filterType", "Lcom/remotearmz/commandcenter/data/model/OutreachType;", "_meetingCount", "_searchQuery", "", "_uiState", "Lcom/remotearmz/commandcenter/ui/outreach/OutreachUiState;", "clients", "Lkotlinx/coroutines/flow/StateFlow;", "", "getClients", "()Lkotlinx/coroutines/flow/StateFlow;", "followUps", "", "Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "getFollowUps", "leads", "Lcom/remotearmz/commandcenter/data/model/Lead;", "getLeads", "outreachActivities", "getOutreachActivities", "outreachStats", "Lcom/remotearmz/commandcenter/ui/outreach/OutreachStats;", "getOutreachStats", "uiState", "getUiState", "clearError", "", "deleteOutreachActivity", "outreachActivity", "loadOutreachActivities", "loadTypeCounts", "markFollowUpComplete", "resetSaveState", "saveOutreachActivity", "updateContactTypeFilter", "contactType", "updateOutcomeFilter", "outcome", "updateSearchQuery", "query", "updateTypeFilter", "type", "app_release"})
public final class OutreachViewModel extends androidx.lifecycle.ViewModel {
    private final com.remotearmz.commandcenter.data.repository.OutreachActivityRepository outreachActivityRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository = null;
    private final com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.ui.outreach.OutreachUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.outreach.OutreachUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.OutreachType> _filterType = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.OutreachOutcome> _filterOutcome = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.ContactType> _filterContactType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> outreachActivities = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _callCount = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _emailCount = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _meetingCount = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.outreach.OutreachStats> outreachStats = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Object> clients = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> leads = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> followUps = null;
    
    @javax.inject.Inject
    public OutreachViewModel(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.OutreachActivityRepository outreachActivityRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ClientRepository clientRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.LeadRepository leadRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.outreach.OutreachUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getOutreachActivities() {
        return null;
    }
    
    private final void loadTypeCounts() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.outreach.OutreachStats> getOutreachStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Object> getClients() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Lead>> getLeads() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.OutreachActivity>> getFollowUps() {
        return null;
    }
    
    private final void loadOutreachActivities() {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void updateTypeFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.OutreachType type) {
    }
    
    public final void updateOutcomeFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome) {
    }
    
    public final void updateContactTypeFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.ContactType contactType) {
    }
    
    public final void saveOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity) {
    }
    
    public final void deleteOutreachActivity(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity) {
    }
    
    public final void markFollowUpComplete(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachActivity outreachActivity) {
    }
    
    public final void resetSaveState() {
    }
    
    public final void clearError() {
    }
}