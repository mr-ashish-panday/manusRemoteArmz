package com.remotearmz.commandcenter.ui.settings

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Restore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.remotearmz.commandcenter.backup.BackupStatus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun SettingsScreen(viewModel: SettingsViewModel = hiltViewModel()) {
    val isSignedIn by viewModel.isSignedIn.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val backupStatus by viewModel.backupStatus.collectAsState()
    val lastBackupTime by viewModel.lastBackupTime.collectAsState()
    
    val signInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        viewModel.handleSignInResult(result)
    }
    
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(bottom = 24.dp)
            )
            
            // Google Account Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Google Account",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    if (isSignedIn) {
                        Text(
                            text = "Signed in as: $userName",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(
                            onClick = { viewModel.signOut() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Person, contentDescription = null)
                            Text("Sign Out", modifier = Modifier.padding(start = 8.dp))
                        }
                    } else {
                        Text(
                            text = "You need to sign in with Google to use backup features",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(
                            onClick = { signInLauncher.launch(viewModel.getSignInIntent()) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Person, contentDescription = null)
                            Text("Sign In with Google", modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }
            
            // Backup Card
            if (isSignedIn) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Backup & Restore",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Backup Status
                        Text(
                            text = "Status: ${formatBackupStatus(backupStatus)}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        
                        lastBackupTime?.let { time ->
                            val dateFormat = SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.getDefault())
                            Text(
                                text = "Last backup: ${dateFormat.format(Date(time))}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        Divider()
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        // Manual Backup Button
                        Button(
                            onClick = { viewModel.performManualBackup() },
                            modifier = Modifier.fillMaxWidth(),
                            enabled = backupStatus !is BackupStatus.InProgress
                        ) {
                            Icon(Icons.Default.CloudUpload, contentDescription = null)
                            Text("Backup Now", modifier = Modifier.padding(start = 8.dp))
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Scheduled Backup Toggle
                        Button(
                            onClick = { viewModel.toggleScheduledBackup() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Icon(Icons.Default.Backup, contentDescription = null)
                            val isBackupScheduled by viewModel.isBackupScheduled.collectAsState()
                            Text(
                                text = if (isBackupScheduled) "Disable Daily Backup" else "Enable Daily Backup",
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        // Restore Button
                        Button(
                            onClick = { viewModel.showRestoreDialog() },
                            modifier = Modifier.fillMaxWidth(),
                            enabled = backupStatus !is BackupStatus.InProgress
                        ) {
                            Icon(Icons.Default.Restore, contentDescription = null)
                            Text("Restore from Backup", modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun formatBackupStatus(status: BackupStatus): String {
    return when (status) {
        is BackupStatus.Idle -> "Ready"
        is BackupStatus.InProgress -> "Backup in progress..."
        is BackupStatus.Success -> "Success: ${status.message}"
        is BackupStatus.Failed -> "Failed: ${status.error}"
    }
}
