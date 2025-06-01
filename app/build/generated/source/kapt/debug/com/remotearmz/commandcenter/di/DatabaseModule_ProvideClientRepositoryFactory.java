package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
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
public final class DatabaseModule_ProvideClientRepositoryFactory implements Factory<ClientRepository> {
  private final Provider<ClientDao> clientDaoProvider;

  public DatabaseModule_ProvideClientRepositoryFactory(Provider<ClientDao> clientDaoProvider) {
    this.clientDaoProvider = clientDaoProvider;
  }

  @Override
  public ClientRepository get() {
    return provideClientRepository(clientDaoProvider.get());
  }

  public static DatabaseModule_ProvideClientRepositoryFactory create(
      Provider<ClientDao> clientDaoProvider) {
    return new DatabaseModule_ProvideClientRepositoryFactory(clientDaoProvider);
  }

  public static ClientRepository provideClientRepository(ClientDao clientDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideClientRepository(clientDao));
  }
}
