package com.remotearmz.commandcenter.ui.leads

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository
import com.remotearmz.commandcenter.data.repository.LeadRepository
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
class LeadViewModel @Inject constructor(
    private val leadRepository: LeadRepository,
    private val activityLogRepository: ActivityLogRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(LeadUiState())
    val uiState: StateFlow<LeadUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    private val _filterStatus = MutableStateFlow<LeadStatus?>(null)
    
    val leads = combine(
        leadRepository.getAllLeads(),
        _searchQuery,
        _filterStatus
    ) { leads, query, status ->
        var filteredLeads = leads
        
        // Apply search query filter
        if (query.isNotBlank()) {
            filteredLeads = filteredLeads.filter { lead ->
                lead.contactName.contains(query, ignoreCase = true) ||
                lead.company.contains(query, ignoreCase = true) ||
                lead.email.contains(query, ignoreCase = true)
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
    
    val leadStats = leadRepository.getAllLeads().combine(
        leadRepository.getLeadCountByStatus(LeadStatus.WON)
    ) { allLeads, wonCount ->
        val totalCount = allLeads.size
        val activeCount = allLeads.count { it.status == LeadStatus.ACTIVE }
        val lostCount = allLeads.count { it.status == LeadStatus.LOST }
        val newCount = allLeads.count { it.status == LeadStatus.NEW }
        
        val totalValueUSD = allLeads.sumOf { it.valueUSD }
        val weightedValueUSD = allLeads.sumOf { it.weightedValueUSD }
        
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
    
    init {
        loadLeads()
    }
    
    private fun loadLeads() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // Leads are loaded via the StateFlow
                _uiState.value = _uiState.value.copy(isLoading = false, error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateStatusFilter(status: LeadStatus?) {
        _filterStatus.value = status
    }
    
    fun saveLead(lead: Lead) {
        viewModelScope.launch {
            try {
                val isNewLead = lead.id == UUID.randomUUID().toString()
                leadRepository.insertLead(lead)
                
                // Log the activity
                val action = if (isNewLead) "Added Lead" else "Updated Lead"
                activityLogRepository.logActivity(
                    action = action,
                    details = "${lead.contactName} (${lead.company})",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isLeadSaved = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun deleteLead(lead: Lead) {
        viewModelScope.launch {
            try {
                leadRepository.deleteLead(lead)
                
                // Log the activity
                activityLogRepository.logActivity(
                    action = "Deleted Lead",
                    details = "${lead.contactName} (${lead.company})",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isLeadDeleted = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun updateLeadStatus(lead: Lead, newStatus: LeadStatus) {
        viewModelScope.launch {
            try {
                val updatedLead = lead.copy(status = newStatus, updatedAt = System.currentTimeMillis())
                leadRepository.updateLead(updatedLead)
                
                // Log the activity
                activityLogRepository.logActivity(
                    action = "Updated Lead Status",
                    details = "${lead.contactName} status changed to ${newStatus.name}",
                    userId = "current-user" // Replace with actual user ID from auth
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun resetSaveState() {
        _uiState.value = _uiState.value.copy(isLeadSaved = false, isLeadDeleted = false)
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}

data class LeadUiState(
    val isLoading: Boolean = false,
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
