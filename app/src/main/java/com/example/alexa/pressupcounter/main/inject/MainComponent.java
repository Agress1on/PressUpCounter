package com.example.alexa.pressupcounter.main.inject;

import com.example.alexa.pressupcounter.main.view.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@MainScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
