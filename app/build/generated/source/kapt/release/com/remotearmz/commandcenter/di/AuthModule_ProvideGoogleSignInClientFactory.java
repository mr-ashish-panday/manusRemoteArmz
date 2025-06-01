package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AuthModule_ProvideGoogleSignInClientFactory implements Factory<GoogleSignInClient> {
  private final Provider<Context> contextProvider;

  private final Provider<GoogleSignInOptions> googleSignInOptionsProvider;

  public AuthModule_ProvideGoogleSignInClientFactory(Provider<Context> contextProvider,
      Provider<GoogleSignInOptions> googleSignInOptionsProvider) {
    this.contextProvider = contextProvider;
    this.googleSignInOptionsProvider = googleSignInOptionsProvider;
  }

  @Override
  public GoogleSignInClient get() {
    return provideGoogleSignInClient(contextProvider.get(), googleSignInOptionsProvider.get());
  }

  public static AuthModule_ProvideGoogleSignInClientFactory create(
      Provider<Context> contextProvider,
      Provider<GoogleSignInOptions> googleSignInOptionsProvider) {
    return new AuthModule_ProvideGoogleSignInClientFactory(contextProvider, googleSignInOptionsProvider);
  }

  public static GoogleSignInClient provideGoogleSignInClient(Context context,
      GoogleSignInOptions googleSignInOptions) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideGoogleSignInClient(context, googleSignInOptions));
  }
}
