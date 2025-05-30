package com.remotearmz.commandcenter.ui.clients

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import com.remotearmz.commandcenter.data.repository.ClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

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
    
    val clients = combine(
        clientRepository.getAllClients(),
        _searchQuery,
        _statusFilter
    ) { clients, query, statusFilter ->
        var filteredClients = clients
        
        if (query.isNotBlank()) {
            filteredClients = filteredClients.filter { client ->
                client.name.contains(query, ignoreCase = true) ||
                client.company.contains(query, ignoreCase = true)
            }
        }
        
        if (statusFilter != null) {
            filteredClients = filteredClients.filter { it.status == statusFilter }
        }
        
        filteredClients
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )
    
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }
    
    fun updateStatusFilter(status: ClientStatus?) {
        _statusFilter.value = status
    }
    
    fun showAddClientDialog() {
        _isAddingClient.value = true
    }
    
    fun hideAddClientDialog() {
        _isAddingClient.value = false
    }
    
    fun showEditClientDialog(client: Client) {
        _editingClient.value = client
    }
    
    fun hideEditClientDialog() {
        _editingClient.value = null
    }
    
    fun addClient(client: Client) {
        viewModelScope.launch {
            clientRepository.insertClient(client)
            hideAddClientDialog()
        }
    }
    
    fun updateClient(client: Client) {
        viewModelScope.launch {
            clientRepository.updateClient(client)
            hideEditClientDialog()
        }
    }
    
    fun deleteClient(client: Client) {
        viewModelScope.launch {
            clientRepository.deleteClient(client)
        }
    }
}
