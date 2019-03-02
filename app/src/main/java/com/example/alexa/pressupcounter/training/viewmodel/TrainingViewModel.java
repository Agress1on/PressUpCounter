package com.example.alexa.pressupcounter.training.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.databinding.ObservableField;

import com.example.alexa.pressupcounter.DialogEvent;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {

    ObservableField<Integer> getRepetition();

    ObservableField<String> getQuantityOfRepetitionOrRestTime();

    ObservableField<String> getTextForTrainingOrRest();

    ObservableField<Boolean> getStateOfRestButton();

    MutableLiveData<DialogEvent> getDialogEventForRest();

    MutableLiveData<DialogEvent> getDialogEventForRestOff();

    MutableLiveData<DialogEvent> getDialogEventFinishTraining();

    void goToNextRepetition();

    void onClickPositiveButtonOfRestDialog();

    void onClickNegativeButtonOfRestDialog();

    void onClickAdditionalTimeForRest();

    void onClickNextRepetitionButton();

    void onClickRestButton();

    void onClickFinishTrainingButton();
}
