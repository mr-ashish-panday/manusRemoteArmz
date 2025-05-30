package com.remotearmz.commandcenter.ui.clients

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissValue
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import com.remotearmz.commandcenter.ui.clients.components.ClientForm
import com.remotearmz.commandcenter.ui.clients.components.ClientListItem
import com.remotearmz.commandcenter.ui.theme.RemoteArmzTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientsScreen(viewModel: ClientsViewModel = hiltViewModel()) {
    val clients by viewModel.clients.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val isAddingClient by viewModel.isAddingClient.collectAsState()
    val editingClient by viewModel.editingClient.collectAsState()
    
    var showDeleteConfirmation by remember { mutableStateOf<Client?>(null) }
    
    Scaffold(
        topBar = {
            SearchBar(
                query = searchQuery,
                onQueryChange = { viewModel.updateSearchQuery(it) },
                onSearch = { viewModel.updateSearchQuery(it) },
                active = false,
                onActiveChange = { },
                placeholder = { Text("Search clients...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { viewModel.updateSearchQuery("") }) {
                            Icon(Icons.Default.Clear, contentDescription = "Clear search")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) { }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.showAddClientDialog() },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Client",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                if (clients.isEmpty() && searchQuery.isEmpty()) {
                    // Empty state
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "No clients yet",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Add your first client by clicking the + button",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                } else if (clients.isEmpty() && searchQuery.isNotEmpty()) {
                    // No search results
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "No clients found",
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Try a different search term",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                } else {
                    // Client list
                    LazyColumn(
                        contentPadding = PaddingValues(
                            start = 16.dp,
                            top = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp + paddingValues.calculateBottomPadding()
                        ),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(clients, key = { it.id }) { client ->
                            val dismissState = rememberDismissState(
                                confirmValueChange = { dismissValue ->
                                    if (dismissValue == DismissValue.DismissedToStart) {
                                        showDeleteConfirmation = client
                                        true
                                    } else {
                                        false
                                    }
                                }
                            )
                            
                            SwipeToDismiss(
                                state = dismissState,
                                background = {},
                                dismissContent = {
                                    ClientListItem(
                                        client = client,
                                        onClick = { viewModel.showEditClientDialog(client) },
                                        modifier = Modifier.padding(vertical = 8.dp)
                                    )
                                },
                                directions = setOf(DismissDirection.EndToStart)
                            )
                            
                            if (clients.indexOf(client) < clients.size - 1) {
                                Divider(modifier = Modifier.padding(vertical = 8.dp))
                            }
                        }
                    }
                }
                
                // Add/Edit Client Dialog
                if (isAddingClient) {
                    Dialog(onDismissRequest = { viewModel.hideAddClientDialog() }) {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.surface
                        ) {
                            ClientForm(
                                onSave = { viewModel.addClient(it) },
                                onCancel = { viewModel.hideAddClientDialog() }
                            )
                        }
                    }
                }
                
                editingClient?.let { client ->
                    Dialog(onDismissRequest = { viewModel.hideEditClientDialog() }) {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            color = MaterialTheme.colorScheme.surface
                        ) {
                            ClientForm(
                                client = client,
                                onSave = { viewModel.updateClient(it) },
                                onCancel = { viewModel.hideEditClientDialog() }
                            )
                        }
                    }
                }
                
                // Delete Confirmation Dialog
                showDeleteConfirmation?.let { client ->
                    AlertDialog(
                        onDismissRequest = { showDeleteConfirmation = null },
                        title = { Text("Delete Client") },
                        text = { Text("Are you sure you want to delete ${client.name}? This action cannot be undone.") },
                        confirmButton = {
                            androidx.compose.material3.TextButton(
                                onClick = {
                                    viewModel.deleteClient(client)
                                    showDeleteConfirmation = null
                                }
                            ) {
                                Text("Delete")
                            }
                        },
                        dismissButton = {
                            androidx.compose.material3.TextButton(
                                onClick = { showDeleteConfirmation = null }
                            ) {
                                Text("Cancel")
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClientsScreenPreview() {
    RemoteArmzTheme {
        val previewClients = listOf(
            Client(
                name = "John Doe",
                company = "ABC Corp",
                phone = "+1 123-456-7890",
                email = "john@example.com",
                contractValueUSD = 5000.0,
                status = ClientStatus.ACTIVE
            ),
            Client(
                name = "Jane Smith",
                company = "XYZ Ltd",
                phone = "+1 987-654-3210",
                email = "jane@example.com",
                contractValueUSD = 7500.0,
                status = ClientStatus.PROSPECT
            )
        )
        
        // Mock ViewModel for preview
        val viewModel = ClientsViewModel(FakeClientRepository())
        ClientsScreen(viewModel)
    }
}

// Fake repository for preview
class FakeClientRepository : com.remotearmz.commandcenter.data.repository.ClientRepository(
    object : com.remotearmz.commandcenter.data.dao.ClientDao {
        override suspend fun insertClient(client: Client): Long = 0
        override suspend fun updateClient(client: Client) {}
        override suspend fun deleteClient(client: Client) {}
        override fun getAllClients() = kotlinx.coroutines.flow.flowOf<List<Client>>(emptyList())
        override suspend fun getClientById(clientId: String): Client? = null
        override fun searchClients(query: String) = kotlinx.coroutines.flow.flowOf<List<Client>>(emptyList())
        override fun getClientsByStatus(status: ClientStatus) = kotlinx.coroutines.flow.flowOf<List<Client>>(emptyList())
    }
)
