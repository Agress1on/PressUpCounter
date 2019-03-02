package com.example.alexa.pressupcounter.starttraining.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final PressUp mPressUp;

    public StartTrainingViewModelFactory(PressUp pressUp2) {
        super();
        mPressUp = pressUp2;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == StartTrainingViewModelImpl.class) {
            return (T) new StartTrainingViewModelImpl(mPressUp);
        }
        return null;
    }
}
