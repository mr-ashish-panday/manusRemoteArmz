package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
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
public final class OutreachRepository_Factory implements Factory<OutreachRepository> {
  private final Provider<OutreachActivityDao> outreachActivityDaoProvider;

  public OutreachRepository_Factory(Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    this.outreachActivityDaoProvider = outreachActivityDaoProvider;
  }

  @Override
  public OutreachRepository get() {
    return newInstance(outreachActivityDaoProvider.get());
  }

  public static OutreachRepository_Factory create(
      Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    return new OutreachRepository_Factory(outreachActivityDaoProvider);
  }

  public static OutreachRepository newInstance(OutreachActivityDao outreachActivityDao) {
    return new OutreachRepository(outreachActivityDao);
  }
}
