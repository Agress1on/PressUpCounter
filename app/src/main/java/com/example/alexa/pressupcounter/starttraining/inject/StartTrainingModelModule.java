package com.example.alexa.pressupcounter.starttraining.inject;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.PressUpDao;
import com.example.alexa.pressupcounter.starttraining.model.StartTrainingModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class StartTrainingModelModule {

    @StartTrainingModelScope
    @Provides
    StartTrainingModel provideStartTrainingModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new StartTrainingModel(appDatabase, pressUpDao);
    }
}
