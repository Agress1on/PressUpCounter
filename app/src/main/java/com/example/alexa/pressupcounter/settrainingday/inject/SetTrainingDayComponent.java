package com.example.alexa.pressupcounter.settrainingday.inject;

import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@SetTrainingDayScope
@Subcomponent(modules = SetTrainingDayModule.class)
public interface SetTrainingDayComponent {

    void inject(SetTrainingDayFragment setTrainingDayFragment);
}
