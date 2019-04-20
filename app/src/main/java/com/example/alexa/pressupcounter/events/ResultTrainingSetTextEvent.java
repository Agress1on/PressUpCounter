package com.example.alexa.pressupcounter.events;

/**
 * Created by Alexandr Mikhalev on 20.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingSetTextEvent {

    private boolean mResult;

    public ResultTrainingSetTextEvent(boolean result) {
        mResult = result;
    }

    public boolean isResult() {
        return mResult;
    }
}
