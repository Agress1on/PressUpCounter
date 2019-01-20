package com.example.alexa.pressupcounter.start.viewmodel;

import android.databinding.ObservableField;

import java.util.List;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface StartViewModel {

    List<ObservableField<Integer>> getListOfRepetition();

    void onIncrementButton();

    void onDecrementButton();

    ObservableField<Integer> getFinalQuantity();
}
