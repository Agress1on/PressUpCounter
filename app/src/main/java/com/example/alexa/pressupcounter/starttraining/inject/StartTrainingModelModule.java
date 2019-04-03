package com.example.alexa.pressupcounter.starttraining.inject;

import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.starttraining.interactor.StartTrainingInteractor;
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
    StartTrainingInteractor provideStartTrainingModel(PressUpDao pressUpDao) {
        return new StartTrainingInteractor(pressUpDao);
    }

    @StartTrainingModelScope
    @Provides
    StartTrainingViewModel provideStartTrainingViewModel(StartTrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(StartTrainingViewModelImpl.class);
    }

    @StartTrainingModelScope
    @Provides
    StartTrainingViewModelFactory provideStartTrainingViewModelFactory(StartTrainingInteractor model) {
        return new StartTrainingViewModelFactory(model);
    }
}
