package com.remotearmz.commandcenter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.remotearmz.commandcenter.data.model.Target
import com.remotearmz.commandcenter.data.model.TargetCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface TargetDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTarget(target: Target): Long
    
    @Update
    suspend fun updateTarget(target: Target)
    
    @Delete
    suspend fun deleteTarget(target: Target)
    
    @Query("SELECT * FROM targets ORDER BY deadline ASC")
    fun getAllTargets(): Flow<List<Target>>
    
    @Query("SELECT * FROM targets WHERE id = :targetId")
    suspend fun getTargetById(targetId: String): Target?
    
    @Query("SELECT * FROM targets WHERE category = :category ORDER BY deadline ASC")
    fun getTargetsByCategory(category: TargetCategory): Flow<List<Target>>
    
    @Query("SELECT * FROM targets WHERE isCompleted = :isCompleted ORDER BY deadline ASC")
    fun getTargetsByCompletionStatus(isCompleted: Boolean): Flow<List<Target>>
    
    @Query("SELECT * FROM targets WHERE deadline BETWEEN :startDate AND :endDate ORDER BY deadline ASC")
    fun getTargetsByDeadlineRange(startDate: Long, endDate: Long): Flow<List<Target>>
    
    @Query("SELECT * FROM targets WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%'")
    fun searchTargets(query: String): Flow<List<Target>>
    
    @Query("SELECT COUNT(*) FROM targets WHERE isCompleted = 1")
    fun getCompletedTargetCount(): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM targets")
    fun getTotalTargetCount(): Flow<Int>
    
    @Query("SELECT * FROM targets WHERE deadline > :currentTime AND isCompleted = 0 ORDER BY deadline ASC LIMIT 5")
    fun getUpcomingTargets(currentTime: Long): Flow<List<Target>>
    
    @Query("SELECT * FROM targets WHERE deadline < :currentTime AND isCompleted = 0 ORDER BY deadline ASC")
    fun getOverdueTargets(currentTime: Long): Flow<List<Target>>
    
    @Query("SELECT AVG(currentValue / targetValue * 100) FROM targets WHERE category = :category")
    fun getAverageProgressByCategory(category: TargetCategory): Flow<Float?>
}
