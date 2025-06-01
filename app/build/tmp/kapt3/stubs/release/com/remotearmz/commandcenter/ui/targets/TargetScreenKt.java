package com.remotearmz.commandcenter.ui.targets;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.remotearmz.commandcenter.data.model.Priority;
import com.remotearmz.commandcenter.data.model.Target;
import com.remotearmz.commandcenter.data.model.TargetCategory;
import com.remotearmz.commandcenter.util.DateFormatter;
import java.util.Date;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a@\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0012\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007\u00a8\u0006\u0015"}, d2 = {"TargetFormDialog", "", "target", "Lcom/remotearmz/commandcenter/data/model/Target;", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function1;", "TargetItem", "onEdit", "onDelete", "onProgressUpdate", "", "TargetScreen", "viewModel", "Lcom/remotearmz/commandcenter/ui/targets/TargetViewModel;", "TargetStatsSection", "stats", "Lcom/remotearmz/commandcenter/ui/targets/TargetStats;", "remainingDays", "", "app_release"})
public final class TargetScreenKt {
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void TargetScreen(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.ui.targets.TargetViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TargetStatsSection(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.ui.targets.TargetStats stats, int remainingDays) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TargetItem(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> onProgressUpdate) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void TargetFormDialog(@org.jetbrains.annotations.Nullable
    com.remotearmz.commandcenter.data.model.Target target, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.remotearmz.commandcenter.data.model.Target, kotlin.Unit> onSave) {
    }
}