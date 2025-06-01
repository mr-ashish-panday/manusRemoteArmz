package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
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
public final class DatabaseModule_ProvideTargetRepositoryFactory implements Factory<TargetRepository> {
  private final Provider<TargetDao> targetDaoProvider;

  public DatabaseModule_ProvideTargetRepositoryFactory(Provider<TargetDao> targetDaoProvider) {
    this.targetDaoProvider = targetDaoProvider;
  }

  @Override
  public TargetRepository get() {
    return provideTargetRepository(targetDaoProvider.get());
  }

  public static DatabaseModule_ProvideTargetRepositoryFactory create(
      Provider<TargetDao> targetDaoProvider) {
    return new DatabaseModule_ProvideTargetRepositoryFactory(targetDaoProvider);
  }

  public static TargetRepository provideTargetRepository(TargetDao targetDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTargetRepository(targetDao));
  }
}
