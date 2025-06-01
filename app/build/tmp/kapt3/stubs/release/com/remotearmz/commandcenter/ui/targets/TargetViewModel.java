package com.remotearmz.commandcenter.ui.targets;

import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.data.model.Priority;
import com.remotearmz.commandcenter.data.model.Target;
import com.remotearmz.commandcenter.data.model.TargetCategory;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import java.util.UUID;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0017J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u001cH\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\tJ\u0015\u0010&\u001a\u00020\u001c2\b\u0010\'\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010(J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\rJ\u0016\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014\u00a8\u0006/"}, d2 = {"Lcom/remotearmz/commandcenter/ui/targets/TargetViewModel;", "Landroidx/lifecycle/ViewModel;", "targetRepository", "Lcom/remotearmz/commandcenter/data/repository/TargetRepository;", "activityLogRepository", "Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;", "(Lcom/remotearmz/commandcenter/data/repository/TargetRepository;Lcom/remotearmz/commandcenter/data/repository/ActivityLogRepository;)V", "_filterCategory", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "_filterCompleted", "", "_searchQuery", "", "_uiState", "Lcom/remotearmz/commandcenter/ui/targets/TargetUiState;", "targetStats", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/remotearmz/commandcenter/ui/targets/TargetStats;", "getTargetStats", "()Lkotlinx/coroutines/flow/StateFlow;", "targets", "", "Lcom/remotearmz/commandcenter/data/model/Target;", "getTargets", "uiState", "getUiState", "clearError", "", "deleteTarget", "target", "getRemainingDaysCounter", "", "loadTargets", "resetSaveState", "saveTarget", "updateCategoryFilter", "category", "updateCompletedFilter", "completed", "(Ljava/lang/Boolean;)V", "updateSearchQuery", "query", "updateTargetProgress", "targetId", "newValue", "", "app_release"})
public final class TargetViewModel extends androidx.lifecycle.ViewModel {
    private final com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository = null;
    private final com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.ui.targets.TargetUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.targets.TargetUiState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.data.model.TargetCategory> _filterCategory = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _filterCompleted = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> targets = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.targets.TargetStats> targetStats = null;
    
    @javax.inject.Inject
    public TargetViewModel(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.TargetRepository targetRepository, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.repository.ActivityLogRepository activityLogRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.targets.TargetUiState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.data.model.Target>> getTargets() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.ui.targets.TargetStats> getTargetStats() {
        return null;
    }
    
    private final void loadTargets() {
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void updateCategoryFilter(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.TargetCategory category) {
    }
    
    public final void updateCompletedFilter(@org.jetbrains.annotations.Nullable
    java.lang.Boolean completed) {
    }
    
    public final void saveTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target) {
    }
    
    public final void deleteTarget(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target) {
    }
    
    public final void updateTargetProgress(@org.jetbrains.annotations.NotNull
    java.lang.String targetId, double newValue) {
    }
    
    public final void resetSaveState() {
    }
    
    public final void clearError() {
    }
    
    public final int getRemainingDaysCounter() {
        return 0;
    }
}