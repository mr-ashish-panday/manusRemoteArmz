package com.remotearmz.commandcenter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "activity_logs")
data class ActivityLog(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val action: String, // "Added Client", "Updated Target", etc.
    val details: String, // JSON or description
    val timestamp: Long = System.currentTimeMillis(),
    val userId: String
)
