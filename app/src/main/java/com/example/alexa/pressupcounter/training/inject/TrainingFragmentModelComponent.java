package com.example.alexa.pressupcounter.training.inject;

import com.example.alexa.pressupcounter.training.view.TrainingFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@TrainingFragmentModelScope
@Subcomponent(modules = TrainingFragmentModelModule.class)
public interface TrainingFragmentModelComponent {

    void inject(TrainingFragment trainingFragment);
}
