package com.remotearmz.commandcenter.ui.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.repository.LeadRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import kotlin.math.roundToInt

/**
 * UI state for the Dashboard screen
 */
data class DashboardUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    // Lead metrics
    val totalLeads: Int = 0,
    val activeClients: Int = 0,
    val newLeads: Int = 0,
    val contactedLeads: Int = 0,
    val qualifiedLeads: Int = 0,
    val proposalSentLeads: Int = 0,
    val closedWonLeads: Int = 0,
    val closedLostLeads: Int = 0,
    val followUpLeads: Int = 0,
    val leadTarget: Int = 100, // Default target
    // Performance metrics
    val totalRevenue: Double = 0.0,
    val avgDealSize: Double = 0.0,
    val avgResponseTime: Float = 0f, // in hours
    val avgSalesCycleDays: Int = 0,
    val conversionRate: Float = 0f,
    // UI state
    val pendingActions: Int = 0,
    val monthlyRevenue: List<Double> = emptyList(),
    val recentLeads: List<Lead> = emptyList(),
    val selectedLeadStatus: LeadStatus? = null
)

/**
 * ViewModel for the Dashboard screen that handles business logic and state management
 */
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val leadRepository: LeadRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(DashboardUiState(isLoading = true))
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadDashboardData()
        // Refresh data every 5 minutes
        viewModelScope.launch {
            while (true) {
                kotlinx.coroutines.delay(5 * 60 * 1000) // 5 minutes
                refreshData()
            }
        }
    }


    /**
     * Refresh all dashboard data
     */
    fun refreshData() {
        _uiState.update { it.copy(isLoading = true) }
        loadDashboardData()
    }

    /**
     * Filter leads by status
     */
    fun filterLeadsByStatus(status: LeadStatus) {
        _uiState.update { it.copy(selectedLeadStatus = status) }
        // In a real app, this would navigate to the leads screen with the filter applied
    }

    /**
     * Show leads that need follow-up
     */
    fun filterFollowUpLeads() {
        // In a real app, this would navigate to the leads screen with follow-up filter
        _uiState.update { it.copy(selectedLeadStatus = null) }
    }

    /**
     * Show notifications panel
     */
    fun showNotifications() {
        // Implementation would open notifications bottom sheet/dialog
    }

    /**
     * Navigate to conversion funnel analysis
     */
    fun analyzeConversionFunnel() {
        // Implementation would navigate to detailed conversion analysis
    }

    /**
     * Load all dashboard data from repositories
     */
    private fun loadDashboardData() {
        viewModelScope.launch {
            try {
                // Load data in parallel
                val leadsDeferred = async { leadRepository.getAllLeads() }
                val clientsDeferred = async { leadRepository.getActiveClients() }
                val activitiesDeferred = async { leadRepository.getRecentActivities() }
                
                // Wait for all data to load
                val leads = leadsDeferred.await()
                val activeClients = clientsDeferred.await()
                val activities = activitiesDeferred.await()
                
                // Calculate metrics
                val leadMetrics = calculateLeadMetrics(leads)
                val performanceMetrics = calculatePerformanceMetrics(leads, activeClients)
                
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        error = null,
                        totalLeads = leads.size,
                        activeClients = activeClients.size,
                        newLeads = leadMetrics.newLeads,
                        contactedLeads = leadMetrics.contactedLeads,
                        qualifiedLeads = leadMetrics.qualifiedLeads,
                        proposalSentLeads = leadMetrics.proposalSentLeads,
                        closedWonLeads = leadMetrics.closedWonLeads,
                        closedLostLeads = leadMetrics.closedLostLeads,
                        followUpLeads = leadMetrics.followUpLeads,
                        totalRevenue = performanceMetrics.totalRevenue,
                        avgDealSize = performanceMetrics.avgDealSize,
                        avgResponseTime = performanceMetrics.avgResponseTime,
                        avgSalesCycleDays = performanceMetrics.avgSalesCycleDays,
                        conversionRate = performanceMetrics.conversionRate,
                        pendingActions = activities.count { !it.completed },
                        recentLeads = leads.take(5),
                        monthlyRevenue = calculateMonthlyRevenue()
                    )
                }
                
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "An error occurred"
                )
            }
        }
    }

    fun refreshData() {
        loadDashboardData()
    }
}

data class DashboardUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val monthlyRevenue: List<Pair<String, Float>> = emptyList(),
    val conversionRates: List<Pair<String, Float>> = emptyList(),
    val targetProgress: Float = 0f,
    val totalRevenue: Double = 0.0,
    val activeClients: Int = 0,
    val leadConversionRate: Int = 0,
    val successRate: Float = 0f
)
