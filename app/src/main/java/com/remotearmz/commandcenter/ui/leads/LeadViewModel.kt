package com.remotearmz.commandcenter.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers // Import Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext // Import withContext
import javax.inject.Inject

@HiltViewModel
class LeadViewModel @Inject constructor(
    private val leadRepository: LeadRepository,
    private val activityLogRepository: ActivityLogRepository
    // TODO: Inject an authentication manager or user repository to get the current user ID
) : ViewModel() {

    private val _uiState = MutableStateFlow(LeadUiState())
    val uiState: StateFlow<LeadUiState> = _uiState.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    private val _filterStatus = MutableStateFlow<LeadStatus?>(null)

    // Reactive flow for leads, automatically updates on data change, search, or filter
    val leads: StateFlow<List<Lead>> = combine(
        leadRepository.getAllLeads(),
        _searchQuery,
        _filterStatus
    ) { leads, query, status ->
        var filteredLeads = leads

        // Apply search query filter
        if (query.isNotBlank()) {
            filteredLeads = filteredLeads.filter { lead ->
                lead.contactName.contains(query, ignoreCase = true) ||
                (lead.company?.contains(query, ignoreCase = true) == true) || // Null check for company
                (lead.email?.contains(query, ignoreCase = true) == true) // Null check for email
            }
        }

        // Apply status filter
        if (status != null) {
            filteredLeads = filteredLeads.filter { it.status == status }
        }

        filteredLeads
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    // Reactive flow for lead statistics
    val leadStats: StateFlow<LeadStats> = leadRepository.getAllLeads().combine(
        leadRepository.getLeadCountByStatus(LeadStatus.WON) // Assuming this flow exists and emits Int
    ) { allLeads, wonCount ->
        val totalCount = allLeads.size
        val activeCount = allLeads.count { it.status == LeadStatus.CONTACTED || it.status == LeadStatus.QUALIFIED || it.status == LeadStatus.PROPOSAL || it.status == LeadStatus.NEGOTIATION }
        val lostCount = allLeads.count { it.status == LeadStatus.LOST }
        val newCount = allLeads.count { it.status == LeadStatus.NEW }

        val totalValueUSD = allLeads.sumOf { it.valueUSD ?: 0.0 } // Handle potential null value
        val weightedValueUSD = allLeads.sumOf { it.weightedValueUSD ?: 0.0 } // Handle potential null value

        LeadStats(
            totalCount = totalCount,
            activeCount = activeCount,
            wonCount = wonCount,
            lostCount = lostCount,
            newCount = newCount,
            conversionRate = if (totalCount > 0) (wonCount.toFloat() / totalCount) * 100 else 0f,
            totalValueUSD = totalValueUSD,
            weightedValueUSD = weightedValueUSD
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = LeadStats()
    )

    // No need for explicit loadLeads() function as StateFlow handles loading reactively
    // init { }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun updateStatusFilter(status: LeadStatus?) {
        _filterStatus.value = status
    }

    fun saveLead(lead: Lead) {
        viewModelScope.launch {
            try {
                // Check if lead exists to determine if we're updating or inserting
                val existingLead = leadRepository.getLeadById(lead.id)
                val isUpdating = existingLead != null
                
                if (isUpdating) {
                    leadRepository.updateLead(lead)
                } else {
                    leadRepository.insertLead(lead)
                }

                // Log the activity
                val action = if (isUpdating) "Updated Lead" else "Added Lead"
                logLeadActivity(action, lead)

                _uiState.value = _uiState.value.copy(isLeadSaved = true, error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Failed to save lead: ${e.message}")
            }
        }
    }

    fun deleteLead(lead: Lead) {
        viewModelScope.launch {
            try {
                leadRepository.deleteLead(lead)
                // Log the activity
                logLeadActivity("Deleted Lead", lead)
                _uiState.value = _uiState.value.copy(isLeadDeleted = true, error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Failed to delete lead: ${e.message}")
            }
        }
    }

    fun updateLeadStatus(lead: Lead, newStatus: LeadStatus) {
        viewModelScope.launch {
            try {
                val updatedLead = lead.copy(status = newStatus, updatedAt = System.currentTimeMillis())
                leadRepository.updateLead(updatedLead)
                // Log the activity
                logLeadActivity("Updated Lead Status to ${newStatus.name}", lead)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = "Failed to update lead status: ${e.message}")
            }
        }
    }

    // Helper function for logging activity
    private suspend fun logLeadActivity(action: String, lead: Lead) {
        // Use withContext(Dispatchers.IO) if repository operation is blocking
        activityLogRepository.logActivity(
            action = action,
            details = "${lead.contactName} (${lead.company ?: "N/A"})", // Handle null company
            userId = "TODO: Get Actual User ID" // Placeholder for actual user ID
        )
    }

    fun resetSaveState() {
        _uiState.value = _uiState.value.copy(isLeadSaved = false, isLeadDeleted = false)
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class LeadUiState(
    val isLoading: Boolean = false, // Consider removing if loading is handled implicitly by StateFlow
    val isLeadSaved: Boolean = false,
    val isLeadDeleted: Boolean = false,
    val error: String? = null
)

data class LeadStats(
    val totalCount: Int = 0,
    val activeCount: Int = 0,
    val wonCount: Int = 0,
    val lostCount: Int = 0,
    val newCount: Int = 0,
    val conversionRate: Float = 0f,
    val totalValueUSD: Double = 0.0,
    val weightedValueUSD: Double = 0.0
)

