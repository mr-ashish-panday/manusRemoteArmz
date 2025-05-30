package com.remotearmz.commandcenter.notification;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
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
    "rawtypes"
})
public final class NotificationWorker_Factory {
  private final Provider<OutreachRepository> outreachRepositoryProvider;

  private final Provider<ClientRepository> clientRepositoryProvider;

  private final Provider<LeadRepository> leadRepositoryProvider;

  private final Provider<TargetRepository> targetRepositoryProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public NotificationWorker_Factory(Provider<OutreachRepository> outreachRepositoryProvider,
      Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<TargetRepository> targetRepositoryProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.outreachRepositoryProvider = outreachRepositoryProvider;
    this.clientRepositoryProvider = clientRepositoryProvider;
    this.leadRepositoryProvider = leadRepositoryProvider;
    this.targetRepositoryProvider = targetRepositoryProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  public NotificationWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, outreachRepositoryProvider.get(), clientRepositoryProvider.get(), leadRepositoryProvider.get(), targetRepositoryProvider.get(), notificationHelperProvider.get());
  }

  public static NotificationWorker_Factory create(
      Provider<OutreachRepository> outreachRepositoryProvider,
      Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<TargetRepository> targetRepositoryProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new NotificationWorker_Factory(outreachRepositoryProvider, clientRepositoryProvider, leadRepositoryProvider, targetRepositoryProvider, notificationHelperProvider);
  }

  public static NotificationWorker newInstance(Context context, WorkerParameters params,
      OutreachRepository outreachRepository, ClientRepository clientRepository,
      LeadRepository leadRepository, TargetRepository targetRepository,
      NotificationHelper notificationHelper) {
    return new NotificationWorker(context, params, outreachRepository, clientRepository, leadRepository, targetRepository, notificationHelper);
  }
}
