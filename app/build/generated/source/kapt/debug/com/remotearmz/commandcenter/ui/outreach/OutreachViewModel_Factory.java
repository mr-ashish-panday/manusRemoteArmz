package com.remotearmz.commandcenter.ui.outreach;

import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository;
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
    "rawtypes"
})
public final class OutreachViewModel_Factory implements Factory<OutreachViewModel> {
  private final Provider<OutreachActivityRepository> outreachActivityRepositoryProvider;

  private final Provider<ClientRepository> clientRepositoryProvider;

  private final Provider<LeadRepository> leadRepositoryProvider;

  private final Provider<ActivityLogRepository> activityLogRepositoryProvider;

  public OutreachViewModel_Factory(
      Provider<OutreachActivityRepository> outreachActivityRepositoryProvider,
      Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    this.outreachActivityRepositoryProvider = outreachActivityRepositoryProvider;
    this.clientRepositoryProvider = clientRepositoryProvider;
    this.leadRepositoryProvider = leadRepositoryProvider;
    this.activityLogRepositoryProvider = activityLogRepositoryProvider;
  }

  @Override
  public OutreachViewModel get() {
    return newInstance(outreachActivityRepositoryProvider.get(), clientRepositoryProvider.get(), leadRepositoryProvider.get(), activityLogRepositoryProvider.get());
  }

  public static OutreachViewModel_Factory create(
      Provider<OutreachActivityRepository> outreachActivityRepositoryProvider,
      Provider<ClientRepository> clientRepositoryProvider,
      Provider<LeadRepository> leadRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    return new OutreachViewModel_Factory(outreachActivityRepositoryProvider, clientRepositoryProvider, leadRepositoryProvider, activityLogRepositoryProvider);
  }

  public static OutreachViewModel newInstance(OutreachActivityRepository outreachActivityRepository,
      ClientRepository clientRepository, LeadRepository leadRepository,
      ActivityLogRepository activityLogRepository) {
    return new OutreachViewModel(outreachActivityRepository, clientRepository, leadRepository, activityLogRepository);
  }
}
