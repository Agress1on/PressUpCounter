package com.example.alexa.pressupcounter.training.viewmodel;

import com.example.alexa.pressupcounter.training.model.TrainingFragmentModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TrainingFragmentModel mTrainingFragmentModel;

    public TrainingViewModelFactory(TrainingFragmentModel trainingFragmentModel) {
        super();
        mTrainingFragmentModel = trainingFragmentModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingViewModelImpl.class) {
            return (T) new TrainingViewModelImpl(mTrainingFragmentModel);
        }
        return null;
    }
}
