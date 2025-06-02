package com.remotearmz.commandcenter.ui.settings

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.backup.BackupStatus
import com.remotearmz.commandcenter.ui.settings.components.*
import com.remotearmz.commandcenter.ui.theme.LocalSpacing
import java.text.SimpleDateFormat
import java.util.*

// Sealed class for theme options
sealed class ThemeOption(val title: String, val icon: ImageVector) {
    object Light : ThemeOption("Light", Icons.Default.LightMode)
    object Dark : ThemeOption("Dark", Icons.Default.DarkMode)
    object System : ThemeOption("System Default", Icons.Default.Settings)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {}
) {
    val context = LocalContext.current
    val spacing = LocalSpacing.current
    val scrollState = rememberScrollState()
    
    // Collect state
    val isSignedIn by viewModel.isSignedIn.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val backupStatus by viewModel.backupStatus.collectAsState()
    val lastBackupTime by viewModel.lastBackupTime.collectAsState()
    val isBackupScheduled by viewModel.isBackupScheduled.collectAsState()
    val showRestoreDialog by viewModel.showRestoreDialog.collectAsState()
    val availableBackups by viewModel.availableBackups.collectAsState()
    val restoreStatus by viewModel.restoreStatus.collectAsState()
    
    // Local state
    var selectedTheme by remember { mutableStateOf(ThemeOption.System) }
    var showThemeDialog by remember { mutableStateOf(false) }
    
    val signInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        viewModel.handleSignInResult(result)
    }
    
    // Handle backup status changes
    LaunchedEffect(backupStatus) {
        when (val status = backupStatus) {
            is BackupStatus.Success -> {
                // Show success message
            }
            is BackupStatus.Failed -> {
                // Show error message
            }
            else -> {}
        }
    }
    
    // Handle restore dialog
    if (showRestoreDialog) {
        RestoreBackupDialog(
            backups = availableBackups,
            onDismiss = { viewModel.hideRestoreDialog() },
            onRestore = { backupId ->
                viewModel.restoreFromBackup(backupId)
            },
            restoreStatus = restoreStatus
        )
    }
    
    // Theme selection dialog
    if (showThemeDialog) {
        ThemeSelectionDialog(
            currentTheme = selectedTheme,
            onThemeSelected = { theme ->
                selectedTheme = theme
                // TODO: Apply theme change
                showThemeDialog = false
            },
            onDismiss = { showThemeDialog = false }
        )
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        text = "Settings",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp),
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState)
        ) {
            // Appearance Section
            SettingsSection(title = "Appearance") {
                // Theme Selection
                SettingsItem(
                    title = "Theme",
                    subtitle = when (selectedTheme) {
                        is ThemeOption.Light -> "Light"
                        is ThemeOption.Dark -> "Dark"
                        is ThemeOption.System -> "System Default"
                        else -> ""
                    },
                    icon = Icons.Default.Palette,
                    showDivider = true,
                    onClick = { showThemeDialog = true }
                )
                
                // Accent Color (Future enhancement)
                SettingsItem(
                    title = "Accent Color",
                    subtitle = "Customize app colors",
                    icon = Icons.Default.ColorLens,
                    showDivider = false,
                    enabled = false
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Account Section
            SettingsSection(title = "Account") {
                if (isSignedIn) {
                    // User Profile
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Profile Picture Placeholder
                        Surface(
                            shape = CircleShape,
                            color = MaterialTheme.colorScheme.primaryContainer,
                            modifier = Modifier.size(56.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        // User Info
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = userName.ifEmpty { "User" },
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            
                            Text(
                                text = GoogleSignIn.getLastSignedInAccount(context)?.email ?: "",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                        
                        // Sign Out Button
                        OutlinedButton(
                            onClick = { viewModel.signOut() },
                            colors = ButtonDefaults.outlinedButtonColors(
                                contentColor = MaterialTheme.colorScheme.error
                            )
                        ) {
                            Text("Sign Out")
                        }
                    }
                } else {
                    // Sign In Prompt
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = null,
                            modifier = Modifier.size(48.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "Sign in to access all features",
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Center
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        Button(
                            onClick = { signInLauncher.launch(viewModel.getSignInIntent()) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.surface,
                                contentColor = MaterialTheme.colorScheme.onSurface
                            ),
                            border = ButtonDefaults.outlinedBorder
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_google_logo),
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Sign in with Google")
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Backup & Restore Section (only show if signed in)
            if (isSignedIn) {
                SettingsSection(title = "Backup & Restore") {
                    // Backup Status
                    SettingItem(
                        icon = Icons.Default.CloudUpload,
                        title = "Backup Status",
                        subtitle = when (val status = backupStatus) {
                            is BackupStatus.Idle -> "Up to date"
                            is BackupStatus.InProgress -> "Backup in progress..."
                            is BackupStatus.Success -> "Backup completed successfully"
                            is BackupStatus.Failed -> "Backup failed: ${status.error}"
                        },
                        showDivider = true,
                        trailing = {
                            if (backupStatus is BackupStatus.InProgress) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(20.dp),
                                    strokeWidth = 2.dp
                                )
                            }
                        }
                    )
                    
                    // Last Backup Time
                    lastBackupTime?.let { time ->
                        val dateFormat = SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a", Locale.getDefault())
                        SettingItem(
                            icon = Icons.Default.Schedule,
                            title = "Last Backup",
                            subtitle = dateFormat.format(Date(time)),
                            showDivider = true
                        )
                    }
                    
                    // Manual Backup Button
                    SettingItem(
                        icon = Icons.Default.Backup,
                        title = "Backup Now",
                        subtitle = "Create a new backup",
                        enabled = backupStatus !is BackupStatus.InProgress,
                        showDivider = true,
                        onClick = { viewModel.performManualBackup() }
                    )
                    
                    // Scheduled Backup Toggle
                    SettingSwitch(
                        icon = Icons.Default.Schedule,
                        title = "Scheduled Backup",
                        subtitle = if (isBackupScheduled) "Enabled - Daily at 2:00 AM" else "Disabled",
                        checked = isBackupScheduled,
                        onCheckedChange = { viewModel.toggleScheduledBackup() },
                        showDivider = true
                    )
                    
                    // Restore Button
                    SettingItem(
                        icon = Icons.Default.Restore,
                        title = "Restore from Backup",
                        subtitle = "Restore your data from a previous backup",
                        enabled = backupStatus !is BackupStatus.InProgress,
                        showDivider = false,
                        onClick = { viewModel.showRestoreDialog() }
                    )
                }
                
                Spacer(modifier = Modifier.height(16.dp))
            }
            
            // App Info Section
            SettingsSection(title = "About") {
                SettingItem(
                    icon = Icons.Default.Info,
                    title = "Version",
                    subtitle = "1.0.0", // TODO: Get from BuildConfig
                    showDivider = true
                )
                
                SettingItem(
                    icon = Icons.Default.PrivacyTip,
                    title = "Privacy Policy",
                    showDivider = true,
                    onClick = { /* TODO: Open privacy policy */ }
                )
                
                SettingItem(
                    icon = Icons.Default.Description,
                    title = "Terms of Service",
                    showDivider = false,
                    onClick = { /* TODO: Open terms of service */ }
                )
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // App Version
            Text(
                text = "Command Center v1.0.0", // TODO: Get from BuildConfig
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun formatBackupStatus(status: BackupStatus): String {
    return when (status) {
        is BackupStatus.Idle -> "Ready"
        is BackupStatus.InProgress -> "Backup in progress..."
        is BackupStatus.Success -> "Backup completed successfully"
        is BackupStatus.Failed -> "Backup failed: ${status.error}"
    }
}

// Extension function to convert dp to pixels
private val Int.dp: Int
    @Composable get() = (this * LocalDensity.current.density).toInt()
