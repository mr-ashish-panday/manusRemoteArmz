package com.remotearmz.commandcenter.ui.leads

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.LeadStatus
import com.remotearmz.commandcenter.ui.components.KpiCard
import com.remotearmz.commandcenter.ui.theme.getStatusColor
import com.remotearmz.commandcenter.util.CurrencyFormatter
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
    var searchQuery by remember { mutableStateOf("") }
    
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
                .padding(16.dp)
        ) {
            // Stats Cards
            LeadStatsSection(leadStats)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Search and Filter
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { 
                        searchQuery = it
                        viewModel.updateSearchQuery(it)
                    },
                    placeholder = { Text("Search leads...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                    trailingIcon = {
                        if (searchQuery.isNotEmpty()) {
                            IconButton(onClick = { 
                                searchQuery = ""
                                viewModel.updateSearchQuery("") 
                            }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear search")
                            }
                        }
                    },
                    modifier = Modifier.weight(1f)
                )
                
                Box {
                    IconButton(onClick = { showFilterMenu = true }) {
                        Icon(Icons.Default.FilterList, contentDescription = "Filter")
                    }
                    
                    DropdownMenu(
                        expanded = showFilterMenu,
                        onDismissRequest = { showFilterMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("All Leads") },
                            onClick = {
                                viewModel.updateStatusFilter(null)
                                showFilterMenu = false
                            }
                        )
                        LeadStatus.values().forEach { status ->
                            DropdownMenuItem(
                                text = { Text(status.name) },
                                onClick = {
                                    viewModel.updateStatusFilter(status)
                                    showFilterMenu = false
                                }
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Lead List
            if (uiState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (leads.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("No leads found", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                currentLead = null
                                showAddEditDialog = true
                            }
                        ) {
                            Text("Add your first lead")
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(leads) { lead ->
                        LeadItem(
                            lead = lead,
                            onEdit = {
                                currentLead = lead
                                showAddEditDialog = true
                            },
                            onDelete = {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Delete ${lead.contactName}?",
                                        actionLabel = "Delete"
                                    )
                                    if (result == androidx.compose.material3.SnackbarResult.ActionPerformed) {
                                        viewModel.deleteLead(lead)
                                    }
                                }
                            },
                            onStatusChange = { newStatus ->
                                viewModel.updateLeadStatus(lead, newStatus)
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
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

@Composable
fun LeadStatsSection(stats: LeadStats) {
    Column {
        Text(
            "Lead Statistics",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Total Leads",
                value = stats.totalCount.toString(),
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Active Leads",
                value = stats.activeCount.toString(),
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Conversion Rate",
                value = "${String.format("%.1f", stats.conversionRate)}%",
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Potential Value",
                value = CurrencyFormatter.formatUSD(stats.weightedValueUSD),
                subtitle = "(Weighted)",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun LeadItem(
    lead: Lead,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onStatusChange: (LeadStatus) -> Unit
) {
    var showStatusMenu by remember { mutableStateOf(false) }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEdit() },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = lead.contactName,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = lead.company,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(getStatusColor(lead.status.name))
                        .clickable { showStatusMenu = true }
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = lead.status.name,
                            color = Color.White,
                            style = MaterialTheme.typography.bodySmall
                        )
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Change status",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    
                    DropdownMenu(
                        expanded = showStatusMenu,
                        onDismissRequest = { showStatusMenu = false }
                    ) {
                        LeadStatus.values().forEach { status ->
                            DropdownMenuItem(
                                text = { Text(status.name) },
                                onClick = {
                                    onStatusChange(status)
                                    showStatusMenu = false
                                },
                                leadingIcon = {
                                    if (status == lead.status) {
                                        Icon(Icons.Default.Check, contentDescription = null)
                                    }
                                }
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        "Value: ${CurrencyFormatter.formatUSD(lead.valueUSD)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "Probability: ${lead.probability}%",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                
                Column(horizontalAlignment = Alignment.End) {
                    lead.expectedCloseDate?.let { closeDate ->
                        Text(
                            "Expected Close: ${DateFormatter.formatDate(closeDate)}",
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                    Text(
                        "Source: ${lead.source.ifEmpty { "Not specified" }}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onEdit) {
                    Icon(Icons.Default.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete")
                }
            }
        }
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
    
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (isNewLead) "Add New Lead" else "Edit Lead",
                    style = MaterialTheme.typography.titleLarge
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = contactName,
                    onValueChange = { contactName = it },
                    label = { Text("Contact Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = company,
                    onValueChange = { company = it },
                    label = { Text("Company") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = valueUSD,
                        onValueChange = { valueUSD = it },
                        label = { Text("Value (USD)") },
                        modifier = Modifier.weight(1f)
                    )
                    
                    Spacer(modifier = Modifier.size(8.dp))
                    
                    OutlinedTextField(
                        value = probability,
                        onValueChange = { probability = it },
                        label = { Text("Probability (%)") },
                        modifier = Modifier.weight(1f)
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = source,
                    onValueChange = { source = it },
                    label = { Text("Source") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Status dropdown
                var showStatusDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = status.name,
                        onValueChange = { },
                        label = { Text("Status") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select status",
                                modifier = Modifier.clickable { showStatusDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showStatusDropdown,
                        onDismissRequest = { showStatusDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        LeadStatus.values().forEach { leadStatus ->
                            DropdownMenuItem(
                                text = { Text(leadStatus.name) },
                                onClick = {
                                    status = leadStatus
                                    showStatusDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    
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
                        enabled = contactName.isNotBlank() && company.isNotBlank()
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
}
