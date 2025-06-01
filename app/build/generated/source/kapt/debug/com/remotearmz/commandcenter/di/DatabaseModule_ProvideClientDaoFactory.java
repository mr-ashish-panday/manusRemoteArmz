package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.ClientDao;
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
public final class DatabaseModule_ProvideClientDaoFactory implements Factory<ClientDao> {
  private final Provider<RemoteArmzDatabase> databaseProvider;

  public DatabaseModule_ProvideClientDaoFactory(Provider<RemoteArmzDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public ClientDao get() {
    return provideClientDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideClientDaoFactory create(
      Provider<RemoteArmzDatabase> databaseProvider) {
    return new DatabaseModule_ProvideClientDaoFactory(databaseProvider);
  }

  public static ClientDao provideClientDao(RemoteArmzDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideClientDao(database));
  }
}
