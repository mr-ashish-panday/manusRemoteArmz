package com.remotearmz.commandcenter.ui.clients

import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ClientStatus
import com.remotearmz.commandcenter.ui.clients.components.ClientForm
import com.remotearmz.commandcenter.ui.clients.components.ClientListItem
import com.remotearmz.commandcenter.ui.components.search.EnhancedSearchBar
import com.remotearmz.commandcenter.ui.components.search.FilterBottomSheet
import com.remotearmz.commandcenter.ui.components.search.FilterChip
import com.remotearmz.commandcenter.ui.components.states.EmptyState
import com.remotearmz.commandcenter.ui.components.states.ErrorState
import com.remotearmz.commandcenter.ui.components.states.LoadingState
import com.remotearmz.commandcenter.ui.theme.RemoteArmzTheme

// Removed as we're using UiState from ViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ClientsScreen(
    viewModel: ClientsViewModel = hiltViewModel(),
    onClientClick: (String) -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val isAddingClient by viewModel.isAddingClient.collectAsState()
    val editingClient by viewModel.editingClient.collectAsState()
    val statusFilter by viewModel.statusFilter.collectAsState()
    val windowSize = calculateWindowSizeClass()
    
    var showDeleteConfirmation by remember { mutableStateOf<Client?>(null) }
    var showFilterSheet by remember { mutableStateOf(false) }
    
    // Active filters for display
    val activeFilters = remember(statusFilter) {
        buildList {
            statusFilter?.let { status ->
                add("${status.name}" to { viewModel.updateStatusFilter(null) })
            }
        }
    }
    
    // Handle side effects
    LaunchedEffect(Unit) {
        viewModel.loadClients()
    }
    
    // Show error message if there's an error
    val errorMessage = when (uiState) {
        is UiState.Error -> (uiState as UiState.Error).message
        else -> null
    }
    
    // Show error message as a Snackbar if there's an error
    val snackbarHostState = remember { SnackbarHostState() }
    
    LaunchedEffect(uiState) {
        if (uiState is UiState.Error) {
            snackbarHostState.showSnackbar(
                message = errorMessage ?: "An error occurred",
                actionLabel = "Dismiss"
            )
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            EnhancedSearchBar(
                query = searchQuery,
                onQueryChange = { viewModel.updateSearchQuery(it) },
                onSearch = { viewModel.searchClients(it) },
                activeFilters = activeFilters,
                onFilterClick = { showFilterSheet = true },
                placeholder = stringResource(R.string.search_clients)
            )
        },
        floatingActionButton = {
            AnimatedVisibility(
                visible = uiState !is ClientsScreenState.Loading,
                enter = fadeIn() + slideInHorizontally { it },
                exit = fadeOut() + slideOutHorizontally { -it }
            ) {
                FloatingActionButton(
                    onClick = { viewModel.showAddClientDialog() },
                    containerColor = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.animateContentSize()
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(R.string.add_client),
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                when (val state = uiState) {
                    is UiState.Loading -> {
                        LoadingState()
                    }
                    is UiState.Success -> {
                        if (state.data.isEmpty()) {
                            if (searchQuery.isNotEmpty() || statusFilter != null) {
                                EmptyState(
                                    title = stringResource(R.string.no_results_title),
                                    message = stringResource(R.string.no_results_message),
                                    icon = {
                                        Icon(
                                            Icons.Default.SearchOff,
                                            contentDescription = null,
                                            modifier = Modifier.size(48.dp),
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                    },
                                    action = {
                                        Button(onClick = { 
                                            viewModel.updateSearchQuery("")
                                            viewModel.updateStatusFilter(null)
                                        }) {
                                            Text(stringResource(R.string.clear_filters))
                                        }
                                    }
                                )
                            } else {
                                EmptyState(
                                    title = stringResource(R.string.no_clients_title),
                                    message = stringResource(R.string.no_clients_message),
                                    icon = {
                                        Icon(
                                            Icons.Default.PersonOutline,
                                            contentDescription = null,
                                            modifier = Modifier.size(48.dp),
                                            tint = MaterialTheme.colorScheme.primary
                                        )
                                    },
                                    action = {
                                        Button(onClick = { viewModel.showAddClientDialog() }) {
                                            Text(stringResource(R.string.add_first_client))
                                        }
                                    }
                                )
                            }
                        } else {
                            AnimatedVisibility(
                                visible = state.data.isNotEmpty(),
                                enter = fadeIn() + expandVertically(),
                                exit = fadeOut() + shrinkVertically()
                            ) {
                                LazyColumn(
                                    contentPadding = PaddingValues(
                                        start = 16.dp,
                                        top = 8.dp,
                                        end = 16.dp,
                                        bottom = 16.dp + paddingValues.calculateBottomPadding()
                                    ),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    modifier = Modifier.fillMaxSize()
                                ) {
                                    items(
                                        items = state.data,
                                        key = { it.id },
                                        contentType = { "client" }
                                    ) { client ->
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
                                        
                                        AnimatedVisibility(
                                            visible = dismissState.currentValue != DismissValue.DismissedToStart,
                                            enter = fadeIn() + expandVertily(),
                                            exit = fadeOut() + shrinkVertically()
                                        ) {
                                            SwipeToDismiss(
                                                state = dismissState,
                                                background = {
                                                    Box(
                                                        modifier = Modifier
                                                            .fillMaxSize()
                                                            .background(MaterialTheme.colorScheme.errorContainer)
                                                            .padding(16.dp),
                                                        contentAlignment = Alignment.CenterEnd
                                                    ) {
                                                        Icon(
                                                            Icons.Default.Delete,
                                                            contentDescription = stringResource(R.string.delete),
                                                            tint = MaterialTheme.colorScheme.onErrorContainer
                                                        )
                                                    }
                                                },
                                                dismissContent = {
                                                    ClientListItem(
                                                        client = client,
                                                        onClick = { onClientClick(client.id) },
                                                        modifier = Modifier.animateItemPlacement()
                                                    )
                                                },
                                                directions = setOf(DismissDirection.EndToStart)
                                            )
                                        }
                                    }
                                    
                                    // Add extra padding at the bottom for FAB
                                    item {
                                        Spacer(modifier = Modifier.height(72.dp))
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Add/Edit Client Dialog
                if (isAddingClient) {
                    Dialog(onDismissRequest = { viewModel.hideAddClientDialog() }) {
                        Surface(
                            shape = MaterialTheme.shapes.extraLarge,
                            color = MaterialTheme.colorScheme.surface,
                            tonalElevation = 6.dp,
                            shadowElevation = 6.dp
                        ) {
                            ClientForm(
                                client = editingClient,
                                onSave = { client ->
                                    if (editingClient == null) {
                                        viewModel.addClient(client)
                                    } else {
                                        viewModel.updateClient(client)
                                    }
                                },
                                onCancel = { viewModel.hideAddClientDialog() },
                                modifier = Modifier.padding(24.dp)
                            )
                        }
                    }
                }
                
                // Delete Confirmation Dialog
                showDeleteConfirmation?.let { client ->
                    AlertDialog(
                        onDismissRequest = { showDeleteConfirmation = null },
                        title = { Text(stringResource(R.string.delete_client_title)) },
                        text = { 
                            Text(
                                stringResource(
                                    R.string.delete_client_message, 
                                    client.name
                                )
                            ) 
                        },
                        confirmButton = {
                            TextButton(
                                onClick = {
                                    viewModel.deleteClient(client)
                                    showDeleteConfirmation = null
                                }
                            ) {
                                Text(stringResource(R.string.delete))
                            }
                        },
                        dismissButton = {
                            TextButton(
                                onClick = { showDeleteConfirmation = null }
                            ) {
                                Text(stringResource(R.string.cancel))
                            }
                        }
                    )
                }
            }
        }
        
        // Filter Bottom Sheet
        FilterBottomSheet(
            isVisible = showFilterSheet,
            onDismiss = { showFilterSheet = false },
            onApply = { showFilterSheet = false },
            onClear = { 
                viewModel.updateStatusFilter(null)
                viewModel.updateSearchQuery("")
            }
        ) {
            // Status Filter Section
            Text(
                text = "Status",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                ClientStatus.values().forEach { status ->
                    FilterChip(
                        selected = statusFilter == status,
                        onClick = { 
                            viewModel.updateStatusFilter(
                                if (statusFilter == status) null else status
                            )
                        },
                        label = { Text(status.name) }
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
