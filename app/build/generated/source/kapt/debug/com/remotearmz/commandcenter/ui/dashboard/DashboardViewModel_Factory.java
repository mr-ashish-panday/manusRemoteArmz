package com.remotearmz.commandcenter.ui.dashboard;

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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<LeadRepository> leadRepositoryProvider;

  public DashboardViewModel_Factory(Provider<LeadRepository> leadRepositoryProvider) {
    this.leadRepositoryProvider = leadRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(leadRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(Provider<LeadRepository> leadRepositoryProvider) {
    return new DashboardViewModel_Factory(leadRepositoryProvider);
  }

  public static DashboardViewModel newInstance(LeadRepository leadRepository) {
    return new DashboardViewModel(leadRepository);
  }
}
