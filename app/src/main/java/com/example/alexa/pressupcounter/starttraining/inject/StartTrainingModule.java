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
public class StartTrainingModule {

    private StartTrainingFragment mFragment;

    public StartTrainingModule(StartTrainingFragment fragment) {
        mFragment = fragment;
    }

    @StartTrainingScope
    @Provides
    StartTrainingInteractor provideStartTrainingModel(PressUpDao pressUpDao) {
        return new StartTrainingInteractor(pressUpDao);
    }

    @StartTrainingScope
    @Provides
    StartTrainingViewModel provideStartTrainingViewModel(StartTrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(StartTrainingViewModelImpl.class);
    }

    @StartTrainingScope
    @Provides
    StartTrainingViewModelFactory provideFactory(StartTrainingInteractor model) {
        return new StartTrainingViewModelFactory(model);
    }
}
