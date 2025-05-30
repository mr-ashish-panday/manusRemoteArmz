package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@androidx.room.Entity(tableName = "targets")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\u0012J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u000bH\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\bH\u00c6\u0003J\t\u00101\u001a\u00020\bH\u00c6\u0003J\t\u00102\u001a\u00020\u000bH\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u000eH\u00c6\u0003J\t\u00105\u001a\u00020\u0010H\u00c6\u0003Jm\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000bH\u00c6\u0001J\u0013\u00107\u001a\u00020\u00102\b\u00108\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00109\u001a\u00020%H\u00d6\u0001J\t\u0010:\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u0011\u0010(\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001b\u00a8\u0006;"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/Target;", "", "id", "", "title", "category", "Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "targetValue", "", "currentValue", "deadline", "", "description", "priority", "Lcom/remotearmz/commandcenter/data/model/Priority;", "isCompleted", "", "createdAt", "(Ljava/lang/String;Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/TargetCategory;DDJLjava/lang/String;Lcom/remotearmz/commandcenter/data/model/Priority;ZJ)V", "getCategory", "()Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "getCreatedAt", "()J", "getCurrentValue", "()D", "getDeadline", "getDescription", "()Ljava/lang/String;", "getId", "()Z", "getPriority", "()Lcom/remotearmz/commandcenter/data/model/Priority;", "progressPercentage", "", "getProgressPercentage", "()F", "remainingDays", "", "getRemainingDays", "()I", "remainingValue", "getRemainingValue", "getTargetValue", "getTitle", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Target {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final com.remotearmz.commandcenter.data.model.TargetCategory category = null;
    private final double targetValue = 0.0;
    private final double currentValue = 0.0;
    private final long deadline = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.remotearmz.commandcenter.data.model.Priority priority = null;
    private final boolean isCompleted = false;
    private final long createdAt = 0L;
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.Target copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.TargetCategory category, double targetValue, double currentValue, long deadline, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.Priority priority, boolean isCompleted, long createdAt) {
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
    
    public Target(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.TargetCategory category, double targetValue, double currentValue, long deadline, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.Priority priority, boolean isCompleted, long createdAt) {
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
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.TargetCategory component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.TargetCategory getCategory() {
        return null;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double getTargetValue() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getCurrentValue() {
        return 0.0;
    }
    
    public final long component6() {
        return 0L;
    }
    
    public final long getDeadline() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.Priority component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.remotearmz.commandcenter.data.model.Priority getPriority() {
        return null;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final float getProgressPercentage() {
        return 0.0F;
    }
    
    public final double getRemainingValue() {
        return 0.0;
    }
    
    public final int getRemainingDays() {
        return 0;
    }
}