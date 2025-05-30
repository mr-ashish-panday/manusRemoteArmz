package com.remotearmz.commandcenter.ui.targets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.Priority
import com.remotearmz.commandcenter.data.model.Target
import com.remotearmz.commandcenter.data.model.TargetCategory
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository
import com.remotearmz.commandcenter.data.repository.TargetRepository
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
class TargetViewModel @Inject constructor(
    private val targetRepository: TargetRepository,
    private val activityLogRepository: ActivityLogRepository
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(TargetUiState())
    val uiState: StateFlow<TargetUiState> = _uiState.asStateFlow()
    
    private val _searchQuery = MutableStateFlow("")
    private val _filterCategory = MutableStateFlow<TargetCategory?>(null)
    private val _filterCompleted = MutableStateFlow<Boolean?>(null)
    
    val targets = combine(
        targetRepository.getAllTargets(),
        _searchQuery,
        _filterCategory,
        _filterCompleted
    ) { targets, query, category, completed ->
        var filteredTargets = targets
        
        // Apply search query filter
        if (query.isNotBlank()) {
            filteredTargets = filteredTargets.filter { target ->
                target.title.contains(query, ignoreCase = true) ||
                target.description.contains(query, ignoreCase = true)
            }
        }
        
        // Apply category filter
        if (category != null) {
            filteredTargets = filteredTargets.filter { it.category == category }
        }
        
        // Apply completion status filter
        if (completed != null) {
            filteredTargets = filteredTargets.filter { it.isCompleted == completed }
        }
        
        filteredTargets
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    val targetStats = targetRepository.getAllTargets().combine(
        targetRepository.getCompletedTargetCount()
    ) { allTargets, completedCount ->
        val totalCount = allTargets.size
        val completionRate = if (totalCount > 0) (completedCount.toFloat() / totalCount) * 100 else 0f
        
        val revenueTargets = allTargets.filter { it.category == TargetCategory.REVENUE }
        val clientTargets = allTargets.filter { it.category == TargetCategory.CLIENTS }
        val leadTargets = allTargets.filter { it.category == TargetCategory.LEADS }
        
        val overallProgress = if (allTargets.isNotEmpty()) {
            allTargets.sumOf { it.currentValue } / allTargets.sumOf { it.targetValue } * 100
        } else 0.0
        
        TargetStats(
            totalCount = totalCount,
            completedCount = completedCount,
            completionRate = completionRate,
            revenueTargetCount = revenueTargets.size,
            clientTargetCount = clientTargets.size,
            leadTargetCount = leadTargets.size,
            overallProgress = overallProgress.toFloat()
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = TargetStats()
    )
    
    init {
        loadTargets()
    }
    
    private fun loadTargets() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            try {
                // Targets are loaded via the StateFlow
                _uiState.value = _uiState.value.copy(isLoading = false, error = null)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateCategoryFilter(category: TargetCategory?) {
        _filterCategory.value = category
    }
    
    fun updateCompletedFilter(completed: Boolean?) {
        _filterCompleted.value = completed
    }
    
    fun saveTarget(target: Target) {
        viewModelScope.launch {
            try {
                val isNewTarget = target.id == UUID.randomUUID().toString()
                targetRepository.insertTarget(target)
                
                // Log the activity
                val action = if (isNewTarget) "Added Target" else "Updated Target"
                activityLogRepository.logActivity(
                    action = action,
                    details = "${target.title} (${target.category.name})",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isTargetSaved = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun deleteTarget(target: Target) {
        viewModelScope.launch {
            try {
                targetRepository.deleteTarget(target)
                
                // Log the activity
                activityLogRepository.logActivity(
                    action = "Deleted Target",
                    details = "${target.title} (${target.category.name})",
                    userId = "current-user" // Replace with actual user ID from auth
                )
                
                _uiState.value = _uiState.value.copy(isTargetDeleted = true)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun updateTargetProgress(targetId: String, newValue: Double) {
        viewModelScope.launch {
            try {
                val isCompleted = targetRepository.updateTargetProgress(targetId, newValue)
                
                // Log the activity
                val target = targetRepository.getTargetById(targetId)
                if (target != null) {
                    val action = if (isCompleted) "Completed Target" else "Updated Target Progress"
                    activityLogRepository.logActivity(
                        action = action,
                        details = "${target.title} progress updated to ${String.format("%.1f", target.progressPercentage)}%",
                        userId = "current-user" // Replace with actual user ID from auth
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(error = e.message)
            }
        }
    }
    
    fun resetSaveState() {
        _uiState.value = _uiState.value.copy(isTargetSaved = false, isTargetDeleted = false)
    }
    
    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
    
    fun getRemainingDaysCounter(): Int {
        return targetRepository.getRemainingDaysCounter()
    }
}

data class TargetUiState(
    val isLoading: Boolean = false,
    val isTargetSaved: Boolean = false,
    val isTargetDeleted: Boolean = false,
    val error: String? = null
)

data class TargetStats(
    val totalCount: Int = 0,
    val completedCount: Int = 0,
    val completionRate: Float = 0f,
    val revenueTargetCount: Int = 0,
    val clientTargetCount: Int = 0,
    val leadTargetCount: Int = 0,
    val overallProgress: Float = 0f
)
