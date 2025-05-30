package com.remotearmz.commandcenter.di

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.remotearmz.commandcenter.R
import com.remotearmz.commandcenter.auth.GoogleAuthManager
import com.remotearmz.commandcenter.backup.BackupManager
import com.remotearmz.commandcenter.backup.DriveService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    
    @Provides
    @Singleton
    fun provideGoogleSignInOptions(
        @ApplicationContext context: Context
    ): GoogleSignInOptions {
        return GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestScopes(
                com.google.android.gms.drive.Drive.SCOPE_APPFOLDER,
                com.google.android.gms.drive.Drive.SCOPE_FILE
            )
            .requestIdToken(context.getString(R.string.default_web_client_id))
            .build()
    }
    
    @Provides
    @Singleton
    fun provideGoogleSignInClient(
        @ApplicationContext context: Context,
        googleSignInOptions: GoogleSignInOptions
    ): GoogleSignInClient {
        return GoogleSignIn.getClient(context, googleSignInOptions)
    }
    
    @Provides
    @Singleton
    fun provideGoogleAuthManager(
        @ApplicationContext context: Context,
        googleSignInClient: GoogleSignInClient
    ): GoogleAuthManager {
        return GoogleAuthManager(context, googleSignInClient)
    }
    
    @Provides
    @Singleton
    fun provideDriveService(
        @ApplicationContext context: Context,
        googleAuthManager: GoogleAuthManager
    ): DriveService {
        return DriveService(context, googleAuthManager)
    }
    
    @Provides
    @Singleton
    fun provideBackupManager(
        @ApplicationContext context: Context,
        driveService: DriveService
    ): BackupManager {
        return BackupManager(context, driveService)
    }
}
