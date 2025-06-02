package com.remotearmz.commandcenter.ui.navigation;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material.icons.outlined.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import com.remotearmz.commandcenter.R;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B7\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010\u0082\u0001\u0005\u0018\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "", "route", "", "title", "iconResId", "", "selectedIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "unselectedIcon", "(Ljava/lang/String;Ljava/lang/String;ILandroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIconResId", "()I", "getRoute", "()Ljava/lang/String;", "getSelectedIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getTitle", "getUnselectedIcon", "Clients", "Dashboard", "Leads", "Outreach", "Targets", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Clients;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Dashboard;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Leads;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Outreach;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Targets;", "app_release"})
public abstract class BottomNavItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    private final int iconResId = 0;
    @org.jetbrains.annotations.Nullable
    private final androidx.compose.ui.graphics.vector.ImageVector selectedIcon = null;
    @org.jetbrains.annotations.Nullable
    private final androidx.compose.ui.graphics.vector.ImageVector unselectedIcon = null;
    
    private BottomNavItem(java.lang.String route, java.lang.String title, int iconResId, androidx.compose.ui.graphics.vector.ImageVector selectedIcon, androidx.compose.ui.graphics.vector.ImageVector unselectedIcon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final int getIconResId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.compose.ui.graphics.vector.ImageVector getSelectedIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.compose.ui.graphics.vector.ImageVector getUnselectedIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Dashboard;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_release"})
    public static final class Dashboard extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Dashboard INSTANCE = null;
        
        private Dashboard() {
            super(null, null, 0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Clients;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_release"})
    public static final class Clients extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Clients INSTANCE = null;
        
        private Clients() {
            super(null, null, 0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Leads;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_release"})
    public static final class Leads extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Leads INSTANCE = null;
        
        private Leads() {
            super(null, null, 0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Targets;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_release"})
    public static final class Targets extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Targets INSTANCE = null;
        
        private Targets() {
            super(null, null, 0, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Outreach;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_release"})
    public static final class Outreach extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Outreach INSTANCE = null;
        
        private Outreach() {
            super(null, null, 0, null, null);
        }
    }
}