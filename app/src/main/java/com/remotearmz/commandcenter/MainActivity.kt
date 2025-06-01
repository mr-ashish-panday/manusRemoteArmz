package com.remotearmz.commandcenter

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.compose.collectAsStateWithLifecycle // Import added
import com.remotearmz.commandcenter.ui.main.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

// DataStore for preferences
val Context.dataStore by preferencesDataStore(name = "settings")

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    // Theme preference key
    private val DARK_THEME_KEY = booleanPreferencesKey("dark_theme")

    // Get theme preference flow
    private val isDarkThemeFlow: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[DARK_THEME_KEY] ?: false // Default to light theme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Collect theme state using lifecycle-aware collector
            val isDarkTheme by isDarkThemeFlow.collectAsStateWithLifecycle(initialValue = false)
            val scope = rememberCoroutineScope()

            MainScreen(
                isDarkTheme = isDarkTheme,
                onThemeChange = { newValue ->
                    // Save theme preference asynchronously
                    saveThemePreference(scope, newValue)
                }
            )
        }
    }

    // Function to save theme preference asynchronously
    private fun saveThemePreference(scope: CoroutineScope, isDark: Boolean) {
        scope.launch {
            dataStore.edit { preferences ->
                preferences[DARK_THEME_KEY] = isDark
            }
        }
    }
}

