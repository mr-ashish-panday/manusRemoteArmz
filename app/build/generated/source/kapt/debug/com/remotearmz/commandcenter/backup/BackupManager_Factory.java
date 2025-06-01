package com.remotearmz.commandcenter.backup;

import android.content.Context;
import com.remotearmz.commandcenter.notification.NotificationHelper;
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
public final class BackupManager_Factory implements Factory<BackupManager> {
  private final Provider<Context> contextProvider;

  private final Provider<DriveService> driveServiceProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public BackupManager_Factory(Provider<Context> contextProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.contextProvider = contextProvider;
    this.driveServiceProvider = driveServiceProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  @Override
  public BackupManager get() {
    return newInstance(contextProvider.get(), driveServiceProvider.get(), notificationHelperProvider.get());
  }

  public static BackupManager_Factory create(Provider<Context> contextProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new BackupManager_Factory(contextProvider, driveServiceProvider, notificationHelperProvider);
  }

  public static BackupManager newInstance(Context context, DriveService driveService,
      NotificationHelper notificationHelper) {
    return new BackupManager(context, driveService, notificationHelper);
  }
}
