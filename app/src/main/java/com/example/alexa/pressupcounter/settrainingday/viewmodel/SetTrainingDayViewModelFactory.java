package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SetTrainingDayModel mSetTrainingDayModel;

    public SetTrainingDayViewModelFactory(SetTrainingDayModel setTrainingDayModel) {
        super();
        mSetTrainingDayModel = setTrainingDayModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SetTrainingDayViewModelImpl.class) {
            return (T) new SetTrainingDayViewModelImpl(mSetTrainingDayModel);
        }
        return null;
    }
}
