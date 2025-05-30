package com.remotearmz.commandcenter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "outreach_activities")
data class OutreachActivity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val type: OutreachType,
    val contactId: String, // Client or Lead ID
    val contactType: ContactType, // CLIENT or LEAD
    val outcome: OutreachOutcome,
    val notes: String = "",
    val duration: Int = 0, // minutes
    val followUpRequired: Boolean = false,
    val followUpDate: Long? = null,
    val createdAt: Long = System.currentTimeMillis()
)

enum class OutreachType { CALL, EMAIL, MEETING, SOCIAL_MEDIA }
enum class OutreachOutcome { SUCCESSFUL, NO_RESPONSE, INTERESTED, NOT_INTERESTED, FOLLOW_UP_NEEDED }
enum class ContactType { CLIENT, LEAD }
