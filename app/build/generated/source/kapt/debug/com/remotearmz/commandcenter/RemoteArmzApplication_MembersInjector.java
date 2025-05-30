package com.remotearmz.commandcenter;

import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.notification.NotificationManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RemoteArmzApplication_MembersInjector implements MembersInjector<RemoteArmzApplication> {
  private final Provider<NotificationManager> notificationManagerProvider;

  private final Provider<BackupManager> backupManagerProvider;

  public RemoteArmzApplication_MembersInjector(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<BackupManager> backupManagerProvider) {
    this.notificationManagerProvider = notificationManagerProvider;
    this.backupManagerProvider = backupManagerProvider;
  }

  public static MembersInjector<RemoteArmzApplication> create(
      Provider<NotificationManager> notificationManagerProvider,
      Provider<BackupManager> backupManagerProvider) {
    return new RemoteArmzApplication_MembersInjector(notificationManagerProvider, backupManagerProvider);
  }

  @Override
  public void injectMembers(RemoteArmzApplication instance) {
    injectNotificationManager(instance, notificationManagerProvider.get());
    injectBackupManager(instance, backupManagerProvider.get());
  }

  @InjectedFieldSignature("com.remotearmz.commandcenter.RemoteArmzApplication.notificationManager")
  public static void injectNotificationManager(RemoteArmzApplication instance,
      NotificationManager notificationManager) {
    instance.notificationManager = notificationManager;
  }

  @InjectedFieldSignature("com.remotearmz.commandcenter.RemoteArmzApplication.backupManager")
  public static void injectBackupManager(RemoteArmzApplication instance,
      BackupManager backupManager) {
    instance.backupManager = backupManager;
  }
}
