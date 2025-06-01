package com.remotearmz.commandcenter.di;

import android.content.Context;
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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AuthModule_ProvideGoogleAuthManagerFactory implements Factory<GoogleAuthManager> {
  private final Provider<Context> contextProvider;

  public AuthModule_ProvideGoogleAuthManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public GoogleAuthManager get() {
    return provideGoogleAuthManager(contextProvider.get());
  }

  public static AuthModule_ProvideGoogleAuthManagerFactory create(
      Provider<Context> contextProvider) {
    return new AuthModule_ProvideGoogleAuthManagerFactory(contextProvider);
  }

  public static GoogleAuthManager provideGoogleAuthManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideGoogleAuthManager(context));
  }
}
