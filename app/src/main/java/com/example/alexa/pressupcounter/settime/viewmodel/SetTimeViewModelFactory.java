package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SetTimeModel mSetTimeModel;

    public SetTimeViewModelFactory(SetTimeModel setTimeModel) {
        super();
        mSetTimeModel = setTimeModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SetTimeViewModelImpl.class) {
            return (T) new SetTimeViewModelImpl(mSetTimeModel);
        }
        return null;
    }
}
