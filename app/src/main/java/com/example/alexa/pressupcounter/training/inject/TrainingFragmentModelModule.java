package com.example.alexa.pressupcounter.training.inject;

import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.training.model.TrainingFragmentModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class TrainingFragmentModelModule {

    @TrainingFragmentModelScope
    @Provides
    TrainingFragmentModel provideTrainingFragmentModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new TrainingFragmentModel(appDatabase, pressUpDao);
    }
}
