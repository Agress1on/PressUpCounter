package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.ResultTrainingSetTextEvent;
import com.example.alexa.pressupcounter.events.SetResultLogoEvent;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ResultTrainingViewModel {

    void setCurrentRouter(ResultTrainingRouter router);

    void onCreate();

    //ObservableField<String> getHeaderText();

    //ObservableField<String> getResultText();

    SingleLiveEvent<ResultTrainingSetTextEvent> getSetTextEvent();

    SingleLiveEvent<SetResultLogoEvent> getSetResultLogoEvent();

    void onClickHomeButton();
}
