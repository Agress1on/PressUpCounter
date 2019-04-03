package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.FragmentEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {

    void onCreateView();

    ObservableField<PressUp> getPressUp();

    ObservableField<Integer> getFinalQuantityRepetition();

    LiveData<FragmentEvent> getGoToTrainingFragmentEvent();

    LiveData<FragmentEvent> getGoToListFragmentEvent();

    LiveData<FragmentEvent> getForGoToSettingsFragmentEvent();

    void onClickStartTrainingButton();

    void onClickListButton();

    void onClickSettingsButton();
}
