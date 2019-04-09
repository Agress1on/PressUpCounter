package com.example.alexa.pressupcounter.app.inject;

import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModule;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentScope;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public interface AppModule {

    @ContributesAndroidInjector(modules = TrainingFragmentModule.class)
    @TrainingFragmentScope
    TrainingFragment contributeTrainingFragment();
}
