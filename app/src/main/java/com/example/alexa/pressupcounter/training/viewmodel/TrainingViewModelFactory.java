package com.example.alexa.pressupcounter.training.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final PressUp mPressUp;

    public TrainingViewModelFactory(PressUp pressUp2) {
        super();
        mPressUp = pressUp2;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingViewModelImpl.class) {
            return (T) new TrainingViewModelImpl(mPressUp);
        }
        return null;
    }
}