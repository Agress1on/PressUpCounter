package com.example.alexa.pressupcounter;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Entity
public class PressUp2 {

    @PrimaryKey
    public long id;

    public int mFirstRepetition;
    public int mSecondRepetition;
    public int mThirdRepetition;
    public int mFourthRepetition;
    public int mFifthRepetition;
}
