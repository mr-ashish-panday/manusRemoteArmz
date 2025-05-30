package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.remotearmz.commandcenter.notification.NotificationManager;
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
public final class AppModule_ProvideNotificationManagerFactory implements Factory<NotificationManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideNotificationManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NotificationManager get() {
    return provideNotificationManager(contextProvider.get());
  }

  public static AppModule_ProvideNotificationManagerFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideNotificationManagerFactory(contextProvider);
  }

  public static NotificationManager provideNotificationManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNotificationManager(context));
  }
}
