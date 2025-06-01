package com.remotearmz.commandcenter;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.compose.runtime.Composable;
import dagger.hilt.android.AndroidEntryPoint;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\r\u0010\u000fR%\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0012\u00a8\u0006\u001d"}, d2 = {"Lcom/remotearmz/commandcenter/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "DARK_THEME_KEY", "Landroidx/datastore/preferences/core/Preferences$Key;", "", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "getDataStore", "()Landroidx/datastore/core/DataStore;", "dataStore$delegate$1", "Lkotlin/Lazy;", "isDarkThemeFlow", "Lkotlinx/coroutines/flow/Flow;", "()Lkotlinx/coroutines/flow/Flow;", "isDarkThemeFlow$delegate", "Landroid/content/Context;", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "saveThemePreference", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isDark", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    private final kotlin.properties.ReadOnlyProperty dataStore$delegate = null;
    private final androidx.datastore.preferences.core.Preferences.Key<java.lang.Boolean> DARK_THEME_KEY = null;
    private final kotlin.Lazy dataStore$delegate$1 = null;
    private final kotlin.Lazy isDarkThemeFlow$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getDataStore(android.content.Context $this$dataStore) {
        return null;
    }
    
    private final androidx.datastore.core.DataStore<androidx.datastore.preferences.core.Preferences> getDataStore() {
        return null;
    }
    
    private final kotlinx.coroutines.flow.Flow<java.lang.Boolean> isDarkThemeFlow() {
        return null;
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void saveThemePreference(kotlinx.coroutines.CoroutineScope scope, boolean isDark) {
    }
}