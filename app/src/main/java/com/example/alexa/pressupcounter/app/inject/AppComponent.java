package com.example.alexa.pressupcounter.app.inject;

import android.content.Context;

import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.firstlaunch.inject.FirstLaunchComponent;
import com.example.alexa.pressupcounter.firstlaunch.inject.FirstLaunchModule;
import com.example.alexa.pressupcounter.resulttraining.inject.ResultTrainingComponent;
import com.example.alexa.pressupcounter.resulttraining.inject.ResultTrainingModule;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramComponent;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModule;
import com.example.alexa.pressupcounter.settime.inject.SetTimeComponent;
import com.example.alexa.pressupcounter.settime.inject.SetTimeModule;
import com.example.alexa.pressupcounter.settings.inject.SettingsComponent;
import com.example.alexa.pressupcounter.settings.inject.SettingsModule;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayComponent;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModule;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingComponent;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModule;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListComponent;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {AppModule.class, RoomModule.class, AndroidSupportInjectionModule.class})
public interface AppComponent {

    //FirstLaunchComponent createFirstLaunchComponent(FirstLaunchModule firstLaunchModule);

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }
}
