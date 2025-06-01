package com.remotearmz.commandcenter.di;

import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository;
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
public final class DatabaseModule_ProvideOutreachActivityRepositoryFactory implements Factory<OutreachActivityRepository> {
  private final Provider<OutreachActivityDao> outreachActivityDaoProvider;

  public DatabaseModule_ProvideOutreachActivityRepositoryFactory(
      Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    this.outreachActivityDaoProvider = outreachActivityDaoProvider;
  }

  @Override
  public OutreachActivityRepository get() {
    return provideOutreachActivityRepository(outreachActivityDaoProvider.get());
  }

  public static DatabaseModule_ProvideOutreachActivityRepositoryFactory create(
      Provider<OutreachActivityDao> outreachActivityDaoProvider) {
    return new DatabaseModule_ProvideOutreachActivityRepositoryFactory(outreachActivityDaoProvider);
  }

  public static OutreachActivityRepository provideOutreachActivityRepository(
      OutreachActivityDao outreachActivityDao) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideOutreachActivityRepository(outreachActivityDao));
  }
}
