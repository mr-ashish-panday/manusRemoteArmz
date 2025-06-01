package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.backup.DriveService;
import com.remotearmz.commandcenter.notification.NotificationHelper;
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
public final class AuthModule_ProvideBackupManagerFactory implements Factory<BackupManager> {
  private final Provider<Context> contextProvider;

  private final Provider<DriveService> driveServiceProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public AuthModule_ProvideBackupManagerFactory(Provider<Context> contextProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.contextProvider = contextProvider;
    this.driveServiceProvider = driveServiceProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  @Override
  public BackupManager get() {
    return provideBackupManager(contextProvider.get(), driveServiceProvider.get(), notificationHelperProvider.get());
  }

  public static AuthModule_ProvideBackupManagerFactory create(Provider<Context> contextProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new AuthModule_ProvideBackupManagerFactory(contextProvider, driveServiceProvider, notificationHelperProvider);
  }

  public static BackupManager provideBackupManager(Context context, DriveService driveService,
      NotificationHelper notificationHelper) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideBackupManager(context, driveService, notificationHelper));
  }
}
