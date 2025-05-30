package com.remotearmz.commandcenter.ui.targets;

import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
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
public final class TargetViewModel_Factory implements Factory<TargetViewModel> {
  private final Provider<TargetRepository> targetRepositoryProvider;

  private final Provider<ActivityLogRepository> activityLogRepositoryProvider;

  public TargetViewModel_Factory(Provider<TargetRepository> targetRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    this.targetRepositoryProvider = targetRepositoryProvider;
    this.activityLogRepositoryProvider = activityLogRepositoryProvider;
  }

  @Override
  public TargetViewModel get() {
    return newInstance(targetRepositoryProvider.get(), activityLogRepositoryProvider.get());
  }

  public static TargetViewModel_Factory create(Provider<TargetRepository> targetRepositoryProvider,
      Provider<ActivityLogRepository> activityLogRepositoryProvider) {
    return new TargetViewModel_Factory(targetRepositoryProvider, activityLogRepositoryProvider);
  }

  public static TargetViewModel newInstance(TargetRepository targetRepository,
      ActivityLogRepository activityLogRepository) {
    return new TargetViewModel(targetRepository, activityLogRepository);
  }
}
