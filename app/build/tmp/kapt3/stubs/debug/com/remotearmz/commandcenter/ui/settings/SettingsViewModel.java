package com.remotearmz.commandcenter.ui.settings;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.ViewModel;
import com.remotearmz.commandcenter.auth.GoogleAuthManager;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.backup.BackupStatus;
import com.remotearmz.commandcenter.backup.DriveService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010%\u001a\u00020&J\u000e\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020(J\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u0013J\u0006\u0010!\u001a\u00020(J\u0006\u0010/\u001a\u00020(J\u0006\u00100\u001a\u00020(R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017\u00a8\u00061"}, d2 = {"Lcom/remotearmz/commandcenter/ui/settings/SettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "googleAuthManager", "Lcom/remotearmz/commandcenter/auth/GoogleAuthManager;", "backupManager", "Lcom/remotearmz/commandcenter/backup/BackupManager;", "driveService", "Lcom/remotearmz/commandcenter/backup/DriveService;", "(Lcom/remotearmz/commandcenter/auth/GoogleAuthManager;Lcom/remotearmz/commandcenter/backup/BackupManager;Lcom/remotearmz/commandcenter/backup/DriveService;)V", "_availableBackups", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/remotearmz/commandcenter/backup/DriveBackupFile;", "_isBackupScheduled", "", "_restoreStatus", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "_showRestoreDialog", "_userName", "", "availableBackups", "Lkotlinx/coroutines/flow/StateFlow;", "getAvailableBackups", "()Lkotlinx/coroutines/flow/StateFlow;", "backupStatus", "getBackupStatus", "isBackupScheduled", "isSignedIn", "lastBackupTime", "", "getLastBackupTime", "restoreStatus", "getRestoreStatus", "showRestoreDialog", "getShowRestoreDialog", "userName", "getUserName", "getSignInIntent", "Landroid/content/Intent;", "handleSignInResult", "", "result", "Landroidx/activity/result/ActivityResult;", "hideRestoreDialog", "performManualBackup", "restoreFromBackup", "fileId", "signOut", "toggleScheduledBackup", "app_debug"})
public final class SettingsViewModel extends androidx.lifecycle.ViewModel {
    private final com.remotearmz.commandcenter.auth.GoogleAuthManager googleAuthManager = null;
    private final com.remotearmz.commandcenter.backup.BackupManager backupManager = null;
    private final com.remotearmz.commandcenter.backup.DriveService driveService = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSignedIn = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _userName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> userName = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> backupStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Long> lastBackupTime = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isBackupScheduled = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackupScheduled = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showRestoreDialog = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showRestoreDialog = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.remotearmz.commandcenter.backup.DriveBackupFile>> _availableBackups = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.backup.DriveBackupFile>> availableBackups = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.remotearmz.commandcenter.backup.BackupStatus> _restoreStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> restoreStatus = null;
    
    @javax.inject.Inject
    public SettingsViewModel(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.auth.GoogleAuthManager googleAuthManager, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.backup.BackupManager backupManager, @org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.backup.DriveService driveService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSignedIn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> getBackupStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Long> getLastBackupTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isBackupScheduled() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowRestoreDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.remotearmz.commandcenter.backup.DriveBackupFile>> getAvailableBackups() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Intent getSignInIntent() {
        return null;
    }
    
    public final void handleSignInResult(@org.jetbrains.annotations.NotNull
    androidx.activity.result.ActivityResult result) {
    }
    
    public final void signOut() {
    }
    
    public final void performManualBackup() {
    }
    
    public final void toggleScheduledBackup() {
    }
    
    public final void showRestoreDialog() {
    }
    
    public final void hideRestoreDialog() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.remotearmz.commandcenter.backup.BackupStatus> getRestoreStatus() {
        return null;
    }
    
    public final void restoreFromBackup(@org.jetbrains.annotations.NotNull
    java.lang.String fileId) {
    }
}