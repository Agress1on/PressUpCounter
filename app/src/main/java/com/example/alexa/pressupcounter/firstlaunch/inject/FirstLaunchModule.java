package com.example.alexa.pressupcounter.firstlaunch.inject;

import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;
import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouterImpl;
import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchFragment;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchFactory;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModel;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class FirstLaunchModule {

    @FirstLaunchScope
    @Provides
    FirstLaunchViewModel provideFirstLaunchViewModel(FirstLaunchFragment fragment, FirstLaunchFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(FirstLaunchViewModelImpl.class);
    }

    @FirstLaunchScope
    @Provides
    FirstLaunchFactory provideFactory(FirstLaunchRouter router) {
        return new FirstLaunchFactory(router);
    }

    @FirstLaunchScope
    @Provides
    FirstLaunchRouter provideRouter(FirstLaunchFragment fragment) {
        return new FirstLaunchRouterImpl(fragment);
    }
}
