package com.example.alexa.pressupcounter.firstlaunch.inject;

import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchFragment;
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

    private FirstLaunchFragment mFragment;

    public FirstLaunchModule(FirstLaunchFragment fragment) {
        mFragment = fragment;
    }

    @FirstLaunchScope
    @Provides
    FirstLaunchViewModel provideFirstLaunchViewModel() {
        return ViewModelProviders.of(mFragment).get(FirstLaunchViewModelImpl.class);
    }
}
