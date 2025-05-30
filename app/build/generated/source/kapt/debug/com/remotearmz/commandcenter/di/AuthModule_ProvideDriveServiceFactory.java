package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.remotearmz.commandcenter.auth.GoogleAuthManager;
import com.remotearmz.commandcenter.backup.DriveService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AuthModule_ProvideDriveServiceFactory implements Factory<DriveService> {
  private final Provider<Context> contextProvider;

  private final Provider<GoogleAuthManager> googleAuthManagerProvider;

  public AuthModule_ProvideDriveServiceFactory(Provider<Context> contextProvider,
      Provider<GoogleAuthManager> googleAuthManagerProvider) {
    this.contextProvider = contextProvider;
    this.googleAuthManagerProvider = googleAuthManagerProvider;
  }

  @Override
  public DriveService get() {
    return provideDriveService(contextProvider.get(), googleAuthManagerProvider.get());
  }

  public static AuthModule_ProvideDriveServiceFactory create(Provider<Context> contextProvider,
      Provider<GoogleAuthManager> googleAuthManagerProvider) {
    return new AuthModule_ProvideDriveServiceFactory(contextProvider, googleAuthManagerProvider);
  }

  public static DriveService provideDriveService(Context context,
      GoogleAuthManager googleAuthManager) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideDriveService(context, googleAuthManager));
  }
}
