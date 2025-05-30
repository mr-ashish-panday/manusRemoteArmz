package com.remotearmz.commandcenter.ui.outreach

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import com.remotearmz.commandcenter.data.repository.OutreachRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class OutreachViewModel @Inject constructor(
    private val outreachActivityRepository: OutreachActivityRepository,
    private val clientRepository: ClientRepository,
    private val leadRepository: LeadRepository,
    private val activityLogRepository: ActivityLogRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(OutreachUiState())
    val uiState: StateFlow<OutreachUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    private val _filterType = MutableStateFlow<OutreachType?>(null)
    private val _filterOutcome = MutableStateFlow<OutreachOutcome?>(null)
    private val _filterContactType = MutableStateFlow<ContactType?>(null)
    
    val outreachActivities = combine(
        outreachActivityRepository.getAllOutreachActivities(),
        _searchQuery,
        _filterType,
        _filterOutcome,
        _filterContactType
    ) { activities, query, type, outcome, contactType ->
        var filteredActivities = activities
        
        // Apply search query filter (search in notes)
        if (query.isNotBlank()) {
            filteredActivities = filteredActivities.filter { activity ->
                activity.notes.contains(query, ignoreCase = true)
            }
        }
        
        // Apply type filter
        if (type != null) {
            filteredActivities = filteredActivities.filter { it.type == type }
        }
        
        // Apply outcome filter
        if (outcome != null) {
            filteredActivities = filteredActivities.filter { it.outcome == outcome }
        }
        
        // Apply contact type filter
        if (contactType != null) {
            filteredActivities = filteredActivities.filter { it.contactType == contactType }
        }
        
        filteredActivities
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    val outreachStats = combine(
        outreachActivityRepository.getTotalOutreachCount(),
        outreachActivityRepository.getSuccessfulOutreachCount(),
        outreachActivityRepository.getOutreachCountByType(OutreachType.CALL),
        outreachActivityRepository.getOutreachCountByType(OutreachType.EMAIL),
        outreachActivityRepository.getOutreachCountByType(OutreachType.MEETING)
    ) { total, successful, calls, emails, meetings ->
        val successRate = if (total > 0) (successful.toFloat() / total) * 100 else 0f
        
        OutreachStats(
            totalCount = total,
            successfulCount = successful,
            successRate = successRate,
            callCount = calls,
            emailCount = emails,
            meetingCount = meetings
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = OutreachStats()
    )
    
    // Contacts for dropdown selection
    val clients = clientRepository.getAllClients().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    val leads = leadRepository.getAllLeads().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    // Follow-ups that need attention
    val followUps = outreachActivityRepository.getOutreachActivitiesRequiringFollowUp().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    init {
        loadOutreachActivities()
    }
    
    private fun loadOutreachActivities() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // Activities are loaded via the StateFlow
                // Load type and outcome counts using the new methods
                val typeCountsList = outreachActivityRepository.getOutreachCountsByType()
                val outcomeCountsList = outreachActivityRepository.getOutreachCountsByOutcome()
                
                // Process counts as needed for your UI (can be used in other UI components)
                
                _uiState.value = _uiState.value.copy(isLoading = false, error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateTypeFilter(type: OutreachType?) {
        _filterType.value = type
    }
    
    fun updateOutcomeFilter(outcome: OutreachOutcome?) {
        _filterOutcome.value = outcome
    }
    
    fun updateContactTypeFilter(contactType: ContactType?) {
        _filterContactType.value = contactType
    }
    
    fun saveOutreachActivity(outreachActivity: OutreachActivity) {
        viewModelScope.launch {
            try {
                val isNewActivity = outreachActivity.id == UUID.randomUUID().toString()
                outreachActivityRepository.insertOutreachActivity(outreachActivity)
                
                // Update client's last contact date if this is a client outreach
                if (outreachActivity.contactType == ContactType.CLIENT) {
                    outreachActivityRepository.updateClientLastContactTime(
                        outreachActivity.contactId,
                        clientRepository
                    )
                }
                
                // Log the activity
                val action = if (isNewActivity) "Added Outreach Activity" else "Updated Outreach Activity"
                val contactName = when (outreachActivity.contactType) {
                    ContactType.CLIENT -> clientRepository.getClientById(outreachActivity.contactId)?.name ?: "Unknown"
                    ContactType.LEAD -> leadRepository.getLeadById(outreachActivity.contactId)?.contactName ?: "Unknown"
                }
                
                activityLogRepository.logActivity(
                    action = action,
                    details = "${outreachActivity.type.name} with $contactName",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isActivitySaved = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun deleteOutreachActivity(outreachActivity: OutreachActivity) {
        viewModelScope.launch {
            try {
                outreachActivityRepository.deleteOutreachActivity(outreachActivity)
                
                // Log the activity
                val contactName = when (outreachActivity.contactType) {
                    ContactType.CLIENT -> clientRepository.getClientById(outreachActivity.contactId)?.name ?: "Unknown"
                    ContactType.LEAD -> leadRepository.getLeadById(outreachActivity.contactId)?.contactName ?: "Unknown"
                }
                
                activityLogRepository.logActivity(
                    action = "Deleted Outreach Activity",
                    details = "${outreachActivity.type.name} with $contactName",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isActivityDeleted = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun markFollowUpComplete(outreachActivity: OutreachActivity) {
        viewModelScope.launch {
            try {
                val updatedActivity = outreachActivity.copy(
                    followUpRequired = false,
                    followUpDate = null
                )
                outreachActivityRepository.updateOutreachActivity(updatedActivity)
                
                // Log the activity
                val contactName = when (outreachActivity.contactType) {
                    ContactType.CLIENT -> clientRepository.getClientById(outreachActivity.contactId)?.name ?: "Unknown"
                    ContactType.LEAD -> leadRepository.getLeadById(outreachActivity.contactId)?.contactName ?: "Unknown"
                }
                
                activityLogRepository.logActivity(
                    action = "Completed Follow-Up",
                    details = "Follow-up with $contactName marked as complete",
                    userId = "current-user" // Replace with actual user ID from auth
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun resetSaveState() {
        _uiState.value = _uiState.value.copy(isActivitySaved = false, isActivityDeleted = false)
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class OutreachUiState(
    val isLoading: Boolean = false,
    val isActivitySaved: Boolean = false,
    val isActivityDeleted: Boolean = false,
    val error: String? = null
)

data class OutreachStats(
    val totalCount: Int = 0,
    val successfulCount: Int = 0,
    val successRate: Float = 0f,
    val callCount: Int = 0,
    val emailCount: Int = 0,
    val meetingCount: Int = 0
)
