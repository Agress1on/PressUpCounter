package com.example.alexa.pressupcounter.starttraining.inject;

import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@StartTrainingScope
@Subcomponent(modules = StartTrainingModule.class)
public interface StartTrainingComponent {

    void inject(StartTrainingFragment startTrainingFragment);
}
