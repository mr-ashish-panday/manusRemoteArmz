package com.remotearmz.commandcenter.notification

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository
import com.remotearmz.commandcenter.data.repository.TargetRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import android.util.Log
import java.util.Calendar
import java.util.concurrent.TimeUnit

@HiltWorker
class NotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val outreachRepository: OutreachActivityRepository,
    private val clientRepository: ClientRepository,
    private val leadRepository: LeadRepository,
    private val targetRepository: TargetRepository,
    private val notificationHelper: NotificationHelper
) : CoroutineWorker(context, params) {
    
    private val coroutineScope = CoroutineScope(Dispatchers.Default + SupervisorJob())

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
            // Consider more specific error handling or logging
            return Result.retry()
        }
    }

    private suspend fun checkFollowUps() {
        try {
            val currentTime = System.currentTimeMillis()
            val calendar = Calendar.getInstance().apply {
                timeInMillis = currentTime
                set(Calendar.HOUR_OF_DAY, 23)
                set(Calendar.MINUTE, 59)
                set(Calendar.SECOND, 59)
                set(Calendar.MILLISECOND, 999)
            }
            val endOfDay = calendar.timeInMillis

            // Fetch follow-ups due between now and end of today
            val followUps = try {
                outreachRepository.getFollowUpsInRange(currentTime, endOfDay).first()
            } catch (e: Exception) {
                Log.e("NotificationWorker", "Error fetching follow-ups: ${e.message}")
                emptyList()
            }

            // Process follow-ups in parallel
            followUps.map { activity ->
                coroutineScope.launch {
                    try {
                        // Fetch contact name based on type
                        val contactName = when (activity.contactType) {
                            ContactType.CLIENT -> {
                                clientRepository.getClientById(activity.contactId)?.name ?: "Unknown Client"
                            }
                            ContactType.LEAD -> {
                                leadRepository.getLeadById(activity.contactId)?.contactName ?: "Unknown Lead"
                            }
                        }
                        notificationHelper.showFollowUpNotification(activity, contactName)
                    } catch (e: Exception) {
                        Log.e("NotificationWorker", "Error processing follow-up: ${e.message}")
                    }
                }
            }.joinAll()
        } catch (e: Exception) {
            Log.e("NotificationWorker", "Error in checkFollowUps: ${e.message}")
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
            // Get client count for weekly summary
            @Suppress("UNUSED_VARIABLE")
            val clientCount = clientRepository.getAllClients().first().size
            val leadCount = leadRepository.getActiveLeadCount().first()

            // Get overall target progress
            // TODO: Consider adding a DAO query for overall average progress if performance becomes an issue
            val targets = targetRepository.getAllTargets().first()
            val targetProgress = if (targets.isNotEmpty()) {
                targets.sumOf { it.progressPercentage.toDouble() } / targets.size
            } else 0.0

            // Get outreach success rate using the dedicated repository/DAO method
            val outreachSuccessRate = outreachRepository.getOutreachSuccessRate().first()

            notificationHelper.showWeeklySummaryNotification(
                clientCount,
                leadCount,
                targetProgress.toFloat(),
                outreachSuccessRate
            )
        }
    }
}

