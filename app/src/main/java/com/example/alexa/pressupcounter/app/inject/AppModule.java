package com.example.alexa.pressupcounter.app.inject;

import android.app.Application;
import android.content.Context;

import com.example.alexa.pressupcounter.preferences.Preferences;
import com.example.alexa.pressupcounter.preferences.PreferencesImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 12.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class AppModule {

    @Provides
    @AppScope
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @AppScope
    Preferences providePreferences(Context context) {
        return new PreferencesImpl(context);
    }
}
