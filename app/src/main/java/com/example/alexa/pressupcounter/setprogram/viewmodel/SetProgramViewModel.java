package com.example.alexa.pressupcounter.setprogram.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.databinding.ObservableField;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetProgramViewModel {

    ObservableField<Integer> getFinalQuantity();

    ObservableField<PressUp> getPressUp();

    LiveData<FragmentEvent> getFragmentEvent();

    void onIncrementButton();

    void onDecrementButton();

    void onClickTrainingButton();
}
