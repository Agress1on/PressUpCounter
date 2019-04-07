package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTrainingDayViewModel {

    ObservableField<List<ObservableField<Boolean>>> getDayOfWeekState();

    ObservableField<Boolean> getCheckButtonState();

    List<Integer> getDaysIndexList();

    void onCheckedChanged(int i, boolean state);

    void onCheckButton();
}
