package com.example.alexa.pressupcounter.resulttraining.inject;

import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@ResultTrainingScope
@Subcomponent(modules = ResultTrainingModule.class)
public interface ResultTrainingComponent {
    void inject(ResultTrainingFragment resultTrainingFragment);
}
