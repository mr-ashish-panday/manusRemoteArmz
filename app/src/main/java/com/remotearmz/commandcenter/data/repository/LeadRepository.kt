package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.LeadDao
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LeadRepository @Inject constructor(
    private val leadDao: LeadDao
) {
    fun getAllLeads(): Flow<List<Lead>> = leadDao.getAllLeads()
    
    fun getLeadsByStatus(status: LeadStatus): Flow<List<Lead>> = leadDao.getLeadsByStatus(status)
    
    fun searchLeads(query: String): Flow<List<Lead>> = leadDao.searchLeads(query)
    
    fun getLeadsByProbabilityRange(minProbability: Int, maxProbability: Int): Flow<List<Lead>> = 
        leadDao.getLeadsByProbabilityRange(minProbability, maxProbability)
    
    fun getLeadsByMinValue(minValue: Double): Flow<List<Lead>> = leadDao.getLeadsByMinValue(minValue)
    
    fun getLeadsByExpectedCloseDateRange(startDate: Long, endDate: Long): Flow<List<Lead>> = 
        leadDao.getLeadsByExpectedCloseDateRange(startDate, endDate)
    
    fun getLeadCount(): Flow<Int> = leadDao.getLeadCount()
    
    fun getActiveLeadCount(): Flow<Int> = leadDao.getActiveLeadCount()
    
    fun getLeadCountByStatus(status: LeadStatus): Flow<Int> = leadDao.getLeadCountByStatus(status)
    
    fun getTotalLeadValueUSD(): Flow<Double?> = leadDao.getTotalLeadValueUSD()
    
    fun getWeightedLeadValueUSD(): Flow<Double?> = leadDao.getWeightedLeadValueUSD()
    
    suspend fun getLeadById(id: String): Lead? = leadDao.getLeadById(id)
    
    suspend fun insertLead(lead: Lead): Long = leadDao.insertLead(lead)
    
    suspend fun updateLead(lead: Lead) = leadDao.updateLead(lead)
    
    suspend fun deleteLead(lead: Lead) = leadDao.deleteLead(lead)
    
    suspend fun convertLeadToClient(lead: Lead, clientId: String) {
        val updatedLead = lead.copy(
            status = LeadStatus.WON,
            clientId = clientId,
            updatedAt = System.currentTimeMillis()
        )
        updateLead(updatedLead)
    }
}
