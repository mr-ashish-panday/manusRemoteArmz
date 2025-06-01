package com.remotearmz.commandcenter.backup;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import com.remotearmz.commandcenter.notification.NotificationHelper;
import dagger.internal.DaggerGenerated;
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
public final class BackupWorker_Factory {
  private final Provider<ClientRepository> clientRepositoryProvider;

  private final Provider<LeadRepository> leadRepositoryProvider;

  private final Provider<TargetRepository> targetRepositoryProvider;

  private final Provider<OutreachRepository> outreachRepositoryProvider;

  private final Provider<ActivityLogRepository> activityLogRepositoryProvider;

  private final Provider<DriveService> driveServiceProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public BackupWorker_Factory(Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<TargetRepository> targetRepositoryProvider,
      Provider<OutreachRepository> outreachRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.clientRepositoryProvider = clientRepositoryProvider;
    this.leadRepositoryProvider = leadRepositoryProvider;
    this.targetRepositoryProvider = targetRepositoryProvider;
    this.outreachRepositoryProvider = outreachRepositoryProvider;
    this.activityLogRepositoryProvider = activityLogRepositoryProvider;
    this.driveServiceProvider = driveServiceProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  public BackupWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, clientRepositoryProvider.get(), leadRepositoryProvider.get(), targetRepositoryProvider.get(), outreachRepositoryProvider.get(), activityLogRepositoryProvider.get(), driveServiceProvider.get(), notificationHelperProvider.get());
  }

  public static BackupWorker_Factory create(Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<TargetRepository> targetRepositoryProvider,
      Provider<OutreachRepository> outreachRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider,
      Provider<DriveService> driveServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new BackupWorker_Factory(clientRepositoryProvider, leadRepositoryProvider, targetRepositoryProvider, outreachRepositoryProvider, activityLogRepositoryProvider, driveServiceProvider, notificationHelperProvider);
  }

  public static BackupWorker newInstance(Context context, WorkerParameters params,
      ClientRepository clientRepository, LeadRepository leadRepository,
      TargetRepository targetRepository, OutreachRepository outreachRepository,
      ActivityLogRepository activityLogRepository, DriveService driveService,
      NotificationHelper notificationHelper) {
    return new BackupWorker(context, params, clientRepository, leadRepository, targetRepository, outreachRepository, activityLogRepository, driveService, notificationHelper);
  }
}
