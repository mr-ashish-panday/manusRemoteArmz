package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.LeadDao;
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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class LeadRepository_Factory implements Factory<LeadRepository> {
  private final Provider<LeadDao> leadDaoProvider;

  public LeadRepository_Factory(Provider<LeadDao> leadDaoProvider) {
    this.leadDaoProvider = leadDaoProvider;
  }

  @Override
  public LeadRepository get() {
    return newInstance(leadDaoProvider.get());
  }

  public static LeadRepository_Factory create(Provider<LeadDao> leadDaoProvider) {
    return new LeadRepository_Factory(leadDaoProvider);
  }

  public static LeadRepository newInstance(LeadDao leadDao) {
    return new LeadRepository(leadDao);
  }
}
