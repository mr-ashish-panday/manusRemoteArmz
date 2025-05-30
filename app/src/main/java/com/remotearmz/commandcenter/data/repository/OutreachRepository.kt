package com.remotearmz.commandcenter.data.repository

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OutreachRepository @Inject constructor(
    private val outreachActivityDao: OutreachActivityDao
) {
    fun getAllOutreachActivities(): Flow<List<OutreachActivity>> = outreachActivityDao.getAllOutreachActivities()
    
    fun getOutreachActivitiesByType(type: OutreachType): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByType(type)
    
    fun getOutreachActivitiesByOutcome(outcome: OutreachOutcome): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByOutcome(outcome)
    
    fun getOutreachActivitiesByContactType(contactType: ContactType): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByContactType(contactType)
    
    fun getOutreachActivitiesByContactId(contactId: String): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getOutreachActivitiesByContactId(contactId)
    
    fun getFollowUpActivities(): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getFollowUpActivities()
    
    fun getFollowUpsInRange(startTime: Long, endTime: Long): Flow<List<OutreachActivity>> = 
        outreachActivityDao.getFollowUpsInRange(startTime, endTime)
    
    fun searchOutreachActivities(query: String): Flow<List<OutreachActivity>> = 
        outreachActivityDao.searchOutreachActivities(query)
    
    fun getOutreachSuccessRate(): Flow<Float> = outreachActivityDao.getOutreachSuccessRate()
    
    fun getOutreachCountByType(): Flow<Map<OutreachType, Int>> = outreachActivityDao.getOutreachCountByType()
    
    fun getOutreachCountByOutcome(): Flow<Map<OutreachOutcome, Int>> = outreachActivityDao.getOutreachCountByOutcome()
    
    suspend fun getOutreachActivityById(id: String): OutreachActivity? = outreachActivityDao.getOutreachActivityById(id)
    
    suspend fun insertOutreachActivity(outreachActivity: OutreachActivity): Long = outreachActivityDao.insertOutreachActivity(outreachActivity)
    
    suspend fun updateOutreachActivity(outreachActivity: OutreachActivity) = outreachActivityDao.updateOutreachActivity(outreachActivity)
    
    suspend fun deleteOutreachActivity(outreachActivity: OutreachActivity) = outreachActivityDao.deleteOutreachActivity(outreachActivity)
}
