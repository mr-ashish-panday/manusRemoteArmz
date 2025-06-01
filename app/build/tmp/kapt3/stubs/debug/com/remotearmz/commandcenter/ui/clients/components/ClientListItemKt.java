package com.remotearmz.commandcenter.ui.clients.components;

import androidx.compose.material.icons.Icons;
import androidx.compose.material3.CardDefaults;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import com.remotearmz.commandcenter.data.model.Client;
import com.remotearmz.commandcenter.data.model.ClientStatus;
import com.remotearmz.commandcenter.utils.CurrencyConverter;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"ClientListItem", "", "client", "Lcom/remotearmz/commandcenter/data/model/Client;", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "InfoRow", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "text", "", "StatusBadge", "status", "Lcom/remotearmz/commandcenter/data/model/ClientStatus;", "app_debug"})
public final class ClientListItemKt {
    
    @androidx.compose.runtime.Composable
    public static final void ClientListItem(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.Client client, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void InfoRow(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.graphics.vector.ImageVector icon, @org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void StatusBadge(@org.jetbrains.annotations.NotNull
    com.remotearmz.commandcenter.data.model.ClientStatus status) {
    }
}