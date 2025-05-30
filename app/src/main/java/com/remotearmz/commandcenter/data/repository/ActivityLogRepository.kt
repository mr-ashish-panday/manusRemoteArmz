package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.ActivityLogDao
import com.remotearmz.commandcenter.data.model.ActivityLog
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityLogRepository @Inject constructor(
    private val activityLogDao: ActivityLogDao
) {
    fun getAllActivityLogs(): Flow<List<ActivityLog>> = activityLogDao.getAllActivityLogs()
    
    fun getActivityLogsByActionType(actionType: String): Flow<List<ActivityLog>> = 
        activityLogDao.getActivityLogsByActionType(actionType)
    
    fun getActivityLogsByUser(userId: String): Flow<List<ActivityLog>> = 
        activityLogDao.getActivityLogsByUser(userId)
    
    fun getActivityLogsByTimeRange(startTime: Long, endTime: Long): Flow<List<ActivityLog>> = 
        activityLogDao.getActivityLogsByTimeRange(startTime, endTime)
    
    fun getRecentActivityLogs(limit: Int = 50): Flow<List<ActivityLog>> = 
        activityLogDao.getRecentActivityLogs(limit)
    
    fun getActionCount(actionType: String): Flow<Int> = activityLogDao.getActionCount(actionType)
    
    suspend fun insertActivityLog(activityLog: ActivityLog): Long = 
        activityLogDao.insertActivityLog(activityLog)
    
    suspend fun deleteActivityLog(activityLog: ActivityLog) = 
        activityLogDao.deleteActivityLog(activityLog)
    
    suspend fun deleteOldActivityLogs(cutoffTime: Long) = 
        activityLogDao.deleteOldActivityLogs(cutoffTime)
    
    suspend fun logActivity(action: String, details: String, userId: String) {
        val activityLog = ActivityLog(
            action = action,
            details = details,
            timestamp = System.currentTimeMillis(),
            userId = userId
        )
        insertActivityLog(activityLog)
    }
}
