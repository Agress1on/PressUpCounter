package com.example.alexa.pressupcounter.app.inject;

import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelComponent;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelModule;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelComponent;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelModule;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModelComponent;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModelModule;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModelComponent;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModelModule;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModelComponent;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModelModule;

import dagger.Component;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    SetProgramModelComponent createSetProgramModelComponent(SetProgramModelModule setProgramModelModule);

    StartTrainingModelComponent createStartTrainingModelComponent(StartTrainingModelModule startTrainingModelModule);

    TrainingFragmentModelComponent createTrainingFragmentModelComponent(TrainingFragmentModelModule trainingFragmentModelModule);

    TrainingListModelComponent createTrainingListModelComponent(TrainingListModelModule trainingListModelModule);

    SetTrainingDayModelComponent createSetTrainingDayModelComponent(SetTrainingDayModelModule setTrainingDayModelModule);
}
