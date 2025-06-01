package com.remotearmz.commandcenter.auth;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.tasks.Task;
import com.google.api.services.drive.DriveScopes;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/remotearmz/commandcenter/auth/GoogleAuthManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_currentUser", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "_isSignedIn", "", "currentUser", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentUser", "()Lkotlinx/coroutines/flow/StateFlow;", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInClient$delegate", "Lkotlin/Lazy;", "isSignedIn", "checkCurrentUser", "", "getSignInIntent", "Landroid/content/Intent;", "handleSignInResult", "Lcom/google/android/gms/tasks/Task;", "result", "Landroidx/activity/result/ActivityResult;", "signOut", "app_debug"})
@javax.inject.Singleton
public final class GoogleAuthManager {
    private final android.content.Context context = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.google.android.gms.auth.api.signin.GoogleSignInAccount> _currentUser = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.google.android.gms.auth.api.signin.GoogleSignInAccount> currentUser = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSignedIn = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSignedIn = null;
    private final kotlin.Lazy googleSignInClient$delegate = null;
    
    @javax.inject.Inject
    public GoogleAuthManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.google.android.gms.auth.api.signin.GoogleSignInAccount> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSignedIn() {
        return null;
    }
    
    private final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final android.content.Intent getSignInIntent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.google.android.gms.tasks.Task<com.google.android.gms.auth.api.signin.GoogleSignInAccount> handleSignInResult(@org.jetbrains.annotations.NotNull
    androidx.activity.result.ActivityResult result) {
        return null;
    }
    
    public final void signOut() {
    }
    
    private final void checkCurrentUser() {
    }
}