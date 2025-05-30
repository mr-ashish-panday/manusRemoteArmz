package com.remotearmz.commandcenter

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.remotearmz.commandcenter.ui.main.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

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
        
        // Get initial theme value
        var initialDarkTheme = false
        runBlocking {
            dataStore.data.collect { preferences ->
                initialDarkTheme = preferences[DARK_THEME_KEY] ?: false
                return@collect // Exit after first collection
            }
        }
        
        setContent {
            var isDarkTheme by remember { mutableStateOf(initialDarkTheme) }
            
            MainScreen(
                isDarkTheme = isDarkTheme,
                onThemeChange = { newValue ->
                    isDarkTheme = newValue
                    // Save theme preference
                    runBlocking {
                        dataStore.edit { preferences ->
                            preferences[DARK_THEME_KEY] = newValue
                        }
                    }
                }
            )
        }
    }
}


