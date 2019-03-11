package com.example.alexa.pressupcounter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Entity
public class PressUp {

    @PrimaryKey
    private long id;

    private int mFirstRepetition;
    private int mSecondRepetition;
    private int mThirdRepetition;
    private int mFourthRepetition;
    private int mFifthRepetition;

    public PressUp(long id, int firstRepetition, int secondRepetition, int thirdRepetition, int fourthRepetition, int fifthRepetition) {
        this.id = id;
        mFirstRepetition = firstRepetition;
        mSecondRepetition = secondRepetition;
        mThirdRepetition = thirdRepetition;
        mFourthRepetition = fourthRepetition;
        mFifthRepetition = fifthRepetition;
    }

    public long getId() {
        return id;
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
