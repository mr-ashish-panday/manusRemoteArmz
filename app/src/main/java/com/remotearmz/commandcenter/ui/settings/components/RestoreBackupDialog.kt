package com.remotearmz.commandcenter.ui.settings.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.backup.BackupStatus
import com.remotearmz.commandcenter.backup.DriveBackupFile
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun RestoreBackupDialog(
    backups: List<DriveBackupFile>,
    onDismiss: () -> Unit,
    onRestore: (String) -> Unit,
    restoreStatus: BackupStatus?
) {
    var selectedBackupId by remember { mutableStateOf<String?>(null) }
    val isRestoring = restoreStatus is BackupStatus.InProgress
    
    AlertDialog(
        onDismissRequest = { if (!isRestoring) onDismiss() },
        title = { Text("Restore from Backup") },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 400.dp)
            ) {
                if (backups.isEmpty()) {
                    Text(
                        text = "No backups found",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                } else {
                    LazyColumn {
                        items(backups) { backup ->
                            val isSelected = selectedBackupId == backup.id
                            val dateFormat = SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a", Locale.getDefault())
                            val formattedDate = dateFormat.format(Date(backup.modifiedTime))
                            
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp),
                                color = if (isSelected) {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.surfaceVariant
                                },
                                shape = MaterialTheme.shapes.medium,
                                onClick = { if (!isRestoring) selectedBackupId = backup.id }
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = backup.name,
                                            style = MaterialTheme.typography.bodyLarge,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                        Text(
                                            text = "Backup • $formattedDate",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                        Text(
                                            text = "${backup.size / 1024} KB",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    
                                    if (isSelected) {
                                        Icon(
                                            imageVector = Icons.Default.CheckCircle,
                                            contentDescription = null,
                                            tint = MaterialTheme.colorScheme.primary,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Show restore status
                when (val status = restoreStatus) {
                    is BackupStatus.InProgress -> {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(20.dp),
                                strokeWidth = 2.dp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = status.message ?: "Restoring backup...",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                    is BackupStatus.Failed -> {
                        Text(
                            text = "Failed: ${status.error}",
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    else -> {}
                }
            }
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    onClick = onDismiss,
                    enabled = !isRestoring
                ) {
                    Text("CANCEL")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { selectedBackupId?.let { onRestore(it) } },
                    enabled = selectedBackupId != null && !isRestoring
                ) {
                    Text("RESTORE")
                }
            }
        }
    )
}
