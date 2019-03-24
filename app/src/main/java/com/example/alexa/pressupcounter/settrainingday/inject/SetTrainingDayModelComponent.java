package com.example.alexa.pressupcounter.settrainingday.inject;

import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@SetTrainingDayModelScope
@Subcomponent(modules = SetTrainingDayModelModule.class)
public interface SetTrainingDayModelComponent {

    void inject(SetTrainingDayFragment setTrainingDayFragment);
}
