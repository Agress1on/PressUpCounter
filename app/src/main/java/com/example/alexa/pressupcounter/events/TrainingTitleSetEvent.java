package com.example.alexa.pressupcounter.events;

import com.example.alexa.pressupcounter.R;

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
        TEXT_FOR_TRAINING(R.string.for_training_title_rest),
        TEXT_FOR_REST(R.string.for_training_title_training);

        private int text;

        TitleText(int text) {
            this.text = text;
        }

        public int getText() {
            return text;
        }
    }
}
