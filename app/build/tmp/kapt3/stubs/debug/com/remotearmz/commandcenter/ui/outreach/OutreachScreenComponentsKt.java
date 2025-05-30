package com.remotearmz.commandcenter.ui.outreach;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.ExperimentalMaterial3Api;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ContactType;
import com.remotearmz.commandcenter.data.model.Lead;
import com.remotearmz.commandcenter.data.model.OutreachActivity;
import com.remotearmz.commandcenter.data.model.OutreachOutcome;
import com.remotearmz.commandcenter.data.model.OutreachType;
import com.remotearmz.commandcenter.util.DateFormatter;
import java.util.UUID;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001aP\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000fH\u0007\u001aH\u0010\u0010\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u00a8\u0006\u0013"}, d2 = {"FollowUpItem", "", "followUp", "Lcom/remotearmz/commandcenter/data/model/OutreachActivity;", "clients", "", "Lcom/remotearmz/commandcenter/data/model/Client;", "leads", "Lcom/remotearmz/commandcenter/data/model/Lead;", "onMarkComplete", "Lkotlin/Function0;", "OutreachActivityFormDialog", "activity", "onDismiss", "onSave", "Lkotlin/Function1;", "OutreachActivityItem", "onEdit", "onDelete", "app_debug"})
public final class OutreachScreenComponentsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void OutreachActivityItem(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Client> clients, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Lead> leads, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FollowUpItem(@org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.data.model.OutreachActivity followUp, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Client> clients, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Lead> leads, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMarkComplete) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void OutreachActivityFormDialog(@org.jetbrains.annotations.Nullable()
    com.remotearmz.commandcenter.data.model.OutreachActivity activity, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Client> clients, @org.jetbrains.annotations.NotNull()
    java.util.List<com.remotearmz.commandcenter.data.model.Lead> leads, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.remotearmz.commandcenter.data.model.OutreachActivity, kotlin.Unit> onSave) {
    }
}