package com.example.alexa.pressupcounter.data;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Entity
public class PressUp {

    @PrimaryKey
    private long id;

    /*
    private int mFirstRepetition;
    private int mSecondRepetition;
    private int mThirdRepetition;
    private int mFourthRepetition;
    private int mFifthRepetition;
    */
    @TypeConverters(RepetitionsConverter.class)
    private List<Integer> mRepetitions;

    public PressUp(long id, List<Integer> repetitions) {
        this.id = id;
        mRepetitions = repetitions;
        /*
        mFirstRepetition = firstRepetition;
        mSecondRepetition = secondRepetition;
        mThirdRepetition = thirdRepetition;
        mFourthRepetition = fourthRepetition;
        mFifthRepetition = fifthRepetition;
        */
    }

    public long getId() {
        return id;
    }


    public List<Integer> getRepetitions() {
        return mRepetitions;
    }


    /*
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
    */
}
