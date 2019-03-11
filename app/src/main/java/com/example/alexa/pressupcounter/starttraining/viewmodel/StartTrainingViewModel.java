package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {

    ObservableField<PressUp> getPressUp();

    LiveData<FragmentEvent> getFragmentEvent();

    void onClickStartTrainingButton();

    ObservableField<String> getFinalQuantityRepetition();
}
