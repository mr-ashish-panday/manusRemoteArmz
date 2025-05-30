package com.remotearmz.commandcenter.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * Returns a color based on the status name
 */
fun getStatusColor(status: String): Color {
    return when (status.uppercase()) {
        "ACTIVE" -> Color(0xFF4CAF50) // Green
        "INACTIVE" -> Color(0xFF9E9E9E) // Gray
        "NEW" -> Color(0xFF2196F3) // Blue
        "WON" -> Color(0xFF4CAF50) // Green
        "LOST" -> Color(0xFFF44336) // Red
        "PENDING" -> Color(0xFFFF9800) // Orange
        "COMPLETED" -> Color(0xFF4CAF50) // Green
        "CANCELED" -> Color(0xFFF44336) // Red
        else -> Color(0xFF9E9E9E) // Default gray
    }
}

/**
 * Returns a color based on the priority name
 */
fun getPriorityColor(priority: String): Color {
    return when (priority.uppercase()) {
        "HIGH" -> Color(0xFFF44336) // Red
        "MEDIUM" -> Color(0xFFFF9800) // Orange
        "LOW" -> Color(0xFF4CAF50) // Green
        else -> Color(0xFF9E9E9E) // Default gray
    }
}

/**
 * Returns a color based on the outreach outcome
 */
fun getOutcomeColor(outcome: String): Color {
    return when (outcome.uppercase()) {
        "SUCCESSFUL" -> Color(0xFF4CAF50) // Green
        "FOLLOW_UP" -> Color(0xFFFF9800) // Orange
        "NO_RESPONSE" -> Color(0xFF9E9E9E) // Gray
        "REJECTED" -> Color(0xFFF44336) // Red
        "INTERESTED" -> Color(0xFF2196F3) // Blue
        else -> Color(0xFF9E9E9E) // Default gray
    }
}
