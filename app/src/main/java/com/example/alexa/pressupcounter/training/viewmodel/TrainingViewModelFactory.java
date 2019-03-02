package com.example.alexa.pressupcounter.training.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.utils.Timer;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final PressUp mPressUp;
    private final Timer mTimer;

    public TrainingViewModelFactory(PressUp pressUp2, Timer timer) {
        super();
        mPressUp = pressUp2;
        mTimer = timer;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingViewModelImpl.class) {
            return (T) new TrainingViewModelImpl(mPressUp, mTimer);
        }
        return null;
    }
}
