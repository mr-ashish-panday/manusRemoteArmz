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

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\f\r\u000eB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0001\u0003\u000f\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lcom/remotearmz/commandcenter/ui/settings/ThemeOption;", "", "title", "", "icon", "error/NonExistentClass", "(Ljava/lang/String;Lerror/NonExistentClass;)V", "getIcon", "()Lerror/NonExistentClass;", "Lerror/NonExistentClass;", "getTitle", "()Ljava/lang/String;", "Dark", "Light", "System", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$Dark;", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$Light;", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$System;", "app_debug"})
public abstract class ThemeOption {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull
    private final ImageVector icon = null;
    
    private ThemeOption(java.lang.String title, ImageVector icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final ImageVector getIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$Light;", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption;", "()V", "app_debug"})
    public static final class Light extends com.remotearmz.commandcenter.ui.settings.ThemeOption {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.settings.ThemeOption.Light INSTANCE = null;
        
        private Light() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$Dark;", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption;", "()V", "app_debug"})
    public static final class Dark extends com.remotearmz.commandcenter.ui.settings.ThemeOption {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.settings.ThemeOption.Dark INSTANCE = null;
        
        private Dark() {
            super(null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/remotearmz/commandcenter/ui/settings/ThemeOption$System;", "Lcom/remotearmz/commandcenter/ui/settings/ThemeOption;", "()V", "app_debug"})
    public static final class System extends com.remotearmz.commandcenter.ui.settings.ThemeOption {
        @org.jetbrains.annotations.NotNull
        public static final com.remotearmz.commandcenter.ui.settings.ThemeOption.System INSTANCE = null;
        
        private System() {
            super(null, null);
        }
    }
}