package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.database.RemoteArmzDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideActivityLogDaoFactory implements Factory<ActivityLogDao> {
  private final Provider<RemoteArmzDatabase> databaseProvider;

  public DatabaseModule_ProvideActivityLogDaoFactory(
      Provider<RemoteArmzDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ActivityLogDao get() {
    return provideActivityLogDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideActivityLogDaoFactory create(
      Provider<RemoteArmzDatabase> databaseProvider) {
    return new DatabaseModule_ProvideActivityLogDaoFactory(databaseProvider);
  }

  public static ActivityLogDao provideActivityLogDao(RemoteArmzDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideActivityLogDao(database));
  }
}
