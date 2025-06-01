package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
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
public final class DatabaseModule_ProvideOutreachActivityDaoFactory implements Factory<OutreachActivityDao> {
  private final Provider<RemoteArmzDatabase> databaseProvider;

  public DatabaseModule_ProvideOutreachActivityDaoFactory(
      Provider<RemoteArmzDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public OutreachActivityDao get() {
    return provideOutreachActivityDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideOutreachActivityDaoFactory create(
      Provider<RemoteArmzDatabase> databaseProvider) {
    return new DatabaseModule_ProvideOutreachActivityDaoFactory(databaseProvider);
  }

  public static OutreachActivityDao provideOutreachActivityDao(RemoteArmzDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideOutreachActivityDao(database));
  }
}
