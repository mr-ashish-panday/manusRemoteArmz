package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
    "rawtypes"
})
public final class ActivityLogRepository_Factory implements Factory<ActivityLogRepository> {
  private final Provider<ActivityLogDao> activityLogDaoProvider;

  public ActivityLogRepository_Factory(Provider<ActivityLogDao> activityLogDaoProvider) {
    this.activityLogDaoProvider = activityLogDaoProvider;
  }

  @Override
  public ActivityLogRepository get() {
    return newInstance(activityLogDaoProvider.get());
  }

  public static ActivityLogRepository_Factory create(
      Provider<ActivityLogDao> activityLogDaoProvider) {
    return new ActivityLogRepository_Factory(activityLogDaoProvider);
  }

  public static ActivityLogRepository newInstance(ActivityLogDao activityLogDao) {
    return new ActivityLogRepository(activityLogDao);
  }
}
