package com.remotearmz.commandcenter.auth

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.tasks.Task
import com.google.api.services.drive.DriveScopes
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleAuthManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val _currentUser = MutableStateFlow<GoogleSignInAccount?>(null)
    val currentUser: StateFlow<GoogleSignInAccount?> = _currentUser.asStateFlow()
    
    private val _isSignedIn = MutableStateFlow(false)
    val isSignedIn: StateFlow<Boolean> = _isSignedIn.asStateFlow()
    
    private val googleSignInClient: GoogleSignInClient by lazy {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestScopes(Scope(DriveScopes.DRIVE_FILE))
            .build()
        
        GoogleSignIn.getClient(context, gso)
    }
    
    init {
        checkCurrentUser()
    }
    
    fun getSignInIntent(): Intent = googleSignInClient.signInIntent
    
    fun handleSignInResult(result: ActivityResult): Task<GoogleSignInAccount>? {
        return try {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            val account = task.getResult(ApiException::class.java)
            _currentUser.value = account
            _isSignedIn.value = true
            task
        } catch (e: ApiException) {
            _isSignedIn.value = false
            null
        }
    }
    
    fun signOut() {
        googleSignInClient.signOut().addOnCompleteListener {
            _currentUser.value = null
            _isSignedIn.value = false
        }
    }
    
    private fun checkCurrentUser() {
        val account = GoogleSignIn.getLastSignedInAccount(context)
        _currentUser.value = account
        _isSignedIn.value = account != null
    }
}
