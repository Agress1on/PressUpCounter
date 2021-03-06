package com.example.alexa.pressupcounter.training.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.TrainingTitleSetEvent;
import com.example.alexa.pressupcounter.training.router.TrainingRouter;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {

    void setRouter(TrainingRouter router);

    ObservableField<Integer> getRepetition();

    ObservableField<String> getCounter();

    //ObservableField<String> getTitle();

    ObservableField<Boolean> getStateOfRestButton();

    SingleLiveEvent<TrainingTitleSetEvent> getTitleSetEvent();

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
