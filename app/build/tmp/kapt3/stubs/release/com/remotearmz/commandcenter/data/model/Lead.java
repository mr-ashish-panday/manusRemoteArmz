package com.remotearmz.commandcenter.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.remotearmz.commandcenter.utils.CurrencyConverter;
import java.util.UUID;

@androidx.room.Entity(tableName = "leads")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0014J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001dJ\u000b\u00101\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0010H\u00c6\u0003J\t\u00103\u001a\u00020\u0010H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\t\u00109\u001a\u00020\u000bH\u00c6\u0003J\t\u0010:\u001a\u00020\rH\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\u0094\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020\rH\u00d6\u0001J\t\u0010B\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0011\u0010\'\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010+\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010)R\u0011\u0010-\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b.\u0010)\u00a8\u0006C"}, d2 = {"Lcom/remotearmz/commandcenter/data/model/Lead;", "", "id", "", "contactName", "company", "phone", "email", "status", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "valueUSD", "", "probability", "", "source", "expectedCloseDate", "", "clientId", "createdAt", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/LeadStatus;DILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJ)V", "getClientId", "()Ljava/lang/String;", "getCompany", "getContactName", "getCreatedAt", "()J", "getEmail", "getExpectedCloseDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getId", "getPhone", "getProbability", "()I", "getSource", "getStatus", "()Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "getUpdatedAt", "valueNPR", "getValueNPR", "()D", "getValueUSD", "weightedValueNPR", "getWeightedValueNPR", "weightedValueUSD", "getWeightedValueUSD", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/remotearmz/commandcenter/data/model/LeadStatus;DILjava/lang/String;Ljava/lang/Long;Ljava/lang/String;JJ)Lcom/remotearmz/commandcenter/data/model/Lead;", "equals", "", "other", "hashCode", "toString", "app_release"})
public final class Lead {
    @org.jetbrains.annotations.NotNull
    @androidx.room.PrimaryKey
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String contactName = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String company = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String phone = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String email = null;
    @org.jetbrains.annotations.NotNull
    private final com.remotearmz.commandcenter.data.model.LeadStatus status = null;
    private final double valueUSD = 0.0;
    private final int probability = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String source = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.Long expectedCloseDate = null;
    @org.jetbrains.annotations.Nullable
    private final java.lang.String clientId = null;
    private final long createdAt = 0L;
    private final long updatedAt = 0L;
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.Lead copy(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.lang.String company, @org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status, double valueUSD, int probability, @org.jetbrains.annotations.NotNull
    java.lang.String source, @org.jetbrains.annotations.Nullable
    java.lang.Long expectedCloseDate, @org.jetbrains.annotations.Nullable
    java.lang.String clientId, long createdAt, long updatedAt) {
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
    
    public Lead(@org.jetbrains.annotations.NotNull
    java.lang.String id, @org.jetbrains.annotations.NotNull
    java.lang.String contactName, @org.jetbrains.annotations.NotNull
    java.lang.String company, @org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status, double valueUSD, int probability, @org.jetbrains.annotations.NotNull
    java.lang.String source, @org.jetbrains.annotations.Nullable
    java.lang.Long expectedCloseDate, @org.jetbrains.annotations.Nullable
    java.lang.String clientId, long createdAt, long updatedAt) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContactName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCompany() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.LeadStatus component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.remotearmz.commandcenter.data.model.LeadStatus getStatus() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getValueUSD() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getProbability() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSource() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Long getExpectedCloseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getClientId() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long getUpdatedAt() {
        return 0L;
    }
    
    public final double getValueNPR() {
        return 0.0;
    }
    
    public final double getWeightedValueUSD() {
        return 0.0;
    }
    
    public final double getWeightedValueNPR() {
        return 0.0;
    }
}