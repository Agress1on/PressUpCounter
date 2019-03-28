package com.example.alexa.pressupcounter.firstlaunch.inject;

import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@FirstLaunchScope
@Subcomponent(modules = FirstLaunchModule.class)
public interface FirstLaunchComponent {
    void inject(FirstLaunchFragment firstLaunchFragment);
}
