package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.remotearmz.commandcenter.auth.GoogleAuthManager;
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
public final class AuthModule_ProvideGoogleAuthManagerFactory implements Factory<GoogleAuthManager> {
  private final Provider<Context> contextProvider;

  private final Provider<GoogleSignInClient> googleSignInClientProvider;

  public AuthModule_ProvideGoogleAuthManagerFactory(Provider<Context> contextProvider,
      Provider<GoogleSignInClient> googleSignInClientProvider) {
    this.contextProvider = contextProvider;
    this.googleSignInClientProvider = googleSignInClientProvider;
  }

  @Override
  public GoogleAuthManager get() {
    return provideGoogleAuthManager(contextProvider.get(), googleSignInClientProvider.get());
  }

  public static AuthModule_ProvideGoogleAuthManagerFactory create(Provider<Context> contextProvider,
      Provider<GoogleSignInClient> googleSignInClientProvider) {
    return new AuthModule_ProvideGoogleAuthManagerFactory(contextProvider, googleSignInClientProvider);
  }

  public static GoogleAuthManager provideGoogleAuthManager(Context context,
      GoogleSignInClient googleSignInClient) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideGoogleAuthManager(context, googleSignInClient));
  }
}
