package com.example.alexa.pressupcounter;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PressUp2 {
    private int mFirstRepetition;
    private int mSecondRepetition;
    private int mThirdRepetition;
    private int mFourthRepetition;
    private int mFifthRepetition;

    public PressUp2(int firstRepetition, int secondRepetition, int thirdRepetition, int fourthRepetition, int fifthRepetition) {
        mFirstRepetition = firstRepetition;
        mSecondRepetition = secondRepetition;
        mThirdRepetition = thirdRepetition;
        mFourthRepetition = fourthRepetition;
        mFifthRepetition = fifthRepetition;
    }

    public int getFirstRepetition() {
        return mFirstRepetition;
    }

    public int getSecondRepetition() {
        return mSecondRepetition;
    }

    public int getThirdRepetition() {
        return mThirdRepetition;
    }

    public int getFourthRepetition() {
        return mFourthRepetition;
    }

    public int getFifthRepetition() {
        return mFifthRepetition;
    }
}
