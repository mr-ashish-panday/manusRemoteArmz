package com.remotearmz.commandcenter.data.database;

import androidx.room.TypeConverter;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import com.remotearmz.commandcenter.data.model.ContactType;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import com.remotearmz.commandcenter.data.model.OutreachOutcome;
import com.remotearmz.commandcenter.data.model.OutreachType;
import com.remotearmz.commandcenter.data.model.Priority;
import com.remotearmz.commandcenter.data.model.TargetCategory;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0007J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010!\u001a\u00020\u0004H\u0007J\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0004H\u0007\u00a8\u0006#"}, d2 = {"Lcom/remotearmz/commandcenter/data/database/Converters;", "", "()V", "fromClientStatus", "", "status", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "fromContactType", "type", "Lcom/remotearmz/commandcenter/data/model/ContactType;", "fromLeadStatus", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "fromOutreachOutcome", "outcome", "Lcom/remotearmz/commandcenter/data/model/OutreachOutcome;", "fromOutreachType", "Lcom/remotearmz/commandcenter/data/model/OutreachType;", "fromPriority", "priority", "Lcom/remotearmz/commandcenter/data/model/Priority;", "fromStringList", "list", "", "fromTargetCategory", "category", "Lcom/remotearmz/commandcenter/data/model/TargetCategory;", "toClientStatus", "toContactType", "toLeadStatus", "toOutreachOutcome", "toOutreachType", "toPriority", "toStringList", "data", "toTargetCategory", "app_release"})
public final class Converters {
    
    public Converters() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromClientStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ClientStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.ClientStatus toClientStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromLeadStatus(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.LeadStatus status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.LeadStatus toLeadStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromTargetCategory(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.TargetCategory category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.TargetCategory toTargetCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromPriority(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Priority priority) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.Priority toPriority(@org.jetbrains.annotations.NotNull
    java.lang.String priority) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromOutreachType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.OutreachType toOutreachType(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromOutreachOutcome(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.OutreachOutcome outcome) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.OutreachOutcome toOutreachOutcome(@org.jetbrains.annotations.NotNull
    java.lang.String outcome) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromContactType(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ContactType type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final com.remotearmz.commandcenter.data.model.ContactType toContactType(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.lang.String fromStringList(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> list) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.TypeConverter
    public final java.util.List<java.lang.String> toStringList(@org.jetbrains.annotations.NotNull
    java.lang.String data) {
        return null;
    }
}