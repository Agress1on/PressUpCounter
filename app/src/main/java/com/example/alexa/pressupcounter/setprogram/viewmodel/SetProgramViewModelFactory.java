package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.setprogram.interactor.SetProgramInteractor;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 24.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SetProgramInteractor mSetProgramInteractor;

    public SetProgramViewModelFactory(SetProgramInteractor setProgramInteractor) {
        super();
        mSetProgramInteractor = setProgramInteractor;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SetProgramViewModelImpl.class) {
            return (T) new SetProgramViewModelImpl(mSetProgramInteractor);
        }
        return null;
    }
}
