package com.remotearmz.commandcenter.ui.targets

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
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
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
import com.remotearmz.commandcenter.data.model.Priority
import com.remotearmz.commandcenter.data.model.Target
import com.remotearmz.commandcenter.data.model.TargetCategory
import com.remotearmz.commandcenter.ui.components.KpiCard
import com.remotearmz.commandcenter.ui.theme.getPriorityColor
import com.remotearmz.commandcenter.util.DateFormatter
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TargetScreen(
    viewModel: TargetViewModel = hiltViewModel()
) {
    val targets by viewModel.targets.collectAsState()
    val targetStats by viewModel.targetStats.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    
    var showAddEditDialog by remember { mutableStateOf(false) }
    var currentTarget by remember { mutableStateOf<Target?>(null) }
    var showFilterMenu by remember { mutableStateOf(false) }
    var searchQuery by remember { mutableStateOf("") }
    
    // Handle UI state changes
    LaunchedEffect(uiState) {
        if (uiState.isTargetSaved) {
            snackbarHostState.showSnackbar("Target saved successfully")
            viewModel.resetSaveState()
            showAddEditDialog = false
        }
        
        if (uiState.isTargetDeleted) {
            snackbarHostState.showSnackbar("Target deleted successfully")
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
                    currentTarget = null
                    showAddEditDialog = true
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Target")
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
            TargetStatsSection(targetStats, viewModel.getRemainingDaysCounter())
            
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
                    placeholder = { Text("Search targets...") },
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
                        // Category filters
                        Text(
                            "Categories",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        
                        DropdownMenuItem(
                            text = { Text("All Categories") },
                            onClick = {
                                viewModel.updateCategoryFilter(null)
                                showFilterMenu = false
                            }
                        )
                        
                        TargetCategory.values().forEach { category ->
                            DropdownMenuItem(
                                text = { Text(category.name) },
                                onClick = {
                                    viewModel.updateCategoryFilter(category)
                                    showFilterMenu = false
                                }
                            )
                        }
                        
                        // Completion status filters
                        Text(
                            "Status",
                            style = MaterialTheme.typography.labelMedium,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        )
                        
                        DropdownMenuItem(
                            text = { Text("All Targets") },
                            onClick = {
                                viewModel.updateCompletedFilter(null)
                                showFilterMenu = false
                            }
                        )
                        
                        DropdownMenuItem(
                            text = { Text("Completed") },
                            onClick = {
                                viewModel.updateCompletedFilter(true)
                                showFilterMenu = false
                            }
                        )
                        
                        DropdownMenuItem(
                            text = { Text("In Progress") },
                            onClick = {
                                viewModel.updateCompletedFilter(false)
                                showFilterMenu = false
                            }
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Target List
            if (uiState.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else if (targets.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text("No targets found", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = {
                                currentTarget = null
                                showAddEditDialog = true
                            }
                        ) {
                            Text("Add your first target")
                        }
                    }
                }
            } else {
                LazyColumn {
                    items(targets) { target ->
                        TargetItem(
                            target = target,
                            onEdit = {
                                currentTarget = target
                                showAddEditDialog = true
                            },
                            onDelete = {
                                scope.launch {
                                    val result = snackbarHostState.showSnackbar(
                                        message = "Delete ${target.title}?",
                                        actionLabel = "Delete"
                                    )
                                    if (result == androidx.compose.material3.SnackbarResult.ActionPerformed) {
                                        viewModel.deleteTarget(target)
                                    }
                                }
                            },
                            onProgressUpdate = { newValue ->
                                viewModel.updateTargetProgress(target.id, newValue)
                            }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
    
    // Add/Edit Target Dialog
    if (showAddEditDialog) {
        TargetFormDialog(
            target = currentTarget,
            onDismiss = { showAddEditDialog = false },
            onSave = { target ->
                viewModel.saveTarget(target)
            }
        )
    }
}

@Composable
fun TargetStatsSection(stats: TargetStats, remainingDays: Int) {
    Column {
        Text(
            "Target Statistics",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Overall Progress",
                value = "${String.format("%.1f", stats.overallProgress)}%",
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Completion Rate",
                value = "${String.format("%.1f", stats.completionRate)}%",
                subtitle = "${stats.completedCount}/${stats.totalCount}",
                modifier = Modifier.weight(1f)
            )
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            KpiCard(
                title = "Days Remaining",
                value = remainingDays.toString(),
                subtitle = "Until May 30, 2026",
                modifier = Modifier.weight(1f)
            )
            KpiCard(
                title = "Target Categories",
                value = "${stats.revenueTargetCount}/${stats.clientTargetCount}/${stats.leadTargetCount}",
                subtitle = "Revenue/Clients/Leads",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TargetItem(
    target: Target,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onProgressUpdate: (Double) -> Unit
) {
    var showProgressDialog by remember { mutableStateOf(false) }
    
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
                        text = target.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = target.category.name,
                        style = MaterialTheme.typography.bodyMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(getPriorityColor(target.priority.name))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = target.priority.name,
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Progress bar
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Progress: ${String.format("%.1f", target.progressPercentage)}%",
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        "${target.currentValue.toInt()}/${target.targetValue.toInt()}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                
                Spacer(modifier = Modifier.height(4.dp))
                
                LinearProgressIndicator(
                    progress = target.progressPercentage / 100f,
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(4.dp))
                
                Button(
                    onClick = { showProgressDialog = true },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text("Update Progress")
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        "Deadline: ${DateFormatter.formatDate(target.deadline)}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        "${target.remainingDays} days remaining",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                
                Row {
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
    
    // Progress Update Dialog
    if (showProgressDialog) {
        Dialog(onDismissRequest = { showProgressDialog = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Update Progress for ${target.title}",
                        style = MaterialTheme.typography.titleMedium
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    var progressValue by remember { mutableFloatStateOf(target.currentValue.toFloat()) }
                    
                    Text(
                        "Current Value: ${progressValue.toInt()} / ${target.targetValue.toInt()}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Slider(
                        value = progressValue,
                        onValueChange = { progressValue = it },
                        valueRange = 0f..target.targetValue.toFloat(),
                        steps = 100
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { showProgressDialog = false }) {
                            Text("Cancel")
                        }
                        
                        Button(
                            onClick = {
                                onProgressUpdate(progressValue.toDouble())
                                showProgressDialog = false
                            }
                        ) {
                            Text("Save")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TargetFormDialog(
    target: Target?,
    onDismiss: () -> Unit,
    onSave: (Target) -> Unit
) {
    val isNewTarget = target == null
    var title by remember { mutableStateOf(target?.title ?: "") }
    var description by remember { mutableStateOf(target?.description ?: "") }
    var targetValue by remember { mutableStateOf(target?.targetValue?.toString() ?: "0") }
    var currentValue by remember { mutableStateOf(target?.currentValue?.toString() ?: "0") }
    var category by remember { mutableStateOf(target?.category ?: TargetCategory.REVENUE) }
    var priority by remember { mutableStateOf(target?.priority ?: Priority.MEDIUM) }
    
    // Date picker state
    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = target?.deadline ?: (System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000) // Default: 30 days from now
    )
    var showDatePicker by remember { mutableStateOf(false) }
    
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (isNewTarget) "Add New Target" else "Edit Target",
                    style = MaterialTheme.typography.titleLarge
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                OutlinedTextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = targetValue,
                        onValueChange = { targetValue = it },
                        label = { Text("Target Value") },
                        modifier = Modifier.weight(1f)
                    )
                    
                    Spacer(modifier = Modifier.size(8.dp))
                    
                    OutlinedTextField(
                        value = currentValue,
                        onValueChange = { currentValue = it },
                        label = { Text("Current Value") },
                        modifier = Modifier.weight(1f)
                    )
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Category dropdown
                var showCategoryDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = category.name,
                        onValueChange = { },
                        label = { Text("Category") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select category",
                                modifier = Modifier.clickable { showCategoryDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showCategoryDropdown,
                        onDismissRequest = { showCategoryDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        TargetCategory.values().forEach { targetCategory ->
                            DropdownMenuItem(
                                text = { Text(targetCategory.name) },
                                onClick = {
                                    category = targetCategory
                                    showCategoryDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Priority dropdown
                var showPriorityDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = priority.name,
                        onValueChange = { },
                        label = { Text("Priority") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select priority",
                                modifier = Modifier.clickable { showPriorityDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showPriorityDropdown,
                        onDismissRequest = { showPriorityDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        Priority.values().forEach { priorityValue ->
                            DropdownMenuItem(
                                text = { Text(priorityValue.name) },
                                onClick = {
                                    priority = priorityValue
                                    showPriorityDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Deadline field
                OutlinedTextField(
                    value = datePickerState.selectedDateMillis?.let { DateFormatter.formatDate(it) } ?: "",
                    onValueChange = { },
                    label = { Text("Deadline") },
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Select date",
                            modifier = Modifier.clickable { showDatePicker = true }
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                
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
                            val newTarget = Target(
                                id = target?.id ?: UUID.randomUUID().toString(),
                                title = title,
                                description = description,
                                targetValue = targetValue.toDoubleOrNull() ?: 0.0,
                                currentValue = currentValue.toDoubleOrNull() ?: 0.0,
                                category = category,
                                priority = priority,
                                deadline = datePickerState.selectedDateMillis ?: (System.currentTimeMillis() + 30L * 24 * 60 * 60 * 1000),
                                isCompleted = target?.isCompleted ?: false,
                                createdAt = target?.createdAt ?: System.currentTimeMillis()
                            )
                            onSave(newTarget)
                        },
                        enabled = title.isNotBlank() && targetValue.toDoubleOrNull() != null
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
    
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                Button(onClick = { showDatePicker = false }) {
                    Text("OK")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
