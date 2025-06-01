package com.remotearmz.commandcenter.ui.navigation;

import com.remotearmz.commandcenter.R;
import androidx.compose.runtime.Composable;
import androidx.navigation.NavController;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0005\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "", "route", "", "title", "iconResId", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getIconResId", "()I", "getRoute", "()Ljava/lang/String;", "getTitle", "Clients", "Dashboard", "Leads", "Outreach", "Targets", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Clients;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Dashboard;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Leads;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Outreach;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Targets;", "app_debug"})
public abstract class BottomNavItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    private final int iconResId = 0;
    
    private BottomNavItem(java.lang.String route, java.lang.String title, int iconResId) {
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Dashboard;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Dashboard extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Dashboard INSTANCE = null;
        
        private Dashboard() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Clients;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Clients extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Clients INSTANCE = null;
        
        private Clients() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Leads;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Leads extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Leads INSTANCE = null;
        
        private Leads() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Targets;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Targets extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Targets INSTANCE = null;
        
        private Targets() {
            super(null, null, 0);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem$Outreach;", "Lcom/remotearmz/commandcenter/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Outreach extends com.remotearmz.commandcenter.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.navigation.BottomNavItem.Outreach INSTANCE = null;
        
        private Outreach() {
            super(null, null, 0);
        }
    }
}