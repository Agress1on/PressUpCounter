package com.example.alexa.pressupcounter.settings.inject;

import com.example.alexa.pressupcounter.settings.view.SettingsFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 02.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@SettingsScope
@Subcomponent(modules = SettingsModule.class)
public interface SettingsComponent {
    void inject(SettingsFragment settingsFragment);
}
