package com.remotearmz.commandcenter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.remotearmz.commandcenter.data.model.ActivityLog
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertActivityLog(activityLog: ActivityLog): Long
    
    @Delete
    suspend fun deleteActivityLog(activityLog: ActivityLog)
    
    @Query("SELECT * FROM activity_logs ORDER BY timestamp DESC")
    fun getAllActivityLogs(): Flow<List<ActivityLog>>
    
    @Query("SELECT * FROM activity_logs WHERE action LIKE '%' || :actionType || '%' ORDER BY timestamp DESC")
    fun getActivityLogsByActionType(actionType: String): Flow<List<ActivityLog>>
    
    @Query("SELECT * FROM activity_logs WHERE userId = :userId ORDER BY timestamp DESC")
    fun getActivityLogsByUser(userId: String): Flow<List<ActivityLog>>
    
    @Query("SELECT * FROM activity_logs WHERE timestamp BETWEEN :startTime AND :endTime ORDER BY timestamp DESC")
    fun getActivityLogsByTimeRange(startTime: Long, endTime: Long): Flow<List<ActivityLog>>
    
    @Query("SELECT * FROM activity_logs ORDER BY timestamp DESC LIMIT :limit")
    fun getRecentActivityLogs(limit: Int): Flow<List<ActivityLog>>
    
    @Query("DELETE FROM activity_logs WHERE timestamp < :cutoffTime")
    suspend fun deleteOldActivityLogs(cutoffTime: Long)
    
    @Query("SELECT COUNT(*) FROM activity_logs WHERE action LIKE '%' || :actionType || '%'")
    fun getActionCount(actionType: String): Flow<Int>
}
