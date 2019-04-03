package com.example.alexa.pressupcounter.training.viewmodel;

import com.example.alexa.pressupcounter.events.DialogEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {

    void onCreateView();

    ObservableField<Integer> getRepetition();

    ObservableField<String> getQuantityOfRepetitionOrRestTime();

    ObservableField<String> getTextForTrainingOrRest();

    ObservableField<Boolean> getStateOfRestButton();

    LiveData<DialogEvent> getRestDialogEvent();

    LiveData<DialogEvent> getRestOffDialogEvent();

    LiveData<DialogEvent> getFinishTrainingDialogEvent();

    void goToNextRepetition();

    void onClickRestButton();

    void onClickFinishTrainingButton();

    void onClickNextRepetitionButton();

    //RestDialog
    void onClickPositiveButtonOfRestDialog();

    void onClickNegativeButtonOfRestDialog();

    void onCancelOfRestDialog();

    //RestOffDialog
    void onClickAdditionalTimeForRest();

    //FinishTrainingDialog
    void onClickPositiveButtonFinishDialog();
}
