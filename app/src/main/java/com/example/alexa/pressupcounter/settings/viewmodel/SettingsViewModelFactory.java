package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.settings.model.SettingsModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SettingsModel mSettingsModel;

    public SettingsViewModelFactory(SettingsModel settingsModel) {
        super();
        mSettingsModel = settingsModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SettingsViewModelImpl.class) {
            return (T) new SettingsViewModelImpl(mSettingsModel);
        }
        return null;
    }
}
