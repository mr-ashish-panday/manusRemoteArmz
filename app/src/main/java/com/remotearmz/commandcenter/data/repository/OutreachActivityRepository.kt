package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao
import com.remotearmz.commandcenter.data.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OutreachActivityRepository @Inject constructor(
    private val outreachActivityDao: OutreachActivityDao
) {
    fun getAllOutreachActivities(): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getAllOutreachActivities()
    
    fun getOutreachActivitiesByContact(contactId: String, contactType: ContactType): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByContact(contactId, contactType)
    
    fun getOutreachActivitiesByType(type: OutreachType): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByType(type)
    
    fun getOutreachActivitiesByOutcome(outcome: OutreachOutcome): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByOutcome(outcome)
    
    fun getOutreachActivitiesRequiringFollowUp(currentTime: Long = System.currentTimeMillis()): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesRequiringFollowUp(currentTime)
    
    fun getOutreachActivitiesByDateRange(startDate: Long, endDate: Long): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByDateRange(startDate, endDate)
        
    fun getFollowUpsInRange(startTime: Long, endTime: Long): Flow<List<OutreachActivity>> =
        outreachActivityDao.getFollowUpsInRange(startTime, endTime)
    
    fun getOutreachCountByOutcome(outcome: OutreachOutcome): Flow<Int> = 
        outreachActivityDao.getOutreachCountByOutcome(outcome)
    
    fun getOutreachCountByType(type: OutreachType): Flow<Int> = 
        outreachActivityDao.getOutreachCountByType(type)
        
    suspend fun getOutreachCountsByType(): List<TypeCount> = 
        outreachActivityDao.getOutreachCountByType()
        
    suspend fun getOutreachCountsByOutcome(): List<OutcomeCount> = 
        outreachActivityDao.getOutreachCountByOutcome()
    
    fun getSuccessfulOutreachCount(): Flow<Int> = 
        outreachActivityDao.getSuccessfulOutreachCount()
    
    fun getTotalOutreachCount(): Flow<Int> = 
        outreachActivityDao.getTotalOutreachCount()
    
    fun getOutreachSuccessRate(): Flow<Float> {
        // Use a direct query from the DAO that calculates this in one step
        return outreachActivityDao.getOutreachSuccessRate()
    }
    
    suspend fun getOutreachActivityById(id: String): OutreachActivity? = 
        outreachActivityDao.getOutreachActivityById(id)
    
    suspend fun insertOutreachActivity(outreachActivity: OutreachActivity): Long = 
        outreachActivityDao.insertOutreachActivity(outreachActivity)
    
    suspend fun updateOutreachActivity(outreachActivity: OutreachActivity) = 
        outreachActivityDao.updateOutreachActivity(outreachActivity)
    
    suspend fun deleteOutreachActivity(outreachActivity: OutreachActivity) = 
        outreachActivityDao.deleteOutreachActivity(outreachActivity)
    
    suspend fun getLastContactTime(contactId: String, contactType: ContactType): Long? = 
        outreachActivityDao.getLastContactTime(contactId, contactType)
    
    suspend fun updateClientLastContactTime(clientId: String, clientRepository: ClientRepository) {
        val lastContactTime = getLastContactTime(clientId, ContactType.CLIENT) ?: return
        val client = clientRepository.getClientById(clientId) ?: return
        
        val updatedClient = client.copy(lastContactDate = lastContactTime)
        clientRepository.updateClient(updatedClient)
    }
}
