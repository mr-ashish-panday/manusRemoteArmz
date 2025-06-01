package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
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
public final class DatabaseModule_ProvideLeadRepositoryFactory implements Factory<LeadRepository> {
  private final Provider<LeadDao> leadDaoProvider;

  public DatabaseModule_ProvideLeadRepositoryFactory(Provider<LeadDao> leadDaoProvider) {
    this.leadDaoProvider = leadDaoProvider;
  }

  @Override
  public LeadRepository get() {
    return provideLeadRepository(leadDaoProvider.get());
  }

  public static DatabaseModule_ProvideLeadRepositoryFactory create(
      Provider<LeadDao> leadDaoProvider) {
    return new DatabaseModule_ProvideLeadRepositoryFactory(leadDaoProvider);
  }

  public static LeadRepository provideLeadRepository(LeadDao leadDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideLeadRepository(leadDao));
  }
}
