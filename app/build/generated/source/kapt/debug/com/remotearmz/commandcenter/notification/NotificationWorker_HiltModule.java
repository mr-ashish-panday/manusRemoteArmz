package com.remotearmz.commandcenter.notification;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.processing.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = NotificationWorker.class
)
public interface NotificationWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("com.remotearmz.commandcenter.notification.NotificationWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      NotificationWorker_AssistedFactory factory);
}
