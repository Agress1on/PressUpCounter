package com.example.alexa.pressupcounter.starttraining.viewmodel;

import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartTrainingViewModel {
    ObservableField<PressUp> getPressUpObservableField();
    LiveData<FragmentEvent> getFragmentEvent();
    void onClickStartTrainingButton();
    ObservableField<String> getFinalQuantityRepetition();
}
