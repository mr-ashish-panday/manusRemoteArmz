package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.LeadDao;
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
public final class DatabaseModule_ProvideLeadDaoFactory implements Factory<LeadDao> {
  private final Provider<RemoteArmzDatabase> databaseProvider;

  public DatabaseModule_ProvideLeadDaoFactory(Provider<RemoteArmzDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public LeadDao get() {
    return provideLeadDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideLeadDaoFactory create(
      Provider<RemoteArmzDatabase> databaseProvider) {
    return new DatabaseModule_ProvideLeadDaoFactory(databaseProvider);
  }

  public static LeadDao provideLeadDao(RemoteArmzDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideLeadDao(database));
  }
}
