package com.remotearmz.commandcenter.ui.settings;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.remotearmz.commandcenter.R;
import com.remotearmz.commandcenter.backup.BackupStatus;
import com.remotearmz.commandcenter.ui.settings.components.*;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0007\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00018CX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u000e"}, d2 = {"dp", "", "getDp", "(I)I", "SettingsScreen", "", "viewModel", "Lcom/remotearmz/commandcenter/ui/settings/SettingsViewModel;", "onBackClick", "Lkotlin/Function0;", "formatBackupStatus", "", "status", "Lcom/remotearmz/commandcenter/backup/BackupStatus;", "app_release"})
public final class SettingsScreenKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void SettingsScreen(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.ui.settings.SettingsViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBackClick) {
    }
    
    @androidx.compose.runtime.Composable
    private static final java.lang.String formatBackupStatus(com.remotearmz.commandcenter.backup.BackupStatus status) {
        return null;
    }
    
    @androidx.compose.runtime.Composable
    private static final int getDp(int $this$dp) {
        return 0;
    }
}