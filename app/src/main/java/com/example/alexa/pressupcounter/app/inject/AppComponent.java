package com.example.alexa.pressupcounter.app.inject;

import android.app.Application;

import com.example.alexa.pressupcounter.app.App;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {ActivityBuilder.class, FragmentBuilder.class, RoomModule.class,
        AppModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<App> {

    //FirstLaunchComponent createFirstLaunchComponent(FirstLaunchModule firstLaunchModule);

    void inject(App app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
