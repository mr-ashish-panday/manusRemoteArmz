package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@androidx.room.Entity(tableName = "outreach_activities")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b&\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0002\u0010\u0013J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0011H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\bH\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\rH\u00c6\u0003J\t\u0010/\u001a\u00020\u000fH\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0011H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJt\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u00c6\u0001\u00a2\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\u000f2\b\u00104\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00105\u001a\u00020\rH\u00d6\u0001J\t\u00106\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&\u00a8\u00067"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "", "id", "", "type", "Lcom/remotearmz/commandcenter/data/model/OutreachType;", "contactId", "contactType", "Lcom/remotearmz/commandcenter/data/model/ContactType;", "outcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "notes", "duration", "", "followUpRequired", "", "followUpDate", "", "createdAt", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/OutreachType;Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/ContactType;Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;Ljava/lang/String;IZLjava/lang/Long;J)V", "getContactId", "()Ljava/lang/String;", "getContactType", "()Lcom/remotearmz/commandcenter/data/model/ContactType;", "getCreatedAt", "()J", "getDuration", "()I", "getFollowUpDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFollowUpRequired", "()Z", "getId", "getNotes", "getOutcome", "()Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "getType", "()Lcom/remotearmz/commandcenter/data/model/OutreachType;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/OutreachType;Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/ContactType;Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;Ljava/lang/String;IZLjava/lang/Long;J)Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class OutreachActivity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final com.remotearmz.commandcenter.data.model.OutreachType type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contactId = null;
    @org.jetbrains.annotations.NotNull()
    private final com.remotearmz.commandcenter.data.model.ContactType contactType = null;
    @org.jetbrains.annotations.NotNull()
    private final com.remotearmz.commandcenter.data.model.OutreachOutcome outcome = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String notes = null;
    private final int duration = 0;
    private final boolean followUpRequired = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long followUpDate = null;
    private final long createdAt = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.OutreachActivity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachType type, @org.jetbrains.annotations.NotNull()
    java.lang.String contactId, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.ContactType contactType, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, int duration, boolean followUpRequired, @org.jetbrains.annotations.Nullable()
    java.lang.Long followUpDate, long createdAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public OutreachActivity(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachType type, @org.jetbrains.annotations.NotNull()
    java.lang.String contactId, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.ContactType contactType, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, int duration, boolean followUpRequired, @org.jetbrains.annotations.Nullable()
    java.lang.Long followUpDate, long createdAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.OutreachType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.OutreachType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContactId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.ContactType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.ContactType getContactType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.OutreachOutcome component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.OutreachOutcome getOutcome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotes() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getDuration() {
        return 0;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean getFollowUpRequired() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getFollowUpDate() {
        return null;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
}