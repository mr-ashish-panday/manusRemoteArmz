package com.remotearmz.commandcenter.ui.outreach

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.remotearmz.commandcenter.data.model.Client
import com.remotearmz.commandcenter.data.model.ContactType
import com.remotearmz.commandcenter.data.model.Lead
import com.remotearmz.commandcenter.data.model.OutreachActivity
import com.remotearmz.commandcenter.data.model.OutreachOutcome
import com.remotearmz.commandcenter.data.model.OutreachType
import com.remotearmz.commandcenter.ui.theme.getOutcomeColor
import com.remotearmz.commandcenter.util.DateFormatter
import java.util.UUID

@Composable
fun OutreachActivityItem(
    activity: OutreachActivity,
    clients: List<Client>,
    leads: List<Lead>,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    val contactName = when (activity.contactType) {
        ContactType.CLIENT -> clients.find { it.id == activity.contactId }?.name ?: "Unknown Client"
        ContactType.LEAD -> leads.find { it.id == activity.contactId }?.contactName ?: "Unknown Lead"
    }
    
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
                        text = "${activity.type.name} with $contactName",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = DateFormatter.formatDateTime(activity.createdAt),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .background(getOutcomeColor(activity.outcome.name))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = activity.outcome.name,
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            if (activity.notes.isNotBlank()) {
                Text(
                    text = activity.notes,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                
                Spacer(modifier = Modifier.height(8.dp))
            }
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (activity.followUpRequired) {
                    Text(
                        text = "Follow-up: ${activity.followUpDate?.let { DateFormatter.formatDate(it) } ?: "Required"}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                } else {
                    Text(
                        text = "Duration: ${activity.duration} minutes",
                        style = MaterialTheme.typography.bodySmall
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
}

@Composable
fun FollowUpItem(
    followUp: OutreachActivity,
    clients: List<Client>,
    leads: List<Lead>,
    onMarkComplete: () -> Unit
) {
    val contactName = when (followUp.contactType) {
        ContactType.CLIENT -> clients.find { it.id == followUp.contactId }?.name ?: "Unknown Client"
        ContactType.LEAD -> leads.find { it.id == followUp.contactId }?.contactName ?: "Unknown Lead"
    }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.3f)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "${followUp.type.name} with $contactName",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                
                followUp.followUpDate?.let { followUpDate ->
                    Text(
                        text = "Due: ${DateFormatter.formatDate(followUpDate)}",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                
                if (followUp.notes.isNotBlank()) {
                    Text(
                        text = followUp.notes,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            
            Button(onClick = onMarkComplete) {
                Text("Complete")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutreachActivityFormDialog(
    activity: OutreachActivity?,
    clients: List<Client>,
    leads: List<Lead>,
    onDismiss: () -> Unit,
    onSave: (OutreachActivity) -> Unit
) {
    val isNewActivity = activity == null
    var type by remember { mutableStateOf(activity?.type ?: OutreachType.CALL) }
    var contactType by remember { mutableStateOf(activity?.contactType ?: ContactType.CLIENT) }
    var contactId by remember { mutableStateOf(activity?.contactId ?: "") }
    var outcome by remember { mutableStateOf(activity?.outcome ?: OutreachOutcome.NO_RESPONSE) }
    var notes by remember { mutableStateOf(activity?.notes ?: "") }
    var duration by remember { mutableStateOf(activity?.duration?.toString() ?: "15") }
    var followUpRequired by remember { mutableStateOf(activity?.followUpRequired ?: false) }
    
    // Date picker state for follow-up date
    val followUpDatePickerState = rememberDatePickerState(
        initialSelectedDateMillis = activity?.followUpDate ?: (System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000) // Default: 7 days from now
    )
    var showFollowUpDatePicker by remember { mutableStateOf(false) }
    
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = if (isNewActivity) "Add New Outreach Activity" else "Edit Outreach Activity",
                    style = MaterialTheme.typography.titleLarge
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Type dropdown
                var showTypeDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = type.name,
                        onValueChange = { },
                        label = { Text("Activity Type") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select type",
                                modifier = Modifier.clickable { showTypeDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showTypeDropdown,
                        onDismissRequest = { showTypeDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        OutreachType.values().forEach { outreachType ->
                            DropdownMenuItem(
                                text = { Text(outreachType.name) },
                                onClick = {
                                    type = outreachType
                                    showTypeDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Contact type dropdown
                var showContactTypeDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = contactType.name,
                        onValueChange = { },
                        label = { Text("Contact Type") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select contact type",
                                modifier = Modifier.clickable { showContactTypeDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showContactTypeDropdown,
                        onDismissRequest = { showContactTypeDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        ContactType.values().forEach { type ->
                            DropdownMenuItem(
                                text = { Text(type.name) },
                                onClick = {
                                    contactType = type
                                    contactId = "" // Reset contact ID when changing type
                                    showContactTypeDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Contact dropdown
                var showContactDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    val contactList = if (contactType == ContactType.CLIENT) clients else leads
                    val selectedContactName = when (contactType) {
                        ContactType.CLIENT -> clients.find { it.id == contactId }?.name ?: "Select Client"
                        ContactType.LEAD -> leads.find { it.id == contactId }?.contactName ?: "Select Lead"
                    }
                    
                    OutlinedTextField(
                        value = selectedContactName,
                        onValueChange = { },
                        label = { Text(if (contactType == ContactType.CLIENT) "Client" else "Lead") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select contact",
                                modifier = Modifier.clickable { showContactDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showContactDropdown,
                        onDismissRequest = { showContactDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        if (contactType == ContactType.CLIENT) {
                            clients.forEach { client ->
                                DropdownMenuItem(
                                    text = { Text(client.name) },
                                    onClick = {
                                        contactId = client.id
                                        showContactDropdown = false
                                    }
                                )
                            }
                        } else {
                            leads.forEach { lead ->
                                DropdownMenuItem(
                                    text = { Text(lead.contactName) },
                                    onClick = {
                                        contactId = lead.id
                                        showContactDropdown = false
                                    }
                                )
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Outcome dropdown
                var showOutcomeDropdown by remember { mutableStateOf(false) }
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = outcome.name,
                        onValueChange = { },
                        label = { Text("Outcome") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select outcome",
                                modifier = Modifier.clickable { showOutcomeDropdown = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                    
                    DropdownMenu(
                        expanded = showOutcomeDropdown,
                        onDismissRequest = { showOutcomeDropdown = false },
                        modifier = Modifier.fillMaxWidth(0.9f)
                    ) {
                        OutreachOutcome.values().forEach { outreachOutcome ->
                            DropdownMenuItem(
                                text = { Text(outreachOutcome.name) },
                                onClick = {
                                    outcome = outreachOutcome
                                    showOutcomeDropdown = false
                                }
                            )
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Notes
                OutlinedTextField(
                    value = notes,
                    onValueChange = { notes = it },
                    label = { Text("Notes") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(8.dp))
                
                // Duration
                OutlinedTextField(
                    value = duration,
                    onValueChange = { duration = it },
                    label = { Text("Duration (minutes)") },
                    modifier = Modifier.fillMaxWidth()
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Follow-up section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Requires Follow-up", modifier = Modifier.weight(1f))
                    Switch(
                        checked = followUpRequired,
                        onCheckedChange = { followUpRequired = it }
                    )
                }
                
                if (followUpRequired) {
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    // Follow-up date
                    OutlinedTextField(
                        value = followUpDatePickerState.selectedDateMillis?.let { DateFormatter.formatDate(it) } ?: "",
                        onValueChange = { },
                        label = { Text("Follow-up Date") },
                        readOnly = true,
                        trailingIcon = {
                            Icon(
                                Icons.Default.ArrowDropDown,
                                contentDescription = "Select date",
                                modifier = Modifier.clickable { showFollowUpDatePicker = true }
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
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
                            val newActivity = OutreachActivity(
                                id = activity?.id ?: UUID.randomUUID().toString(),
                                type = type,
                                contactId = contactId,
                                contactType = contactType,
                                outcome = outcome,
                                notes = notes,
                                duration = duration.toIntOrNull() ?: 0,
                                followUpRequired = followUpRequired,
                                followUpDate = if (followUpRequired) followUpDatePickerState.selectedDateMillis else null,
                                createdAt = activity?.createdAt ?: System.currentTimeMillis()
                            )
                            onSave(newActivity)
                        },
                        enabled = contactId.isNotBlank()
                    ) {
                        Text("Save")
                    }
                }
            }
        }
    }
    
    if (showFollowUpDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showFollowUpDatePicker = false },
            confirmButton = {
                Button(onClick = { showFollowUpDatePicker = false }) {
                    Text("OK")
                }
            }
        ) {
            DatePicker(state = followUpDatePickerState)
        }
    }
}
