package com.example.alexa.pressupcounter.settrainingday.inject;

import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetTrainingDayModelModule {
    @Provides
    SetTrainingDayModel provideSetTrainingDayModelModule() {
        return new SetTrainingDayModel();
    }
}
