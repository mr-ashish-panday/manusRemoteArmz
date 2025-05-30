package com.remotearmz.commandcenter.data.database

import androidx.room.TypeConverter
import com.remotearmz.commandcenter.data.model.ClientStatus
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import com.remotearmz.commandcenter.data.model.Priority
import com.remotearmz.commandcenter.data.model.TargetCategory

class Converters {
    // Client Status Converters
    @TypeConverter
    fun fromClientStatus(status: ClientStatus): String {
        return status.name
    }
    
    @TypeConverter
    fun toClientStatus(status: String): ClientStatus {
        return try {
            ClientStatus.valueOf(status)
        } catch (e: IllegalArgumentException) {
            ClientStatus.ACTIVE
        }
    }
    
    // Lead Status Converters
    @TypeConverter
    fun fromLeadStatus(status: LeadStatus): String {
        return status.name
    }
    
    @TypeConverter
    fun toLeadStatus(status: String): LeadStatus {
        return try {
            LeadStatus.valueOf(status)
        } catch (e: IllegalArgumentException) {
            LeadStatus.NEW
        }
    }
    
    // Target Category Converters
    @TypeConverter
    fun fromTargetCategory(category: TargetCategory): String {
        return category.name
    }
    
    @TypeConverter
    fun toTargetCategory(category: String): TargetCategory {
        return try {
            TargetCategory.valueOf(category)
        } catch (e: IllegalArgumentException) {
            TargetCategory.REVENUE
        }
    }
    
    // Priority Converters
    @TypeConverter
    fun fromPriority(priority: Priority): String {
        return priority.name
    }
    
    @TypeConverter
    fun toPriority(priority: String): Priority {
        return try {
            Priority.valueOf(priority)
        } catch (e: IllegalArgumentException) {
            Priority.MEDIUM
        }
    }
    
    // Outreach Type Converters
    @TypeConverter
    fun fromOutreachType(type: OutreachType): String {
        return type.name
    }
    
    @TypeConverter
    fun toOutreachType(type: String): OutreachType {
        return try {
            OutreachType.valueOf(type)
        } catch (e: IllegalArgumentException) {
            OutreachType.CALL
        }
    }
    
    // Outreach Outcome Converters
    @TypeConverter
    fun fromOutreachOutcome(outcome: OutreachOutcome): String {
        return outcome.name
    }
    
    @TypeConverter
    fun toOutreachOutcome(outcome: String): OutreachOutcome {
        return try {
            OutreachOutcome.valueOf(outcome)
        } catch (e: IllegalArgumentException) {
            OutreachOutcome.NO_RESPONSE
        }
    }
    
    // Contact Type Converters
    @TypeConverter
    fun fromContactType(type: ContactType): String {
        return type.name
    }
    
    @TypeConverter
    fun toContactType(type: String): ContactType {
        return try {
            ContactType.valueOf(type)
        } catch (e: IllegalArgumentException) {
            ContactType.CLIENT
        }
    }
    
    // List<String> Converters
    @TypeConverter
    fun fromStringList(list: List<String>): String {
        return list.joinToString("|")
    }
    
    @TypeConverter
    fun toStringList(data: String): List<String> {
        return if (data.isBlank()) {
            emptyList()
        } else {
            data.split("|")
        }
    }
}
