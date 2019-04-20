package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.ResultTrainingSetTextEvent;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ResultTrainingViewModel {

    void setCurrentRouter(ResultTrainingRouter router);

    //ObservableField<String> getHeaderText();

    //ObservableField<String> getResultText();

    SingleLiveEvent<ResultTrainingSetTextEvent> getSetTextEvent();

    void onClickHomeButton();
}
