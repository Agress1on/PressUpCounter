package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.starttraining.interactor.StartTrainingInteractor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final StartTrainingInteractor mStartTrainingInteractor;

    public StartTrainingViewModelFactory(StartTrainingInteractor startTrainingInteractor) {
        super();
        mStartTrainingInteractor = startTrainingInteractor;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == StartTrainingViewModelImpl.class) {
            return (T) new StartTrainingViewModelImpl(mStartTrainingInteractor);
        }
        return null;
    }
}
