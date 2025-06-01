package com.remotearmz.commandcenter.ui.clients;

import com.remotearmz.commandcenter.data.repository.ClientRepository;
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
public final class ClientsViewModel_Factory implements Factory<ClientsViewModel> {
  private final Provider<ClientRepository> clientRepositoryProvider;

  public ClientsViewModel_Factory(Provider<ClientRepository> clientRepositoryProvider) {
    this.clientRepositoryProvider = clientRepositoryProvider;
  }

  @Override
  public ClientsViewModel get() {
    return newInstance(clientRepositoryProvider.get());
  }

  public static ClientsViewModel_Factory create(
      Provider<ClientRepository> clientRepositoryProvider) {
    return new ClientsViewModel_Factory(clientRepositoryProvider);
  }

  public static ClientsViewModel newInstance(ClientRepository clientRepository) {
    return new ClientsViewModel(clientRepository);
  }
}
