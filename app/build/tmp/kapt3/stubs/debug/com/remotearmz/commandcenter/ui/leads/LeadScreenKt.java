package com.remotearmz.commandcenter.ui.leads;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.FilterList;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import com.remotearmz.commandcenter.util.CurrencyFormatter;
import com.remotearmz.commandcenter.util.DateFormatter;
import java.util.Date;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a@\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0012\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"LeadFormDialog", "", "lead", "Lcom/remotearmz/commandcenter/data/model/Lead;", "onDismiss", "Lkotlin/Function0;", "onSave", "Lkotlin/Function1;", "LeadItem", "onEdit", "onDelete", "onStatusChange", "Lcom/remotearmz/commandcenter/data/model/LeadStatus;", "LeadScreen", "viewModel", "Lcom/remotearmz/commandcenter/ui/leads/LeadViewModel;", "LeadStatsSection", "stats", "Lcom/remotearmz/commandcenter/ui/leads/LeadStats;", "app_debug"})
public final class LeadScreenKt {
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void LeadScreen(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.ui.leads.LeadViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LeadStatsSection(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.ui.leads.LeadStats stats) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void LeadItem(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.remotearmz.commandcenter.data.model.LeadStatus, kotlin.Unit> onStatusChange) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void LeadFormDialog(@org.jetbrains.annotations.Nullable()
    com.remotearmz.commandcenter.data.model.Lead lead, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.remotearmz.commandcenter.data.model.Lead, kotlin.Unit> onSave) {
    }
}