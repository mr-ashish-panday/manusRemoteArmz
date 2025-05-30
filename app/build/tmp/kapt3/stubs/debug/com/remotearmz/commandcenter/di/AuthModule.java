package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.remotearmz.commandcenter.R;
import com.remotearmz.commandcenter.auth.GoogleAuthManager;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.backup.DriveService;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001a\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u001a\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00112\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/remotearmz/commandcenter/di/AuthModule;", "", "()V", "provideBackupManager", "Lcom/remotearmz/commandcenter/backup/BackupManager;", "context", "Landroid/content/Context;", "driveService", "Lcom/remotearmz/commandcenter/backup/DriveService;", "provideDriveService", "googleAuthManager", "Lcom/remotearmz/commandcenter/auth/GoogleAuthManager;", "provideGoogleAuthManager", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "provideGoogleSignInClient", "googleSignInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "provideGoogleSignInOptions", "app_debug"})
@dagger.Module()
public final class AuthModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.remotearmz.commandcenter.di.AuthModule INSTANCE = null;
    
    private AuthModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.google.android.gms.auth.api.signin.GoogleSignInOptions provideGoogleSignInOptions(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient provideGoogleSignInClient(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.remotearmz.commandcenter.auth.GoogleAuthManager provideGoogleAuthManager(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.remotearmz.commandcenter.backup.DriveService provideDriveService(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.auth.GoogleAuthManager googleAuthManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.remotearmz.commandcenter.backup.BackupManager provideBackupManager(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.remotearmz.commandcenter.backup.DriveService driveService) {
        return null;
    }
}