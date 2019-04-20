package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.starttraining.router.StartTrainingRouter;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {

    void onFirstLaunch();

    void setCurrentRouter(StartTrainingRouter startTrainingRouter);

    ObservableField<Program> getProgram();

    ObservableField<Integer> getSumRepetitions();

    void onClickStartTrainingButton();

    void onClickListButton();

    void onClickSettingsButton();
}
