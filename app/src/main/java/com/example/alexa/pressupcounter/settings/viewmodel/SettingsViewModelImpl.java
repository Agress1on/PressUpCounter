package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.settings.interactor.SettingsInteractor;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsViewModelImpl extends ViewModel implements SettingsViewModel {

    private SettingsInteractor mSettingsInteractor;
    private SettingsRouter mSettingsRouter;

    public SettingsViewModelImpl(SettingsInteractor settingsInteractor, SettingsRouter router) {
        mSettingsInteractor = settingsInteractor;
        mSettingsRouter = router;
    }

    @Override
    public void onSetNotificationsClick() {
        mSettingsRouter.goToSetTrainingDay();
    }
}
