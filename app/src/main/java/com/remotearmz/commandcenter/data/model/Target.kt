package com.remotearmz.commandcenter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "targets")
data class Target(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val title: String,
    val category: TargetCategory,
    val targetValue: Double,
    val currentValue: Double = 0.0,
    val deadline: Long,
    val description: String = "",
    val priority: Priority = Priority.MEDIUM,
    val isCompleted: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) {
    val progressPercentage: Float get() = (currentValue / targetValue * 100).toFloat().coerceIn(0f, 100f)
    val remainingValue: Double get() = (targetValue - currentValue).coerceAtLeast(0.0)
    
    // Calculate remaining days from now until deadline
    val remainingDays: Int get() {
        val now = System.currentTimeMillis()
        val millisPerDay = 24 * 60 * 60 * 1000
        return ((deadline - now) / millisPerDay).toInt().coerceAtLeast(0)
    }
}

enum class TargetCategory { REVENUE, NEW_CLIENTS, LEADS_GENERATED, CALLS_MADE }
enum class Priority { LOW, MEDIUM, HIGH }
