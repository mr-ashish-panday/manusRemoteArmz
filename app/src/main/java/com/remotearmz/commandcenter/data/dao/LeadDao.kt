package com.remotearmz.commandcenter.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface LeadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLead(lead: Lead): Long
    
    @Update
    suspend fun updateLead(lead: Lead)
    
    @Delete
    suspend fun deleteLead(lead: Lead)
    
    @Query("SELECT * FROM leads ORDER BY createdAt DESC")
    fun getAllLeads(): Flow<List<Lead>>
    
    @Query("SELECT * FROM leads WHERE id = :leadId")
    suspend fun getLeadById(leadId: String): Lead?
    
    @Query("SELECT * FROM leads WHERE status = :status ORDER BY createdAt DESC")
    fun getLeadsByStatus(status: LeadStatus): Flow<List<Lead>>
    
    @Query("SELECT * FROM leads WHERE contactName LIKE '%' || :query || '%' OR company LIKE '%' || :query || '%' OR email LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchLeads(query: String): Flow<List<Lead>>
    
    @Query("SELECT * FROM leads WHERE probability BETWEEN :minProbability AND :maxProbability ORDER BY probability DESC")
    fun getLeadsByProbabilityRange(minProbability: Int, maxProbability: Int): Flow<List<Lead>>
    
    @Query("SELECT * FROM leads WHERE valueUSD >= :minValue ORDER BY valueUSD DESC")
    fun getLeadsByMinValue(minValue: Double): Flow<List<Lead>>
    
    @Query("SELECT * FROM leads WHERE expectedCloseDate BETWEEN :startDate AND :endDate")
    fun getLeadsByExpectedCloseDateRange(startDate: Long, endDate: Long): Flow<List<Lead>>
    
    @Query("SELECT COUNT(*) FROM leads")
    fun getLeadCount(): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM leads WHERE status NOT IN ('WON', 'LOST')")
    fun getActiveLeadCount(): Flow<Int>
    
    @Query("SELECT COUNT(*) FROM leads WHERE status = :status")
    fun getLeadCountByStatus(status: LeadStatus): Flow<Int>
    
    @Query("SELECT SUM(valueUSD) FROM leads")
    fun getTotalLeadValueUSD(): Flow<Double?>
    
    @Query("SELECT SUM(valueUSD * (probability / 100.0)) FROM leads")
    fun getWeightedLeadValueUSD(): Flow<Double?>
}
