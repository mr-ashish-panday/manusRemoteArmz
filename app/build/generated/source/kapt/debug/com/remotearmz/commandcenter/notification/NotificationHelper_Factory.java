package com.remotearmz.commandcenter.notification;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class NotificationHelper_Factory implements Factory<NotificationHelper> {
  private final Provider<Context> contextProvider;

  public NotificationHelper_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NotificationHelper get() {
    return newInstance(contextProvider.get());
  }

  public static NotificationHelper_Factory create(Provider<Context> contextProvider) {
    return new NotificationHelper_Factory(contextProvider);
  }

  public static NotificationHelper newInstance(Context context) {
    return new NotificationHelper(context);
  }
}
