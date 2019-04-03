package com.example.alexa.pressupcounter.training.inject;

import com.example.alexa.pressupcounter.training.view.TrainingFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@TrainingFragmentScope
@Subcomponent(modules = TrainingFragmentModule.class)
public interface TrainingFragmentComponent {

    void inject(TrainingFragment trainingFragment);
}
