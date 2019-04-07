package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.settings.model.SettingsModel;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsViewModelImpl extends ViewModel implements SettingsViewModel {

    private SettingsModel mSettingsModel;
    private SettingsRouter mSettingsRouter;

    public SettingsViewModelImpl(SettingsModel settingsModel, SettingsRouter router) {
        mSettingsModel = settingsModel;
        mSettingsRouter = router;
    }

    @Override
    public void onSetNotificationsClick() {
        mSettingsRouter.goToSetTrainingDay();
    }
}
