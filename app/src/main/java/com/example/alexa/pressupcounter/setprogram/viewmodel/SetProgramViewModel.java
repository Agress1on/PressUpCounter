package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetProgramViewModel {

    void onCreateView();

    ObservableField<List<ObservableField<Integer>>> getListOfRepetitions();

    ObservableField<Integer> getSumOfRepetitions();

    ObservableField<String> getServiceInfo();

    LiveData<FragmentEvent> getGoToStartFragmentEvent();

    void onIncrementButton();

    void onDecrementButton();

    void onClickTrainingButton();

    void onClickChoiceView();
}
