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

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/remotearmz/commandcenter/ui/outreach/OutreachStats;", "", "totalCount", "", "successfulCount", "successRate", "", "callCount", "emailCount", "meetingCount", "(IIFIII)V", "getCallCount", "()I", "getEmailCount", "getMeetingCount", "getSuccessRate", "()F", "getSuccessfulCount", "getTotalCount", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class OutreachStats {
    private final int totalCount = 0;
    private final int successfulCount = 0;
    private final float successRate = 0.0F;
    private final int callCount = 0;
    private final int emailCount = 0;
    private final int meetingCount = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.ui.outreach.OutreachStats copy(int totalCount, int successfulCount, float successRate, int callCount, int emailCount, int meetingCount) {
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
    
    public OutreachStats() {
        super();
    }
    
    public OutreachStats(int totalCount, int successfulCount, float successRate, int callCount, int emailCount, int meetingCount) {
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
    
    public final int getSuccessfulCount() {
        return 0;
    }
    
    public final float component3() {
        return 0.0F;
    }
    
    public final float getSuccessRate() {
        return 0.0F;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getCallCount() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getEmailCount() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final int getMeetingCount() {
        return 0;
    }
}