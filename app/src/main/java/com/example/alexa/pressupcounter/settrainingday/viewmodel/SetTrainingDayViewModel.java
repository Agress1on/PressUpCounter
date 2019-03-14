package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTrainingDayViewModel {

    ObservableField<Boolean> getMonday();

    ObservableField<Boolean> getTuesday();

    ObservableField<Boolean> getWednesday();

    ObservableField<Boolean> getThursday();

    ObservableField<Boolean> getFriday();

    ObservableField<Boolean> getSaturday();

    ObservableField<Boolean> getSunday();

    void onCheckedChanged(int i, boolean state);
}
