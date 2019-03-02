package com.example.alexa.pressupcounter.setprogram.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.alexa.pressupcounter.setprogram.model.SetProgramModel;

/**
 * Created by Alexandr Mikhalev on 24.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SetProgramModel mSetProgramModel;

    public SetProgramViewModelFactory(SetProgramModel setProgramModel) {
        super();
        mSetProgramModel = setProgramModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SetProgramViewModelImpl.class) {
            return (T) new SetProgramViewModelImpl(mSetProgramModel);
        }
        return null;
    }
}
