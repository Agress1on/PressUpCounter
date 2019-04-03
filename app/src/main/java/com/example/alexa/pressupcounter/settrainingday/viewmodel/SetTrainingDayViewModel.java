package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTrainingDayViewModel {

    ObservableField<List<ObservableField<Boolean>>> getDayOfWeekState();

    ObservableField<Boolean> getCheckButtonState();

    List<Integer> getDaysIndexList();

    LiveData<FragmentEvent> getFragmentEventLiveData();

    void onCheckedChanged(int i, boolean state);

    void onCheckButton();
}
