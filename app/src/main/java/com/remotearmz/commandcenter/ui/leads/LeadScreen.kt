package com.remotearmz.commandcenter.ui.leads

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.ui.components.FormDialog
import com.remotearmz.commandcenter.ui.components.KpiCard
import com.remotearmz.commandcenter.ui.components.search.EnhancedSearchBar
import com.remotearmz.commandcenter.ui.components.states.EmptyState
import com.remotearmz.commandcenter.ui.components.states.ErrorState
import com.remotearmz.commandcenter.ui.components.states.LoadingState
import com.remotearmz.commandcenter.ui.theme.getStatusColor
import com.remotearmz.commandcenter.util.CurrencyConverter
import com.remotearmz.commandcenter.util.DateFormatter
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeadScreen(
    viewModel: LeadViewModel = hiltViewModel()
) {
    val leads by viewModel.leads.collectAsState()
    val leadStats by viewModel.leadStats.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    
    var showAddEditDialog by remember { mutableStateOf(false) }
    var currentLead by remember { mutableStateOf<Lead?>(null) }
    var showFilterMenu by remember { mutableStateOf(false) }
    var showFilterSheet by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    val statusFilter by viewModel.statusFilter.collectAsState()
    
    // Calculate active filters
    val activeFilters = remember(statusFilter, viewModel.searchQuery.value) {
        mutableListOf<Pair<String, () -> Unit>>().apply {
            if (statusFilter != null) {
                add(Pair("Status: ${statusFilter.name}") { viewModel.updateStatusFilter(null) })
            }
            if (viewModel.searchQuery.value.isNotEmpty()) {
                add(Pair("Search: ${viewModel.searchQuery.value}") { viewModel.updateSearchQuery("") })
            }
        }
    }
    
    // Handle UI state changes
    LaunchedEffect(uiState) {
        if (uiState.isLeadSaved) {
            snackbarHostState.showSnackbar("Lead saved successfully")
            viewModel.resetSaveState()
            showAddEditDialog = false
        }
        
        if (uiState.isLeadDeleted) {
            snackbarHostState.showSnackbar("Lead deleted successfully")
            viewModel.resetSaveState()
        }
        
        if (uiState.error != null) {
            snackbarHostState.showSnackbar("Error: ${uiState.error}")
            viewModel.clearError()
        }
    }
    
    val sheetState = rememberModalBottomSheetState()
    
    if (showFilterSheet) {
        ModalBottomSheet(
            onDismissRequest = { showFilterSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.filter),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    TextButton(onClick = { 
                        viewModel.updateStatusFilter(null)
                    }) {
                        Text(stringResource(R.string.reset_filters))
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Text(
                    text = stringResource(R.string.status),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                
                // Status Filter Chips
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    FilterChip(
                        selected = statusFilter == null,
                        onClick = { viewModel.updateStatusFilter(null) },
                        label = { Text("All") },
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    
                    LeadStatus.values().forEach { status ->
                        FilterChip(
                            selected = statusFilter == status,
                            onClick = { 
                                viewModel.updateStatusFilter(
                                    if (statusFilter == status) null else status
                                )
                            },
                            label = { Text(status.name) },
                            modifier = Modifier.padding(end = 4.dp)
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = { showFilterSheet = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(stringResource(R.string.apply_filters))
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
    
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    currentLead = null
                    showAddEditDialog = true
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Lead")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // Stats Cards
            LeadStatsSection(leadStats)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Search and Filter
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                EnhancedSearchBar(
                    query = viewModel.searchQuery.value,
                    onQueryChange = { viewModel.updateSearchQuery(it) },
                    onSearch = { viewModel.updateSearchQuery(it) },
                    activeFilters = activeFilters,
                    onFilterClick = { showFilterSheet = true },
                    placeholder = stringResource(R.string.search_leads)
                )
                
                // Active filters row
                if (activeFilters.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Active filters:",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        
                        activeFilters.forEach { (filter, onRemove) ->
                            FilterChip(
                                selected = true,
                                onClick = { onRemove() },
                                label = { Text(filter) },
                                trailingIcon = {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "Remove filter",
                                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                                    )
                                },
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                                    selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    selectedLeadingIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                                    selectedTrailingIconColor = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                        }
                        
                        if (activeFilters.size > 1) {
                            TextButton(
                                onClick = { viewModel.updateStatusFilter(null) },
                                modifier = Modifier.padding(start = 4.dp)
                            ) {
                                Text("Clear all")
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            when {
                uiState.isLoading -> {
                    LoadingState()
                }
                leads.isEmpty() -> {
                    EmptyState(
                        title = if (viewModel.searchQuery.value.isNotEmpty() || statusFilter != null) {
                            stringResource(R.string.no_results_title)
                        } else {
                            stringResource(R.string.no_leads_title)
                        },
                        message = if (viewModel.searchQuery.value.isNotEmpty() || statusFilter != null) {
                            stringResource(R.string.no_results_message)
                        } else {
                            stringResource(R.string.no_leads_message)
                        },
                        icon = {
                            Icon(
                                if (viewModel.searchQuery.value.isNotEmpty() || statusFilter != null) 
                                    Icons.Default.SearchOff 
                                else 
                                    Icons.Default.PersonOutline,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        },
                        action = {
                            if (viewModel.searchQuery.value.isNotEmpty() || statusFilter != null) {
                                Button(
                                    onClick = {
                                        viewModel.updateSearchQuery("")
                                        viewModel.updateStatusFilter(null)
                                    }
                                ) {
                                    Text(stringResource(R.string.clear_filters))
                                }
                            } else {
                                Button(
                                    onClick = {
                                        currentLead = null
                                        showAddEditDialog = true
                                    }
                                ) {
                                    Text(stringResource(R.string.add_first_lead))
                                }
                            }
                        }
                    )
                }
                else -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
                    ) {
                        items(leads) { lead ->
                            LeadItem(
                                lead = lead,
                                onEdit = {
                                    currentLead = lead
                                    showAddEditDialog = true
                                },
                                onDelete = {
                                    viewModel.deleteLead(lead.id)
                                },
                                onStatusChange = { newStatus ->
                                    viewModel.updateLeadStatus(lead.id, newStatus)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
    
    // Add/Edit Lead Dialog
    if (showAddEditDialog) {
        LeadFormDialog(
            lead = currentLead,
            onDismiss = { showAddEditDialog = false },
            onSave = { lead ->
                viewModel.saveLead(lead)
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeadFormDialog(
    lead: Lead?,
    onDismiss: () -> Unit,
    onSave: (Lead) -> Unit
) {
    val isNewLead = lead == null
    var contactName by remember { mutableStateOf(lead?.contactName ?: "") }
    var company by remember { mutableStateOf(lead?.company ?: "") }
    var phone by remember { mutableStateOf(lead?.phone ?: "") }
    var email by remember { mutableStateOf(lead?.email ?: "") }
    var valueUSD by remember { mutableStateOf(lead?.valueUSD?.toString() ?: "0.0") }
    var probability by remember { mutableStateOf(lead?.probability?.toString() ?: "0") }
    var source by remember { mutableStateOf(lead?.source ?: "") }
    var status by remember { mutableStateOf(lead?.status ?: LeadStatus.NEW) }
    var expectedCloseDateMillis by remember { mutableStateOf(lead?.expectedCloseDate) }
    
    // Status dropdown state
    var showStatusDropdown by remember { mutableStateOf(false) }
    
    // Form validation
    val isFormValid = contactName.isNotBlank() && company.isNotBlank()
    
    // Use our custom FormDialog component
    FormDialog(
        title = if (isNewLead) "Add New Lead" else "Edit Lead",
        onDismiss = onDismiss,
        confirmButton = {
            Button(
                onClick = {
                    val newLead = Lead(
                        id = lead?.id ?: UUID.randomUUID().toString(),
                        contactName = contactName,
                        company = company,
                        phone = phone,
                        email = email,
                        valueUSD = valueUSD.toDoubleOrNull() ?: 0.0,
                        probability = probability.toIntOrNull()?.coerceIn(0, 100) ?: 0,
                        source = source,
                        status = status,
                        expectedCloseDate = expectedCloseDateMillis,
                        clientId = lead?.clientId,
                        createdAt = lead?.createdAt ?: System.currentTimeMillis(),
                        updatedAt = System.currentTimeMillis()
                    )
                    onSave(newLead)
                },
                enabled = isFormValid,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                )
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(
                onClick = onDismiss,
                colors = ButtonDefaults.textButtonColors(
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            ) {
                Text("Cancel")
            }
        }
    ) {
        // Form fields
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 8.dp)
                .heightIn(max = 500.dp)
        ) {
            // Contact Name
            OutlinedTextField(
                value = contactName,
                onValueChange = { contactName = it },
                label = { Text("Contact Name *") },
                isError = contactName.isBlank(),
                supportingText = {
                    if (contactName.isBlank()) {
                        Text("Required field")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Company
            OutlinedTextField(
                value = company,
                onValueChange = { company = it },
                label = { Text("Company *") },
                isError = company.isBlank(),
                supportingText = {
                    if (company.isBlank()) {
                        Text("Required field")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Phone
            OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                label = { Text("Phone") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
        }
    }
}
