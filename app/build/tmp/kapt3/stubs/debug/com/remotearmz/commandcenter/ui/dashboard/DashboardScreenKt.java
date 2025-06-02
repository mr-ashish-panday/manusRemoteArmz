package com.remotearmz.commandcenter.ui.dashboard;

import androidx.compose.animation.*;
import androidx.compose.animation.core.*;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.interaction.rememberInteractionSource;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.mergeDescendants;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import com.remotearmz.commandcenter.data.model.LeadStatus;
import com.remotearmz.commandcenter.util.CurrencyConverter;
import java.time.LocalTime;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0007\u001a\b\u0010\u000e\u001a\u00020\bH\u0007\u001a$\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0003\u001a$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"FADE_IN_DURATION", "", "ITEM_ANIMATION_DELAY", "", "SCALE_ANIMATION_DURATION", "itemAppearAnimation", "Landroidx/compose/animation/EnterTransition;", "DashboardScreen", "", "viewModel", "Lcom/remotearmz/commandcenter/ui/dashboard/DashboardViewModel;", "onNavigateToLeads", "Lkotlin/Function0;", "onAddNewLead", "DashboardScreenPreview", "LeadStatusItem", "status", "Lcom/remotearmz/commandcenter/ui/dashboard/LeadStatusCard;", "modifier", "Landroidx/compose/ui/Modifier;", "index", "QuickActionItem", "action", "Lcom/remotearmz/commandcenter/ui/dashboard/QuickAction;", "app_debug"})
public final class DashboardScreenKt {
    private static final long ITEM_ANIMATION_DELAY = 50L;
    private static final int FADE_IN_DURATION = 400;
    private static final int SCALE_ANIMATION_DURATION = 150;
    private static final androidx.compose.animation.EnterTransition itemAppearAnimation = null;
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.ui.dashboard.DashboardViewModel viewModel, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onNavigateToLeads, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onAddNewLead) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void LeadStatusItem(com.remotearmz.commandcenter.ui.dashboard.LeadStatusCard status, androidx.compose.ui.Modifier modifier, int index) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void QuickActionItem(com.remotearmz.commandcenter.ui.dashboard.QuickAction action, androidx.compose.ui.Modifier modifier, int index) {
    }
    
    @androidx.compose.runtime.Composable
    @Preview
    public static final void DashboardScreenPreview() {
    }
}