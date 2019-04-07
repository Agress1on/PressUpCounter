package com.example.alexa.pressupcounter.training.inject;

import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.training.interactor.TrainingInteractor;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelFactory;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class TrainingFragmentModule {

    private TrainingFragment mFragment;

    public TrainingFragmentModule(TrainingFragment fragment) {
        mFragment = fragment;
    }

    @TrainingFragmentScope
    @Provides
    TrainingInteractor provideTrainingFragmentModel(PressUpDao pressUpDao) {
        return new TrainingInteractor(pressUpDao);
    }

    @TrainingFragmentScope
    @Provides
    TrainingViewModel provideTrainingViewModel(TrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(TrainingViewModelImpl.class);
    }

    @TrainingFragmentScope
    @Provides
    TrainingViewModelFactory provideTrainingViewModelFactory(TrainingInteractor model) {
        return new TrainingViewModelFactory(model);
    }
}