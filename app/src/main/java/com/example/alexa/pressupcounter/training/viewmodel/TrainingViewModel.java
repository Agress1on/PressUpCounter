package com.example.alexa.pressupcounter.training.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.DialogEvent;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {

    ObservableField<Integer> getRepetition();

    ObservableField<Integer> getQuantityOfRepetition();

    ObservableField<String> getRestTime();

    ObservableField<Boolean> getStateOfRestButton();

    MutableLiveData<DialogEvent> getDialogEventMutableLiveData();

    void onClickPositiveButtonDialog();

    void onClickNegativeButtonDialog();

    void onClickNextRepetitionButton();

    void onClickRestButton();
}
