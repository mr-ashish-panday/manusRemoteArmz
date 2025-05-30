package com.remotearmz.commandcenter.util

import java.time.LocalDate
import java.time.ZoneId
import java.time.temporal.ChronoUnit

/**
 * Utility class for calculating date-related countdowns
 */
object DateCountdownUtil {
    
    /**
     * Calculate the number of days remaining until May 30, 2026
     * (330 days from May 30, 2025)
     */
    fun getRemainingDaysUntilDeadline(): Int {
        val today = LocalDate.now(ZoneId.systemDefault())
        val targetDate = LocalDate.of(2026, 5, 30)
        
        return ChronoUnit.DAYS.between(today, targetDate).toInt().coerceAtLeast(0)
    }
    
    /**
     * Calculate the number of days remaining until a specific date
     */
    fun getDaysUntil(targetMillis: Long): Int {
        val today = LocalDate.now(ZoneId.systemDefault())
        val targetDate = LocalDate.ofInstant(
            java.time.Instant.ofEpochMilli(targetMillis),
            ZoneId.systemDefault()
        )
        
        return ChronoUnit.DAYS.between(today, targetDate).toInt().coerceAtLeast(0)
    }
    
    /**
     * Calculate the number of days elapsed since a specific date
     */
    fun getDaysSince(pastMillis: Long): Int {
        val today = LocalDate.now(ZoneId.systemDefault())
        val pastDate = LocalDate.ofInstant(
            java.time.Instant.ofEpochMilli(pastMillis),
            ZoneId.systemDefault()
        )
        
        return ChronoUnit.DAYS.between(pastDate, today).toInt().coerceAtLeast(0)
    }
    
    /**
     * Get the progress percentage between two dates
     */
    fun getProgressPercentage(startMillis: Long, endMillis: Long): Float {
        val now = System.currentTimeMillis()
        
        // If now is before start, progress is 0%
        if (now < startMillis) return 0f
        
        // If now is after end, progress is 100%
        if (now > endMillis) return 100f
        
        val totalDuration = endMillis - startMillis
        val elapsedDuration = now - startMillis
        
        return (elapsedDuration.toFloat() / totalDuration) * 100f
    }
}
