package com.remotearmz.commandcenter.di;

import android.content.Context;
import com.remotearmz.commandcenter.util.CsvExporter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideCsvExporterFactory implements Factory<CsvExporter> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideCsvExporterFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public CsvExporter get() {
    return provideCsvExporter(contextProvider.get());
  }

  public static AppModule_ProvideCsvExporterFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideCsvExporterFactory(contextProvider);
  }

  public static CsvExporter provideCsvExporter(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCsvExporter(context));
  }
}
