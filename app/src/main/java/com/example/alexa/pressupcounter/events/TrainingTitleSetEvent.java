package com.example.alexa.pressupcounter.events;

/**
 * Created by Alexandr Mikhalev on 20.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingTitleSetEvent {

    private TitleText mTitleText;

    public TrainingTitleSetEvent(TitleText titleText) {
        mTitleText = titleText;
    }

    public TitleText getTitleText() {
        return mTitleText;
    }

    public enum TitleText {
        TEXT_FOR_TRAINING,
        TEXT_FOR_REST
    }
}
