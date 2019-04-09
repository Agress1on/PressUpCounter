package com.example.alexa.pressupcounter.traininglist.inject;

import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.traininglist.interactor.TrainingListInteractor;
import com.example.alexa.pressupcounter.traininglist.view.TrainingListFragment;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModel;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModelFactory;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class TrainingListModule {

    @TrainingListScope
    @Provides
    TrainingListInteractor provideTrainingListModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new TrainingListInteractor(appDatabase, pressUpDao);
    }

    @TrainingListScope
    @Provides
    TrainingListViewModel provideTrainingListViewModel(TrainingListFragment fragment, TrainingListViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(TrainingListViewModelImpl.class);
    }

    @TrainingListScope
    @Provides
    TrainingListViewModelFactory provideFactory(TrainingListInteractor model) {
        return new TrainingListViewModelFactory(model);
    }
}
