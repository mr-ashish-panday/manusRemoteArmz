package com.remotearmz.commandcenter.backup;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DriveService_Factory implements Factory<DriveService> {
  private final Provider<Context> contextProvider;

  public DriveService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DriveService get() {
    return newInstance(contextProvider.get());
  }

  public static DriveService_Factory create(Provider<Context> contextProvider) {
    return new DriveService_Factory(contextProvider);
  }

  public static DriveService newInstance(Context context) {
    return new DriveService(context);
  }
}
