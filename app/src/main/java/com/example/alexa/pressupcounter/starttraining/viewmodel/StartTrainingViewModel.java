package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.data.PressUp;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {

    ObservableField<PressUp> getPressUp();

    ObservableField<String> getFinalQuantityRepetition();

    LiveData<FragmentEvent> getFragmentEvent();

    LiveData<FragmentEvent> getLiveDataForGoToList();

    LiveData<FragmentEvent> getLiveDataForGoToSettings();

    void onClickStartTrainingButton();

    void onClickListButton();

    void onClickSettingsButton();
}
