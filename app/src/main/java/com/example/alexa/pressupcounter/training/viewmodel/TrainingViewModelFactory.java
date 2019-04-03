package com.example.alexa.pressupcounter.training.viewmodel;

import com.example.alexa.pressupcounter.training.interactor.TrainingInteractor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TrainingInteractor mTrainingInteractor;

    public TrainingViewModelFactory(TrainingInteractor trainingInteractor) {
        super();
        mTrainingInteractor = trainingInteractor;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingViewModelImpl.class) {
            return (T) new TrainingViewModelImpl(mTrainingInteractor);
        }
        return null;
    }
}
