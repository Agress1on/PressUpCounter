package com.example.alexa.pressupcounter.traininglist.inject;

import com.example.alexa.pressupcounter.traininglist.view.TrainingListFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@TrainingListScope
@Subcomponent(modules = TrainingListModule.class)
public interface TrainingListComponent {

    void inject(TrainingListFragment trainingListFragment);
}
