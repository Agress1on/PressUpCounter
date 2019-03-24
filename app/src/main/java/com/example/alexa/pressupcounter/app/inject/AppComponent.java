package com.example.alexa.pressupcounter.app.inject;

import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelModule;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import dagger.Component;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {SetTrainingDayModelModule.class})
public interface AppComponent {
        void injectsSetTrainingDayFragment(SetTrainingDayFragment setTrainingDayFragment);
}
