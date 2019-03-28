package com.example.alexa.pressupcounter.app.inject;

import android.content.Context;

import com.example.alexa.pressupcounter.firstlaunch.inject.FirstLaunchComponent;
import com.example.alexa.pressupcounter.firstlaunch.inject.FirstLaunchModule;
import com.example.alexa.pressupcounter.resulttraining.inject.ResultTrainingComponent;
import com.example.alexa.pressupcounter.resulttraining.inject.ResultTrainingModule;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelComponent;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelModule;
import com.example.alexa.pressupcounter.settime.inject.SetTimeComponent;
import com.example.alexa.pressupcounter.settime.inject.SetTimeModule;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelComponent;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelModule;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModelComponent;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModelModule;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModelComponent;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModelModule;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModelComponent;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModelModule;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    FirstLaunchComponent createFirstLaunchComponent(FirstLaunchModule firstLaunchModule);

    SetTimeComponent createSetTimeComponent(SetTimeModule setTimeModule);

    SetProgramModelComponent createSetProgramModelComponent(SetProgramModelModule setProgramModelModule);

    StartTrainingModelComponent createStartTrainingModelComponent(StartTrainingModelModule startTrainingModelModule);

    TrainingFragmentModelComponent createTrainingFragmentModelComponent(TrainingFragmentModelModule trainingFragmentModelModule);

    TrainingListModelComponent createTrainingListModelComponent(TrainingListModelModule trainingListModelModule);

    SetTrainingDayModelComponent createSetTrainingDayModelComponent(SetTrainingDayModelModule setTrainingDayModelModule);

    ResultTrainingComponent createResultTrainingComponent(ResultTrainingModule resultTrainingModule);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);

        AppComponent build();
    }
}
