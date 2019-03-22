package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;

import java.util.ArrayList;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

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

    ObservableField<Boolean> getCheckButtonState();

    ArrayList<Integer> getDaysIndexList();

    MutableLiveData<FragmentEvent> getFragmentEventLiveData();

    void onCheckedChanged(int i, boolean state);

    void onCheckButton();
}
