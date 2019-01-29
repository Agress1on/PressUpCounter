package com.example.alexa.pressupcounter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alexandr Mikhalev on 29.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PressUp implements Parcelable {

    private int mFirstRepetition;
    private int mSecondRepetition;
    private int mThirdRepetition;
    private int mFourthRepetition;
    private int mFifthRepetition;

    public PressUp(int firstRepetition, int secondRepetition, int thirdRepetition, int fourthRepetition, int fifthRepetition) {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mFirstRepetition);
        dest.writeInt(mSecondRepetition);
        dest.writeInt(mThirdRepetition);
        dest.writeInt(mFourthRepetition);
        dest.writeInt(mFifthRepetition);
    }

    protected PressUp(Parcel in) {
        mFirstRepetition = in.readInt();
        mSecondRepetition = in.readInt();
        mThirdRepetition = in.readInt();
        mFourthRepetition = in.readInt();
        mFifthRepetition = in.readInt();
    }

    public static final Creator<PressUp> CREATOR = new Creator<PressUp>() {
        @Override
        public PressUp createFromParcel(Parcel in) {
            return new PressUp(in);
        }

        @Override
        public PressUp[] newArray(int size) {
            return new PressUp[size];
        }
    };
}
