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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class OutreachActivityRepository_Factory implements Factory<OutreachActivityRepository> {
  private final Provider<OutreachActivityDao> outreachActivityDaoProvider;

  public OutreachActivityRepository_Factory(
      Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    this.outreachActivityDaoProvider = outreachActivityDaoProvider;
  }

  @Override
  public OutreachActivityRepository get() {
    return newInstance(outreachActivityDaoProvider.get());
  }

  public static OutreachActivityRepository_Factory create(
      Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    return new OutreachActivityRepository_Factory(outreachActivityDaoProvider);
  }

  public static OutreachActivityRepository newInstance(OutreachActivityDao outreachActivityDao) {
    return new OutreachActivityRepository(outreachActivityDao);
  }
}
