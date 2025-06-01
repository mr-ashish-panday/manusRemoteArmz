package com.remotearmz.commandcenter.di;

import android.content.Context;
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
public final class AuthModule_ProvideGoogleSignInOptionsFactory implements Factory<GoogleSignInOptions> {
  private final Provider<Context> contextProvider;

  public AuthModule_ProvideGoogleSignInOptionsFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GoogleSignInOptions get() {
    return provideGoogleSignInOptions(contextProvider.get());
  }

  public static AuthModule_ProvideGoogleSignInOptionsFactory create(
      Provider<Context> contextProvider) {
    return new AuthModule_ProvideGoogleSignInOptionsFactory(contextProvider);
  }

  public static GoogleSignInOptions provideGoogleSignInOptions(Context context) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideGoogleSignInOptions(context));
  }
}
