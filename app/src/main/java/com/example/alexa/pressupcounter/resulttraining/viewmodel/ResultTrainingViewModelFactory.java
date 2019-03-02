package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

/**
 * Created by Alexandr Mikhalev on 13.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private boolean isSuccess;

    public ResultTrainingViewModelFactory(boolean isSuccess) {
        super();
        this.isSuccess = isSuccess;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ResultTrainingViewModelImpl.class) {
            return (T) new ResultTrainingViewModelImpl(isSuccess);
        }
        return null;
    }
}
