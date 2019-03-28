package com.example.alexa.pressupcounter.starttraining.inject;

import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.starttraining.model.StartTrainingModel;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModel;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelFactory;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class StartTrainingModelModule {

    private StartTrainingFragment mFragment;

    public StartTrainingModelModule(StartTrainingFragment fragment) {
        mFragment = fragment;
    }

    @StartTrainingModelScope
    @Provides
    StartTrainingModel provideStartTrainingModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new StartTrainingModel(appDatabase, pressUpDao);
    }

    @StartTrainingModelScope
    @Provides
    StartTrainingViewModel provideStartTrainingViewModel(StartTrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(StartTrainingViewModelImpl.class);
    }

    @StartTrainingModelScope
    @Provides
    StartTrainingViewModelFactory provideStartTrainingViewModelFactory(StartTrainingModel model) {
        return new StartTrainingViewModelFactory(model);
    }
}
