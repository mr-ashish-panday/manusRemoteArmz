package com.remotearmz.commandcenter.ui.outreach

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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
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
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import com.remotearmz.commandcenter.ui.components.KpiCard
import com.remotearmz.commandcenter.ui.theme.getOutcomeColor
import com.remotearmz.commandcenter.util.DateFormatter
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutreachScreen(
    viewModel: OutreachViewModel = hiltViewModel()
) {
    val outreachActivities by viewModel.outreachActivities.collectAsState()
    val outreachStats by viewModel.outreachStats.collectAsState()
    val followUps by viewModel.followUps.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val clients by viewModel.clients.collectAsState()
    val leads by viewModel.leads.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    
    var showAddEditDialog by remember { mutableStateOf(false) }
    var currentActivity by remember { mutableStateOf<OutreachActivity?>(null) }
    var showFilterMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    var showFollowUpList by remember { mutableStateOf(false) }
    
    // Handle UI state changes
    LaunchedEffect(uiState) {
        if (uiState.isActivitySaved) {
            snackbarHostState.showSnackbar("Outreach activity saved successfully")
            viewModel.resetSaveState()
            showAddEditDialog = false
        }
        
        if (uiState.isActivityDeleted) {
            snackbarHostState.showSnackbar("Outreach activity deleted successfully")
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
                    currentActivity = null
                    showAddEditDialog = true
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Outreach Activity")
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
            OutreachStatsSection(outreachStats)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Follow-up notification
            if (followUps.isNotEmpty()) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showFollowUpList = !showFollowUpList },
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        BadgedBox(
                            badge = {
                                Badge { Text(followUps.size.toString()) }
                            }
                        ) {
                            Icon(
                                Icons.Default.Notifications,
                                contentDescription = "Follow-ups",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                        
                        Spacer(modifier = Modifier.size(16.dp))
                        
                        Text(
                            text = "${followUps.size} follow-ups require your attention",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onErrorContainer
                        )
                    }
                }
                
                if (showFollowUpList) {
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ) {
                        items(followUps) { followUp ->
                            FollowUpItem(
                                followUp = followUp,
                                clients = clients,
                                leads = leads,
                                onMarkComplete = {
                                    viewModel.markFollowUpComplete(followUp)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }
            
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
                    placeholder = { Text("Search activities...") },
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
                        // Type filters
                        Text(
                            "Activity Type",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        
                        DropdownMenuItem(
                            text = { Text("All Types") },
                            onClick = {
                                viewModel.updateTypeFilter(null)
                                showFilterMenu = false
                            }
                        )
                        
                        OutreachType.values().forEach { type ->
                            DropdownMenuItem(
                                text = { Text(type.name) },
                                onClick = {
                                    viewModel.updateTypeFilter(type)
                                    showFilterMenu = false
                                }
                            )
                        }
                        
                        // Outcome filters
                        Text(
                            "Outcome",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        
                        DropdownMenuItem(
                            text = { Text("All Outcomes") },
                            onClick = {
                                viewModel.updateOutcomeFilter(null)
                                showFilterMenu = false
                            }
                        )
                        
                        OutreachOutcome.values().forEach { outcome ->
                            DropdownMenuItem(
                                text = { Text(outcome.name) },
                                onClick = {
                                    viewModel.updateOutcomeFilter(outcome)
                                    showFilterMenu = false
                                }
                            )
                        }
                        
                        // Contact type filters
                        Text(
                            "Contact Type",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        
                        DropdownMenuItem(
                            text = { Text("All Contacts") },
                            onClick = {
                                viewModel.updateContactTypeFilter(null)
                                showFilterMenu = false
                            }
                        )
                        
                        ContactType.values().forEach { contactType ->
                            DropdownMenuItem(
                                text = { Text(contactType.name) },
                                onClick = {
                                    viewModel.updateContactTypeFilter(contactType)
                                    showFilterMenu = false
                                }
                            )
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Outreach Activity List
            if (uiState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (outreachActivities.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("No outreach activities found", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                currentActivity = null
                                showAddEditDialog = true
                            }
                        ) {
                            Text("Add your first outreach activity")
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(outreachActivities) { activity ->
                        OutreachActivityItem(
                            activity = activity,
                            clients = clients,
                            leads = leads,
                            onEdit = {
                                currentActivity = activity
                                showAddEditDialog = true
                            },
                            onDelete = {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Delete this activity?",
                                        actionLabel = "Delete"
                                    )
                                    if (result == androidx.compose.material3.SnackbarResult.ActionPerformed) {
                                        viewModel.deleteOutreachActivity(activity)
                                    }
                                }
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
    
    // Add/Edit Outreach Activity Dialog
    if (showAddEditDialog) {
        OutreachActivityFormDialog(
            activity = currentActivity,
            clients = clients,
            leads = leads,
            onDismiss = { showAddEditDialog = false },
            onSave = { activity ->
                viewModel.saveOutreachActivity(activity)
            }
        )
    }
}

@Composable
fun OutreachStatsSection(stats: OutreachStats) {
    Column {
        Text(
            "Outreach Statistics",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Total Activities",
                value = stats.totalCount.toString(),
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Success Rate",
                value = "${String.format("%.1f", stats.successRate)}%",
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Calls/Emails/Meetings",
                value = "${stats.callCount}/${stats.emailCount}/${stats.meetingCount}",
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Successful",
                value = stats.successfulCount.toString(),
                subtitle = "of ${stats.totalCount} activities",
                modifier = Modifier.weight(1f)
            )
        }
    }
}
