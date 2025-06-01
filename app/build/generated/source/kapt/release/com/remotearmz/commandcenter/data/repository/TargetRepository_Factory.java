package com.remotearmz.commandcenter.data.repository;

import com.remotearmz.commandcenter.data.dao.TargetDao;
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
public final class TargetRepository_Factory implements Factory<TargetRepository> {
  private final Provider<TargetDao> targetDaoProvider;

  public TargetRepository_Factory(Provider<TargetDao> targetDaoProvider) {
    this.targetDaoProvider = targetDaoProvider;
  }

  @Override
  public TargetRepository get() {
    return newInstance(targetDaoProvider.get());
  }

  public static TargetRepository_Factory create(Provider<TargetDao> targetDaoProvider) {
    return new TargetRepository_Factory(targetDaoProvider);
  }

  public static TargetRepository newInstance(TargetDao targetDao) {
    return new TargetRepository(targetDao);
  }
}
