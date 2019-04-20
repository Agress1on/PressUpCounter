package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.settings.router.SettingsRouter;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SettingsViewModel {

    void setCurrentRouter(SettingsRouter settingsRouter);

    void onClickSetNotifications();

    void onClickDeleteLastProgram();

    void onClickResetAllProgress();
}
