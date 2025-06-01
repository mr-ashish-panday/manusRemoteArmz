package com.remotearmz.commandcenter.backup;

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
public final class BackupWorker_AssistedFactory_Impl implements BackupWorker_AssistedFactory {
  private final BackupWorker_Factory delegateFactory;

  BackupWorker_AssistedFactory_Impl(BackupWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public BackupWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<BackupWorker_AssistedFactory> create(
      BackupWorker_Factory delegateFactory) {
    return InstanceFactory.create(new BackupWorker_AssistedFactory_Impl(delegateFactory));
  }
}
