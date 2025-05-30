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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
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
        
        // For demo purposes, we'll assume backup is scheduled by default
        _isBackupScheduled.value = true
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
            backupManager.performManualBackup()
        }
    }
    
    fun toggleScheduledBackup() {
        if (isBackupScheduled.value) {
            backupManager.cancelPeriodicBackup()
            _isBackupScheduled.value = false
        } else {
            backupManager.schedulePeriodicBackup()
            _isBackupScheduled.value = true
        }
    }
    
    fun showRestoreDialog() {
        viewModelScope.launch {
            _availableBackups.value = driveService.listBackups()
            _showRestoreDialog.value = true
        }
    }
    
    fun hideRestoreDialog() {
        _showRestoreDialog.value = false
    }
    
    fun restoreFromBackup(fileId: String) {
        viewModelScope.launch {
            // Implementation for restoring from backup would go here
            // This would involve downloading the backup file and restoring the data
            hideRestoreDialog()
        }
    }
}
