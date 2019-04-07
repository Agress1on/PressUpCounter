package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {

    void onCreateView();

    ObservableField<PressUp> getPressUp();

    ObservableField<Integer> getFinalQuantityRepetition();

    void onClickStartTrainingButton();

    void onClickListButton();

    void onClickSettingsButton();
}
