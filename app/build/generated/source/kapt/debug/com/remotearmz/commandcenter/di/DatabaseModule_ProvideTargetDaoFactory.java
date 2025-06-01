package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.TargetDao;
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
public final class DatabaseModule_ProvideTargetDaoFactory implements Factory<TargetDao> {
  private final Provider<RemoteArmzDatabase> databaseProvider;

  public DatabaseModule_ProvideTargetDaoFactory(Provider<RemoteArmzDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public TargetDao get() {
    return provideTargetDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideTargetDaoFactory create(
      Provider<RemoteArmzDatabase> databaseProvider) {
    return new DatabaseModule_ProvideTargetDaoFactory(databaseProvider);
  }

  public static TargetDao provideTargetDao(RemoteArmzDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTargetDao(database));
  }
}
