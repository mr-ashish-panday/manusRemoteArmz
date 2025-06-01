package com.remotearmz.commandcenter.ui.settings;

import com.remotearmz.commandcenter.auth.GoogleAuthManager;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.backup.DriveService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<GoogleAuthManager> googleAuthManagerProvider;

  private final Provider<BackupManager> backupManagerProvider;

  private final Provider<DriveService> driveServiceProvider;

  public SettingsViewModel_Factory(Provider<GoogleAuthManager> googleAuthManagerProvider,
      Provider<BackupManager> backupManagerProvider, Provider<DriveService> driveServiceProvider) {
    this.googleAuthManagerProvider = googleAuthManagerProvider;
    this.backupManagerProvider = backupManagerProvider;
    this.driveServiceProvider = driveServiceProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(googleAuthManagerProvider.get(), backupManagerProvider.get(), driveServiceProvider.get());
  }

  public static SettingsViewModel_Factory create(
      Provider<GoogleAuthManager> googleAuthManagerProvider,
      Provider<BackupManager> backupManagerProvider, Provider<DriveService> driveServiceProvider) {
    return new SettingsViewModel_Factory(googleAuthManagerProvider, backupManagerProvider, driveServiceProvider);
  }

  public static SettingsViewModel newInstance(GoogleAuthManager googleAuthManager,
      BackupManager backupManager, DriveService driveService) {
    return new SettingsViewModel(googleAuthManager, backupManager, driveService);
  }
}
