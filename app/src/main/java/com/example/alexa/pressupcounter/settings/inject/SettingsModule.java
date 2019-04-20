package com.example.alexa.pressupcounter.settings.inject;

import com.example.alexa.pressupcounter.data.ProgramDao;
import com.example.alexa.pressupcounter.settings.interactor.SettingsInteractor;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;
import com.example.alexa.pressupcounter.settings.router.SettingsRouterImpl;
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

    @SettingsScope
    @Provides
    SettingsInteractor provideSettingsInteractor(ProgramDao programDao) {
        return new SettingsInteractor(programDao);
    }

    @SettingsScope
    @Provides
    SettingsViewModel provideSettingsViewModel(SettingsFragment fragment, SettingsViewModelFactory settingsViewModelFactory) {
        return ViewModelProviders.of(fragment, settingsViewModelFactory).get(SettingsViewModelImpl.class);
    }

    @SettingsScope
    @Provides
    SettingsViewModelFactory provideFactory(SettingsInteractor settingsInteractor, SettingsRouter router) {
        return new SettingsViewModelFactory(settingsInteractor, router);
    }

    @Provides
    SettingsRouter provideRouter(SettingsFragment fragment) {
        return new SettingsRouterImpl(fragment);
    }
}
