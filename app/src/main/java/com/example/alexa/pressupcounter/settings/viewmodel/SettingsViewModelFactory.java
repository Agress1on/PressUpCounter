package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.settings.interactor.SettingsInteractor;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SettingsInteractor mSettingsInteractor;
    private final SettingsRouter mSettingsRouter;

    public SettingsViewModelFactory(SettingsInteractor settingsInteractor, SettingsRouter router) {
        super();
        mSettingsInteractor = settingsInteractor;
        mSettingsRouter = router;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SettingsViewModelImpl.class) {
            return (T) new SettingsViewModelImpl(mSettingsInteractor, mSettingsRouter);
        }
        return null;
    }
}
