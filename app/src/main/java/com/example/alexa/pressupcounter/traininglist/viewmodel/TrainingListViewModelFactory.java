package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.traininglist.interactor.TrainingListInteractor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TrainingListInteractor mTrainingListInteractor;

    public TrainingListViewModelFactory(TrainingListInteractor trainingListInteractor) {
        super();
        mTrainingListInteractor = trainingListInteractor;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingListViewModelImpl.class) {
            return (T) new TrainingListViewModelImpl(mTrainingListInteractor);
        }
        return null;
    }
}
