package com.example.alexa.pressupcounter.start.viewmodel;

import android.arch.lifecycle.LiveData;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.FragmentEvent;

import java.util.List;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartViewModel {

    List<ObservableField<Integer>> getListOfRepetition();

    ObservableField<Integer> getFinalQuantity();

    LiveData<FragmentEvent> getFragmentEvent();

    void onIncrementButton();

    void onDecrementButton();

    void onClickTrainingButton();
}
