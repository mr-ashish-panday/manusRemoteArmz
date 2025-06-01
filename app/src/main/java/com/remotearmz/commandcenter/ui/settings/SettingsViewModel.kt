package com.remotearmz.commandcenter.ui.settings

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.remotearmz.commandcenter.auth.GoogleAuthManager
import com.remotearmz.commandcenter.backup.BackupManager
import com.remotearmz.commandcenter.backup.BackupStatus
import com.remotearmz.commandcenter.backup.DriveService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val googleAuthManager: GoogleAuthManager,
    private val backupManager: BackupManager,
    private val driveService: DriveService
) : ViewModel() {

    val isSignedIn: StateFlow<Boolean> = googleAuthManager.isSignedIn

    private val _userName = MutableStateFlow("")
    val userName: StateFlow<String> = _userName.asStateFlow()

    val backupStatus: StateFlow<BackupStatus> = driveService.backupStatus
    val lastBackupTime: StateFlow<Long?> = driveService.lastBackupTime

    private val _isBackupScheduled = MutableStateFlow(false)
    val isBackupScheduled: StateFlow<Boolean> = _isBackupScheduled.asStateFlow()

    private val _showRestoreDialog = MutableStateFlow(false)
    val showRestoreDialog: StateFlow<Boolean> = _showRestoreDialog.asStateFlow()

    private val _availableBackups = MutableStateFlow<List<com.remotearmz.commandcenter.backup.DriveBackupFile>>(emptyList())
    val availableBackups: StateFlow<List<com.remotearmz.commandcenter.backup.DriveBackupFile>> = _availableBackups.asStateFlow()

    init {
        viewModelScope.launch {
            googleAuthManager.currentUser.collectLatest { account ->
                _userName.value = account?.displayName ?: ""
            }
        }

        // Collect the scheduled backup status
        viewModelScope.launch {
            backupManager.isScheduledBackupEnabled.collect { isEnabled ->
                _isBackupScheduled.value = isEnabled
            }
        }
    }

    fun getSignInIntent(): Intent {
        return googleAuthManager.getSignInIntent()
    }

    fun handleSignInResult(result: ActivityResult) {
        googleAuthManager.handleSignInResult(result)
    }

    fun signOut() {
        googleAuthManager.signOut()
    }

    fun performManualBackup() {
        viewModelScope.launch {
            // Ensure backup runs on IO dispatcher
            withContext(Dispatchers.IO) {
                backupManager.performManualBackup()
            }
        }
    }

    fun toggleScheduledBackup() {
        viewModelScope.launch {
            if (isBackupScheduled.value) {
                backupManager.cancelPeriodicBackup()
                // The state will be updated through the flow collection in init
            } else {
                backupManager.schedulePeriodicBackup()
                // The state will be updated through the flow collection in init
            }
        }
    }

    fun showRestoreDialog() {
        viewModelScope.launch {
            // List backups on IO dispatcher
            val backups = withContext(Dispatchers.IO) {
                driveService.listBackups()
            }
            _availableBackups.value = backups
            _showRestoreDialog.value = true
        }
    }

    fun hideRestoreDialog() {
        _showRestoreDialog.value = false
    }

    private val _restoreStatus = MutableStateFlow<BackupStatus?>(null)
    val restoreStatus: StateFlow<BackupStatus?> = _restoreStatus.asStateFlow()
    
    fun restoreFromBackup(fileId: String) {
        viewModelScope.launch {
            _restoreStatus.value = BackupStatus.InProgress()
            
            try {
                val success = withContext(Dispatchers.IO) {
                    backupManager.restoreFromBackup(fileId)
                }
                
                if (success) {
                    _restoreStatus.value = BackupStatus.Success("Restore completed successfully")
                    // Optionally, refresh the UI or show a success message
                } else {
                    _restoreStatus.value = BackupStatus.Failed("Failed to restore from backup")
                }
            } catch (e: Exception) {
                _restoreStatus.value = BackupStatus.Failed("Restore failed: ${e.message ?: "Unknown error"}")
            }
            
            // Hide the dialog after a short delay to show the status
            delay(2000)
            hideRestoreDialog()
            _restoreStatus.value = null // Reset the status
        }
    }
}

