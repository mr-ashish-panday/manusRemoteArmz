package com.remotearmz.commandcenter.notification;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NotificationWorker_AssistedFactory_Impl implements NotificationWorker_AssistedFactory {
  private final NotificationWorker_Factory delegateFactory;

  NotificationWorker_AssistedFactory_Impl(NotificationWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public NotificationWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<NotificationWorker_AssistedFactory> create(
      NotificationWorker_Factory delegateFactory) {
    return InstanceFactory.create(new NotificationWorker_AssistedFactory_Impl(delegateFactory));
  }
}
