package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetProgramViewModel {

    ObservableField<Integer> getFirstRepetition();

    ObservableField<Integer> getSecondRepetition();

    ObservableField<Integer> getThirdRepetition();

    ObservableField<Integer> getFourthRepetition();

    ObservableField<Integer> getFifthRepetition();

    ObservableField<Integer> getSumOfRepetitions();

    ObservableField<String> getServiceInfo();

    LiveData<FragmentEvent> getFragmentEvent();

    void onIncrementButton();

    void onDecrementButton();

    void onClickTrainingButton();

    void onClickChoiceView();
}
