package com.remotearmz.commandcenter;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWrapper_WorkerFactoryModule;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.remotearmz.commandcenter.auth.GoogleAuthManager;
import com.remotearmz.commandcenter.backup.BackupManager;
import com.remotearmz.commandcenter.backup.DriveService;
import com.remotearmz.commandcenter.data.dao.ActivityLogDao;
import com.remotearmz.commandcenter.data.dao.ClientDao;
import com.remotearmz.commandcenter.data.dao.LeadDao;
import com.remotearmz.commandcenter.data.dao.OutreachActivityDao;
import com.remotearmz.commandcenter.data.dao.TargetDao;
import com.remotearmz.commandcenter.data.database.RemoteArmzDatabase;
import com.remotearmz.commandcenter.data.repository.ActivityLogRepository;
import com.remotearmz.commandcenter.data.repository.ClientRepository;
import com.remotearmz.commandcenter.data.repository.LeadRepository;
import com.remotearmz.commandcenter.data.repository.OutreachActivityRepository;
import com.remotearmz.commandcenter.data.repository.TargetRepository;
import com.remotearmz.commandcenter.di.AppModule;
import com.remotearmz.commandcenter.di.AppModule_ProvideNotificationHelperFactory;
import com.remotearmz.commandcenter.di.AppModule_ProvideNotificationManagerFactory;
import com.remotearmz.commandcenter.di.AuthModule;
import com.remotearmz.commandcenter.di.AuthModule_ProvideBackupManagerFactory;
import com.remotearmz.commandcenter.di.AuthModule_ProvideDriveServiceFactory;
import com.remotearmz.commandcenter.di.AuthModule_ProvideGoogleAuthManagerFactory;
import com.remotearmz.commandcenter.di.DatabaseModule;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideActivityLogDaoFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideActivityLogRepositoryFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideClientDaoFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideClientRepositoryFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideDatabaseFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideLeadDaoFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideLeadRepositoryFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideOutreachActivityDaoFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideOutreachActivityRepositoryFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideTargetDaoFactory;
import com.remotearmz.commandcenter.di.DatabaseModule_ProvideTargetRepositoryFactory;
import com.remotearmz.commandcenter.di.WorkManagerModule;
import com.remotearmz.commandcenter.notification.NotificationHelper;
import com.remotearmz.commandcenter.notification.NotificationManager;
import com.remotearmz.commandcenter.ui.clients.ClientsViewModel;
import com.remotearmz.commandcenter.ui.clients.ClientsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.remotearmz.commandcenter.ui.leads.LeadViewModel;
import com.remotearmz.commandcenter.ui.leads.LeadViewModel_HiltModules_KeyModule_ProvideFactory;
import com.remotearmz.commandcenter.ui.outreach.OutreachViewModel;
import com.remotearmz.commandcenter.ui.outreach.OutreachViewModel_HiltModules_KeyModule_ProvideFactory;
import com.remotearmz.commandcenter.ui.settings.SettingsViewModel;
import com.remotearmz.commandcenter.ui.settings.SettingsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.remotearmz.commandcenter.ui.targets.TargetViewModel;
import com.remotearmz.commandcenter.ui.targets.TargetViewModel_HiltModules_KeyModule_ProvideFactory;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerRemoteArmzApplication_HiltComponents_SingletonC {
  private DaggerRemoteArmzApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder appModule(AppModule appModule) {
      Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder authModule(AuthModule authModule) {
      Preconditions.checkNotNull(authModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder databaseModule(DatabaseModule databaseModule) {
      Preconditions.checkNotNull(databaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_WorkerFactoryModule(
        HiltWrapper_WorkerFactoryModule hiltWrapper_WorkerFactoryModule) {
      Preconditions.checkNotNull(hiltWrapper_WorkerFactoryModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder workManagerModule(WorkManagerModule workManagerModule) {
      Preconditions.checkNotNull(workManagerModule);
      return this;
    }

    public RemoteArmzApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements RemoteArmzApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements RemoteArmzApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements RemoteArmzApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements RemoteArmzApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements RemoteArmzApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements RemoteArmzApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements RemoteArmzApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public RemoteArmzApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends RemoteArmzApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends RemoteArmzApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends RemoteArmzApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends RemoteArmzApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(ClientsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), LeadViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OutreachViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SettingsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), TargetViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends RemoteArmzApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<ClientsViewModel> clientsViewModelProvider;

    private Provider<LeadViewModel> leadViewModelProvider;

    private Provider<OutreachViewModel> outreachViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private Provider<TargetViewModel> targetViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.clientsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.leadViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.outreachViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.targetViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>of("com.remotearmz.commandcenter.ui.clients.ClientsViewModel", ((Provider) clientsViewModelProvider), "com.remotearmz.commandcenter.ui.leads.LeadViewModel", ((Provider) leadViewModelProvider), "com.remotearmz.commandcenter.ui.outreach.OutreachViewModel", ((Provider) outreachViewModelProvider), "com.remotearmz.commandcenter.ui.settings.SettingsViewModel", ((Provider) settingsViewModelProvider), "com.remotearmz.commandcenter.ui.targets.TargetViewModel", ((Provider) targetViewModelProvider));
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.remotearmz.commandcenter.ui.clients.ClientsViewModel 
          return (T) new ClientsViewModel(singletonCImpl.provideClientRepositoryProvider.get());

          case 1: // com.remotearmz.commandcenter.ui.leads.LeadViewModel 
          return (T) new LeadViewModel(singletonCImpl.provideLeadRepositoryProvider.get(), singletonCImpl.provideActivityLogRepositoryProvider.get());

          case 2: // com.remotearmz.commandcenter.ui.outreach.OutreachViewModel 
          return (T) new OutreachViewModel(singletonCImpl.provideOutreachActivityRepositoryProvider.get(), singletonCImpl.provideClientRepositoryProvider.get(), singletonCImpl.provideLeadRepositoryProvider.get(), singletonCImpl.provideActivityLogRepositoryProvider.get());

          case 3: // com.remotearmz.commandcenter.ui.settings.SettingsViewModel 
          return (T) new SettingsViewModel(singletonCImpl.provideGoogleAuthManagerProvider.get(), singletonCImpl.provideBackupManagerProvider.get(), singletonCImpl.provideDriveServiceProvider.get());

          case 4: // com.remotearmz.commandcenter.ui.targets.TargetViewModel 
          return (T) new TargetViewModel(singletonCImpl.provideTargetRepositoryProvider.get(), singletonCImpl.provideActivityLogRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends RemoteArmzApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends RemoteArmzApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends RemoteArmzApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<NotificationManager> provideNotificationManagerProvider;

    private Provider<DriveService> provideDriveServiceProvider;

    private Provider<NotificationHelper> provideNotificationHelperProvider;

    private Provider<BackupManager> provideBackupManagerProvider;

    private Provider<RemoteArmzDatabase> provideDatabaseProvider;

    private Provider<ClientRepository> provideClientRepositoryProvider;

    private Provider<LeadRepository> provideLeadRepositoryProvider;

    private Provider<ActivityLogRepository> provideActivityLogRepositoryProvider;

    private Provider<OutreachActivityRepository> provideOutreachActivityRepositoryProvider;

    private Provider<GoogleAuthManager> provideGoogleAuthManagerProvider;

    private Provider<TargetRepository> provideTargetRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private ClientDao clientDao() {
      return DatabaseModule_ProvideClientDaoFactory.provideClientDao(provideDatabaseProvider.get());
    }

    private LeadDao leadDao() {
      return DatabaseModule_ProvideLeadDaoFactory.provideLeadDao(provideDatabaseProvider.get());
    }

    private ActivityLogDao activityLogDao() {
      return DatabaseModule_ProvideActivityLogDaoFactory.provideActivityLogDao(provideDatabaseProvider.get());
    }

    private OutreachActivityDao outreachActivityDao() {
      return DatabaseModule_ProvideOutreachActivityDaoFactory.provideOutreachActivityDao(provideDatabaseProvider.get());
    }

    private TargetDao targetDao() {
      return DatabaseModule_ProvideTargetDaoFactory.provideTargetDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideNotificationManagerProvider = DoubleCheck.provider(new SwitchingProvider<NotificationManager>(singletonCImpl, 0));
      this.provideDriveServiceProvider = DoubleCheck.provider(new SwitchingProvider<DriveService>(singletonCImpl, 2));
      this.provideNotificationHelperProvider = DoubleCheck.provider(new SwitchingProvider<NotificationHelper>(singletonCImpl, 3));
      this.provideBackupManagerProvider = DoubleCheck.provider(new SwitchingProvider<BackupManager>(singletonCImpl, 1));
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<RemoteArmzDatabase>(singletonCImpl, 5));
      this.provideClientRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ClientRepository>(singletonCImpl, 4));
      this.provideLeadRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<LeadRepository>(singletonCImpl, 6));
      this.provideActivityLogRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ActivityLogRepository>(singletonCImpl, 7));
      this.provideOutreachActivityRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<OutreachActivityRepository>(singletonCImpl, 8));
      this.provideGoogleAuthManagerProvider = DoubleCheck.provider(new SwitchingProvider<GoogleAuthManager>(singletonCImpl, 9));
      this.provideTargetRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<TargetRepository>(singletonCImpl, 10));
    }

    @Override
    public void injectRemoteArmzApplication(RemoteArmzApplication remoteArmzApplication) {
      injectRemoteArmzApplication2(remoteArmzApplication);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private RemoteArmzApplication injectRemoteArmzApplication2(RemoteArmzApplication instance) {
      RemoteArmzApplication_MembersInjector.injectNotificationManager(instance, provideNotificationManagerProvider.get());
      RemoteArmzApplication_MembersInjector.injectBackupManager(instance, provideBackupManagerProvider.get());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.remotearmz.commandcenter.notification.NotificationManager 
          return (T) AppModule_ProvideNotificationManagerFactory.provideNotificationManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.remotearmz.commandcenter.backup.BackupManager 
          return (T) AuthModule_ProvideBackupManagerFactory.provideBackupManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideDriveServiceProvider.get(), singletonCImpl.provideNotificationHelperProvider.get());

          case 2: // com.remotearmz.commandcenter.backup.DriveService 
          return (T) AuthModule_ProvideDriveServiceFactory.provideDriveService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.remotearmz.commandcenter.notification.NotificationHelper 
          return (T) AppModule_ProvideNotificationHelperFactory.provideNotificationHelper(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.remotearmz.commandcenter.data.repository.ClientRepository 
          return (T) DatabaseModule_ProvideClientRepositoryFactory.provideClientRepository(singletonCImpl.clientDao());

          case 5: // com.remotearmz.commandcenter.data.database.RemoteArmzDatabase 
          return (T) DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.remotearmz.commandcenter.data.repository.LeadRepository 
          return (T) DatabaseModule_ProvideLeadRepositoryFactory.provideLeadRepository(singletonCImpl.leadDao());

          case 7: // com.remotearmz.commandcenter.data.repository.ActivityLogRepository 
          return (T) DatabaseModule_ProvideActivityLogRepositoryFactory.provideActivityLogRepository(singletonCImpl.activityLogDao());

          case 8: // com.remotearmz.commandcenter.data.repository.OutreachActivityRepository 
          return (T) DatabaseModule_ProvideOutreachActivityRepositoryFactory.provideOutreachActivityRepository(singletonCImpl.outreachActivityDao());

          case 9: // com.remotearmz.commandcenter.auth.GoogleAuthManager 
          return (T) AuthModule_ProvideGoogleAuthManagerFactory.provideGoogleAuthManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 10: // com.remotearmz.commandcenter.data.repository.TargetRepository 
          return (T) DatabaseModule_ProvideTargetRepositoryFactory.provideTargetRepository(singletonCImpl.targetDao());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
