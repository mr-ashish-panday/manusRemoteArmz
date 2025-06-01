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

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006#"}, d2 = {"Lcom/remotearmz/commandcenter/ui/targets/TargetStats;", "", "totalCount", "", "completedCount", "completionRate", "", "revenueTargetCount", "clientTargetCount", "leadTargetCount", "overallProgress", "(IIFIIIF)V", "getClientTargetCount", "()I", "getCompletedCount", "getCompletionRate", "()F", "getLeadTargetCount", "getOverallProgress", "getRevenueTargetCount", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class TargetStats {
    private final int totalCount = 0;
    private final int completedCount = 0;
    private final float completionRate = 0.0F;
    private final int revenueTargetCount = 0;
    private final int clientTargetCount = 0;
    private final int leadTargetCount = 0;
    private final float overallProgress = 0.0F;
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.ui.targets.TargetStats copy(int totalCount, int completedCount, float completionRate, int revenueTargetCount, int clientTargetCount, int leadTargetCount, float overallProgress) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TargetStats() {
        super();
    }
    
    public TargetStats(int totalCount, int completedCount, float completionRate, int revenueTargetCount, int clientTargetCount, int leadTargetCount, float overallProgress) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getTotalCount() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCompletedCount() {
        return 0;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float getCompletionRate() {
        return 0.0F;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getRevenueTargetCount() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getClientTargetCount() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getLeadTargetCount() {
        return 0;
    }
    
    public final float component7() {
        return 0.0F;
    }
    
    public final float getOverallProgress() {
        return 0.0F;
    }
}