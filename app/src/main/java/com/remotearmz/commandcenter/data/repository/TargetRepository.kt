package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.TargetDao
import com.remotearmz.commandcenter.data.model.Target
import com.remotearmz.commandcenter.data.model.TargetCategory
import com.remotearmz.commandcenter.util.DateCountdownUtil
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TargetRepository @Inject constructor(
    private val targetDao: TargetDao
) {
    fun getAllTargets(): Flow<List<Target>> = targetDao.getAllTargets()
    
    fun getTargetsByCategory(category: TargetCategory): Flow<List<Target>> = 
        targetDao.getTargetsByCategory(category)
    
    fun getTargetsByCompletionStatus(isCompleted: Boolean): Flow<List<Target>> = 
        targetDao.getTargetsByCompletionStatus(isCompleted)
    
    fun getTargetsByDeadlineRange(startDate: Long, endDate: Long): Flow<List<Target>> = 
        targetDao.getTargetsByDeadlineRange(startDate, endDate)
    
    fun searchTargets(query: String): Flow<List<Target>> = targetDao.searchTargets(query)
    
    fun getCompletedTargetCount(): Flow<Int> = targetDao.getCompletedTargetCount()
    
    fun getTotalTargetCount(): Flow<Int> = targetDao.getTotalTargetCount()
    
    fun getUpcomingTargets(currentTime: Long = System.currentTimeMillis()): Flow<List<Target>> = 
        targetDao.getUpcomingTargets(currentTime)
    
    fun getOverdueTargets(currentTime: Long = System.currentTimeMillis()): Flow<List<Target>> = 
        targetDao.getOverdueTargets(currentTime)
    
    fun getAverageProgressByCategory(category: TargetCategory): Flow<Float?> = 
        targetDao.getAverageProgressByCategory(category)
    
    suspend fun getTargetById(id: String): Target? = targetDao.getTargetById(id)
    
    suspend fun insertTarget(target: Target): Long = targetDao.insertTarget(target)
    
    suspend fun updateTarget(target: Target) = targetDao.updateTarget(target)
    
    suspend fun deleteTarget(target: Target) = targetDao.deleteTarget(target)
    
    suspend fun updateTargetProgress(targetId: String, newValue: Double): Boolean {
        val target = getTargetById(targetId) ?: return false
        
        val isCompleted = newValue >= target.targetValue
        val updatedTarget = target.copy(
            currentValue = newValue,
            isCompleted = isCompleted
        )
        
        updateTarget(updatedTarget)
        return isCompleted
    }
    
    // Calculate the number of days remaining until May 30, 2026 (330 days from May 30, 2025)
    fun getRemainingDaysCounter(): Int {
        return DateCountdownUtil.getRemainingDaysUntilDeadline()
    }
}
