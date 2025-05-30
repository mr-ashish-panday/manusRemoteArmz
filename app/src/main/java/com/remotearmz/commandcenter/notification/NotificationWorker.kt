package com.remotearmz.commandcenter.notification

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import com.remotearmz.commandcenter.data.repository.OutreachRepository
import com.remotearmz.commandcenter.data.repository.TargetRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.first
import java.util.Calendar
import java.util.concurrent.TimeUnit

@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val outreachRepository: OutreachRepository,
    private val clientRepository: ClientRepository,
    private val leadRepository: LeadRepository,
    private val targetRepository: TargetRepository,
    private val notificationHelper: NotificationHelper
) : CoroutineWorker(context, params) {
    
    companion object {
        const val WORK_NAME = "notification_worker"
    }
    
    override suspend fun doWork(): Result {
        try {
            // Check for follow-ups due today
            checkFollowUps()
            
            // Check for target deadlines approaching
            checkTargetDeadlines()
            
            // Check for weekly summary (on Monday)
            checkWeeklySummary()
            
            return Result.success()
        } catch (e: Exception) {
            e.printStackTrace()
            return Result.retry()
        }
    }
    
    private suspend fun checkFollowUps() {
        val currentTime = System.currentTimeMillis()
        val endOfDay = Calendar.getInstance().apply {
            timeInMillis = currentTime
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis
        
        val followUps = outreachRepository.getFollowUpsInRange(currentTime, endOfDay).first()
        
        followUps.forEach { activity ->
            val contactName = when (activity.contactType.name) {
                "CLIENT" -> clientRepository.getClientById(activity.contactId)?.name ?: "Unknown"
                "LEAD" -> leadRepository.getLeadById(activity.contactId)?.contactName ?: "Unknown"
                else -> "Unknown"
            }
            
            notificationHelper.showFollowUpNotification(activity, contactName)
        }
    }
    
    private suspend fun checkTargetDeadlines() {
        val currentTime = System.currentTimeMillis()
        
        // Get targets with deadlines in the next 7 days
        val sevenDaysFromNow = currentTime + TimeUnit.DAYS.toMillis(7)
        val targets = targetRepository.getTargetsByDeadlineRange(currentTime, sevenDaysFromNow).first()
        
        targets.forEach { target ->
            val daysRemaining = target.remainingDays
            
            // Notify for targets with 7, 3, or 1 day remaining
            if (daysRemaining in listOf(7, 3, 1)) {
                notificationHelper.showTargetDeadlineNotification(target, daysRemaining)
            }
        }
    }
    
    private suspend fun checkWeeklySummary() {
        val calendar = Calendar.getInstance()
        
        // Check if today is Monday (Calendar.MONDAY = 2)
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            val clientCount = clientRepository.getAllClients().first().size
            val leadCount = leadRepository.getActiveLeadCount().first()
            
            // Get overall target progress
            val targets = targetRepository.getAllTargets().first()
            val targetProgress = if (targets.isNotEmpty()) {
                targets.sumOf { it.progressPercentage.toDouble() } / targets.size
            } else 0.0
            
            // Get outreach success rate
            val outreachActivities = outreachRepository.getAllOutreachActivities().first()
            val successfulOutreach = outreachActivities.count { 
                it.outcome.name == "SUCCESSFUL" || it.outcome.name == "INTERESTED" 
            }
            val outreachSuccessRate = if (outreachActivities.isNotEmpty()) {
                successfulOutreach.toFloat() / outreachActivities.size * 100
            } else 0f
            
            notificationHelper.showWeeklySummaryNotification(
                clientCount,
                leadCount,
                targetProgress.toFloat(),
                outreachSuccessRate
            )
        }
    }
}
