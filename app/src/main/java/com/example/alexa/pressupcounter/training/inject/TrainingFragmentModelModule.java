package com.example.alexa.pressupcounter.training.inject;

import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.training.model.TrainingFragmentModel;
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
public class TrainingFragmentModelModule {

    private TrainingFragment mFragment;

    public TrainingFragmentModelModule(TrainingFragment fragment) {
        mFragment = fragment;
    }

    @TrainingFragmentModelScope
    @Provides
    TrainingFragmentModel provideTrainingFragmentModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new TrainingFragmentModel(appDatabase, pressUpDao);
    }

    @TrainingFragmentModelScope
    @Provides
    TrainingViewModel provideTrainingViewModel(TrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(TrainingViewModelImpl.class);
    }

    @TrainingFragmentModelScope
    @Provides
    TrainingViewModelFactory provideTrainingViewModelFactory(TrainingFragmentModel model) {
        return new TrainingViewModelFactory(model);
    }
}
