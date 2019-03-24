package com.example.alexa.pressupcounter.traininglist.inject;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.PressUpDao;
import com.example.alexa.pressupcounter.traininglist.model.TrainingListModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class TrainingListModelModule {
    @TrainingListModelScope
    @Provides
    TrainingListModel provideTrainingListModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new TrainingListModel(appDatabase, pressUpDao);
    }
}
