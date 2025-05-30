package com.remotearmz.commandcenter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import kotlinx.coroutines.flow.Flow

@Dao
interface OutreachActivityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOutreachActivity(outreachActivity: OutreachActivity): Long
    
    @Update
    suspend fun updateOutreachActivity(outreachActivity: OutreachActivity)
    
    @Delete
    suspend fun deleteOutreachActivity(outreachActivity: OutreachActivity)
    
    @Query("SELECT * FROM outreach_activities ORDER BY createdAt DESC")
    fun getAllOutreachActivities(): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE id = :outreachActivityId")
    suspend fun getOutreachActivityById(outreachActivityId: String): OutreachActivity?
    
    @Query("SELECT * FROM outreach_activities WHERE contactId = :contactId AND contactType = :contactType ORDER BY createdAt DESC")
    fun getOutreachActivitiesByContact(contactId: String, contactType: ContactType): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE type = :type ORDER BY createdAt DESC")
    fun getOutreachActivitiesByType(type: OutreachType): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE outcome = :outcome ORDER BY createdAt DESC")
    fun getOutreachActivitiesByOutcome(outcome: OutreachOutcome): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND (followUpDate IS NULL OR followUpDate <= :currentTime) ORDER BY followUpDate ASC NULLS LAST")
    fun getOutreachActivitiesRequiringFollowUp(currentTime: Long): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE followUpRequired = 1 AND followUpDate BETWEEN :startTime AND :endTime ORDER BY followUpDate ASC")
    fun getFollowUpsInRange(startTime: Long, endTime: Long): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE followUpRequired = 1 ORDER BY followUpDate ASC")
    fun getFollowUpActivities(): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE createdAt BETWEEN :startDate AND :endDate ORDER BY createdAt DESC")
    fun getOutreachActivitiesByDateRange(startDate: Long, endDate: Long): Flow<List<OutreachActivity>>
    
    @Query("SELECT COUNT(*) FROM outreach_activities WHERE outcome = :outcome")
    fun getOutreachCountByOutcome(outcome: OutreachOutcome): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM outreach_activities WHERE type = :type")
    fun getOutreachCountByType(type: OutreachType): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM outreach_activities WHERE outcome = :successOutcome")
    fun getSuccessfulOutreachCount(successOutcome: OutreachOutcome = OutreachOutcome.SUCCESSFUL): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM outreach_activities")
    fun getTotalOutreachCount(): Flow<Int>
    
    @Query("SELECT * FROM outreach_activities WHERE notes LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchOutreachActivities(query: String): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE contactId = :contactId ORDER BY createdAt DESC")
    fun getOutreachActivitiesByContactId(contactId: String): Flow<List<OutreachActivity>>
    
    @Query("SELECT * FROM outreach_activities WHERE contactType = :contactType ORDER BY createdAt DESC")
    fun getOutreachActivitiesByContactType(contactType: ContactType): Flow<List<OutreachActivity>>
    
    @Query("SELECT CASE WHEN COUNT(*) = 0 THEN 0 ELSE CAST(COUNT(CASE WHEN outcome = 'SUCCESSFUL' OR outcome = 'INTERESTED' THEN 1 END) AS FLOAT) / COUNT(*) * 100 END FROM outreach_activities")
    fun getOutreachSuccessRate(): Flow<Float>
    
    @Query("SELECT type, COUNT(*) as count FROM outreach_activities GROUP BY type")
    fun getOutreachCountByType(): Flow<Map<OutreachType, Int>>
    
    @Query("SELECT outcome, COUNT(*) as count FROM outreach_activities GROUP BY outcome")
    fun getOutreachCountByOutcome(): Flow<Map<OutreachOutcome, Int>>
    
    @Query("SELECT MAX(createdAt) FROM outreach_activities WHERE contactId = :contactId AND contactType = :contactType")
    suspend fun getLastContactTime(contactId: String, contactType: ContactType): Long?
}
