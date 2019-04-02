package com.example.alexa.pressupcounter.settings.inject;

import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.settings.model.SettingsModel;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;
import com.example.alexa.pressupcounter.settings.viewmodel.SettingsViewModel;
import com.example.alexa.pressupcounter.settings.viewmodel.SettingsViewModelFactory;
import com.example.alexa.pressupcounter.settings.viewmodel.SettingsViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 02.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SettingsModule {
    private SettingsFragment mFragment;

    public SettingsModule(SettingsFragment fragment) {
        mFragment = fragment;
    }

    @SettingsScope
    @Provides
    SettingsModel provideSettingsModule(PressUpDao pressUpDao) {
        return new SettingsModel(pressUpDao);
    }

    @SettingsScope
    @Provides
    SettingsViewModel provideSettingsViewModel(SettingsViewModelFactory settingsViewModelFactory) {
        return ViewModelProviders.of(mFragment, settingsViewModelFactory).get(SettingsViewModelImpl.class);
    }

    @SettingsScope
    @Provides
    SettingsViewModelFactory provideFactory(SettingsModel settingsModel) {
        return new SettingsViewModelFactory(settingsModel);
    }
}
