package com.remotearmz.commandcenter.data.model;

import androidx.room.ColumnInfo;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/OutcomeCount;", "", "outcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "count", "", "(Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;I)V", "getCount", "()I", "getOutcome", "()Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"})
public final class OutcomeCount {
    @org.jetbrains.annotations.NotNull
    @androidx.room.ColumnInfo(name = "outcome")
    private final com.remotearmz.commandcenter.data.model.OutreachOutcome outcome = null;
    @androidx.room.ColumnInfo(name = "count")
    private final int count = 0;
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.OutcomeCount copy(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome, int count) {
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
    
    public OutcomeCount(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome, int count) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.OutreachOutcome component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.OutreachOutcome getOutcome() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getCount() {
        return 0;
    }
}