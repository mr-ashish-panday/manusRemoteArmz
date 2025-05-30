package com.remotearmz.commandcenter.ui.leads;

import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
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
public final class LeadViewModel_Factory implements Factory<LeadViewModel> {
  private final Provider<LeadRepository> leadRepositoryProvider;

  private final Provider<ActivityLogRepository> activityLogRepositoryProvider;

  public LeadViewModel_Factory(Provider<LeadRepository> leadRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    this.leadRepositoryProvider = leadRepositoryProvider;
    this.activityLogRepositoryProvider = activityLogRepositoryProvider;
  }

  @Override
  public LeadViewModel get() {
    return newInstance(leadRepositoryProvider.get(), activityLogRepositoryProvider.get());
  }

  public static LeadViewModel_Factory create(Provider<LeadRepository> leadRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    return new LeadViewModel_Factory(leadRepositoryProvider, activityLogRepositoryProvider);
  }

  public static LeadViewModel newInstance(LeadRepository leadRepository,
      ActivityLogRepository activityLogRepository) {
    return new LeadViewModel(leadRepository, activityLogRepository);
  }
}
