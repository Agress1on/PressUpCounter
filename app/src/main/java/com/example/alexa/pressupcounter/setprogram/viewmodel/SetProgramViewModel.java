package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.setprogram.router.SetProgramRouter;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetProgramViewModel {

    void setCurrentRouter(SetProgramRouter setProgramRouter);

    List<ObservableField<Integer>> getListOfRepetitions();

    ObservableField<Integer> getSumOfRepetitions();

    void onClickIncrementButton();

    void onClickDecrementButton();

    void onClickSetProgramButton();

    void onClickChoiceView();
}
