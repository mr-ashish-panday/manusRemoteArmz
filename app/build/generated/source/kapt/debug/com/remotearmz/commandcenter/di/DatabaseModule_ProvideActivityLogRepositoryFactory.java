package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class DatabaseModule_ProvideActivityLogRepositoryFactory implements Factory<ActivityLogRepository> {
  private final Provider<ActivityLogDao> activityLogDaoProvider;

  public DatabaseModule_ProvideActivityLogRepositoryFactory(
      Provider<ActivityLogDao> activityLogDaoProvider) {
    this.activityLogDaoProvider = activityLogDaoProvider;
  }

  @Override
  public ActivityLogRepository get() {
    return provideActivityLogRepository(activityLogDaoProvider.get());
  }

  public static DatabaseModule_ProvideActivityLogRepositoryFactory create(
      Provider<ActivityLogDao> activityLogDaoProvider) {
    return new DatabaseModule_ProvideActivityLogRepositoryFactory(activityLogDaoProvider);
  }

  public static ActivityLogRepository provideActivityLogRepository(ActivityLogDao activityLogDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideActivityLogRepository(activityLogDao));
  }
}
