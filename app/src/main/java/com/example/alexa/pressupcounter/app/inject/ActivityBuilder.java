package com.example.alexa.pressupcounter.app.inject;

import com.example.alexa.pressupcounter.main.inject.MainModule;
import com.example.alexa.pressupcounter.main.inject.MainScope;
import com.example.alexa.pressupcounter.main.view.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainModule.class)
    @MainScope
    abstract MainActivity contributeMainActivity();
}
