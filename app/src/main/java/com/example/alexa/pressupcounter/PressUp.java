package com.example.alexa.pressupcounter;

import android.databinding.ObservableField;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PressUp implements Parcelable {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mFirstRepetition.get());
        dest.writeInt(mSecondRepetition.get());
        dest.writeInt(mThirdRepetition.get());
        dest.writeInt(mFourthRepetition.get());
        dest.writeInt(mFifthRepetition.get());
    }

    protected PressUp(Parcel in) {
        mFirstRepetition = new ObservableField<>(in.readInt());
        mSecondRepetition = new ObservableField<>(in.readInt());
        mThirdRepetition = new ObservableField<>(in.readInt());
        mFourthRepetition = new ObservableField<>(in.readInt());
        mFifthRepetition = new ObservableField<>(in.readInt());
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
