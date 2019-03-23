package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ResultTrainingViewModel {
    ObservableField<String> getHeaderText();
    ObservableField<String> getResultText();
    MutableLiveData<FragmentEvent> getFragmentEvent();
    void goToStartTrainingFragment();
}
