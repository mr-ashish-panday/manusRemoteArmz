package com.remotearmz.commandcenter.ui.clients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import com.remotearmz.commandcenter.data.repository.ClientRepository
import com.remotearmz.commandcenter.ui.clients.ClientsScreenState.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import java.io.IOException
import javax.inject.Inject

sealed interface UiState<out T> {
    data object Loading : UiState<Nothing>
    data class Success<T>(val data: T) : UiState<T>
    data class Error(val message: String? = null) : UiState<Nothing>
}

@HiltViewModel
class ClientsViewModel @Inject constructor(
    private val clientRepository: ClientRepository
) : ViewModel() {
    
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()
    
    private val _statusFilter = MutableStateFlow<ClientStatus?>(null)
    val statusFilter: StateFlow<ClientStatus?> = _statusFilter.asStateFlow()
    
    private val _isAddingClient = MutableStateFlow(false)
    val isAddingClient: StateFlow<Boolean> = _isAddingClient.asStateFlow()
    
    private val _editingClient = MutableStateFlow<Client?>(null)
    val editingClient: StateFlow<Client?> = _editingClient.asStateFlow()
    
    private val _uiState = MutableStateFlow<UiState<List<Client>>>(UiState.Loading)
    val uiState: StateFlow<UiState<List<Client>>> = _uiState.asStateFlow()
    
    private val _clients = MutableStateFlow<List<Client>>(emptyList())
    
    init {
        // Combine search query and status filter to update the UI
        viewModelScope.launch {
            combine(
                _searchQuery.debounce(300).distinctUntilChanged(),
                _statusFilter.distinctUntilChanged()
            ) { query, status ->
                Pair(query, status)
            }.collectLatest { (query, status) ->
                _uiState.value = UiState.Loading
                try {
                    val clientsFlow = if (query.isNotBlank()) {
                        clientRepository.searchClients(query)
                    } else {
                        clientRepository.getAllClients()
                    }
                    
                    clientsFlow.collect { result ->
                        result.fold(
                            onSuccess = { clients ->
                                val filteredClients = status?.let { status ->
                                    clients.filter { it.status == status }
                                } ?: clients
                                
                                _clients.value = filteredClients
                                _uiState.value = UiState.Success(filteredClients)
                            },
                            onFailure = { e ->
                                _uiState.value = UiState.Error(e.message ?: "An error occurred")
                            }
                        )
                    }
                } catch (e: Exception) {
                    _uiState.value = UiState.Error(e.message ?: "An error occurred")
                }
            }
        }
    }
    
    fun loadClients() {
        _searchQuery.value = ""
        _statusFilter.value = null
    }
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateStatusFilter(status: ClientStatus?) {
        _statusFilter.value = status
    }
    
    // Removed as we're handling status filter through _statusFilter directly
    
    fun showAddClientDialog() {
        _isAddingClient.value = true
        _editingClient.value = null
    }
    
    fun hideAddClientDialog() {
        _isAddingClient.value = false
    }
    
    fun showEditClientDialog(client: Client) {
        _editingClient.value = client
        _isAddingClient.value = true
    }
    
    fun hideEditClientDialog() {
        _editingClient.value = null
        _isAddingClient.value = false
    }
    
    fun addClient(client: Client) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when (val result = clientRepository.insertClient(client)) {
                is Result.Success -> {
                    loadClients() // Refresh the list
                    hideAddClientDialog()
                }
                is Result.Failure -> {
                    _uiState.value = UiState.Error("Failed to add client: ${result.exceptionOrNull()?.message}")
                }
            }
        }
    }
    
    fun updateClient(client: Client) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when (val result = clientRepository.updateClient(client)) {
                is Result.Success -> {
                    loadClients() // Refresh the list
                    hideEditClientDialog()
                }
                is Result.Failure -> {
                    _uiState.value = UiState.Error("Failed to update client: ${result.exceptionOrNull()?.message}")
                }
            }
        }
    }
    
    fun deleteClient(client: Client) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            when (val result = clientRepository.deleteClient(client)) {
                is Result.Success -> {
                    loadClients() // Refresh the list
                }
                is Result.Failure -> {
                    _uiState.value = UiState.Error("Failed to delete client: ${result.exceptionOrNull()?.message}")
                }
            }
        }
    }
}
