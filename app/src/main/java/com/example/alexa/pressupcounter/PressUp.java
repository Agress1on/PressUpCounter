package com.example.alexa.pressupcounter;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PressUp {
    private ObservableField<Integer> mFirstRepetition;
    private ObservableField<Integer> mSecondRepetition;
    private ObservableField<Integer> mThirdRepetition;
    private ObservableField<Integer> mFourthRepetition;
    private ObservableField<Integer> mFifthRepetition;

    public PressUp(ObservableField<Integer> firstRepetition, ObservableField<Integer> secondRepetition, ObservableField<Integer> thirdRepetition, ObservableField<Integer> fourthRepetition, ObservableField<Integer> fifthRepetition) {
        mFirstRepetition = firstRepetition;
        mSecondRepetition = secondRepetition;
        mThirdRepetition = thirdRepetition;
        mFourthRepetition = fourthRepetition;
        mFifthRepetition = fifthRepetition;
    }

    public ObservableField<Integer> getFirstRepetition() {
        return mFirstRepetition;
    }

    public ObservableField<Integer> getSecondRepetition() {
        return mSecondRepetition;
    }

    public ObservableField<Integer> getThirdRepetition() {
        return mThirdRepetition;
    }

    public ObservableField<Integer> getFourthRepetition() {
        return mFourthRepetition;
    }

    public ObservableField<Integer> getFifthRepetition() {
        return mFifthRepetition;
    }
}
