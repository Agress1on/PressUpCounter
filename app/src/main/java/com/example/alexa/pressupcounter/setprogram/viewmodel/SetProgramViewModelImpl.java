package com.example.alexa.pressupcounter.setprogram.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelImpl extends ViewModel implements SetProgramViewModel {

    private ObservableField<PressUp> mPressUp;
    private ObservableField<Integer> mSummQuantity;
    private MutableLiveData<FragmentEvent> mLiveData;

    public SetProgramViewModelImpl() {
        mPressUp = new ObservableField<>(new PressUp(2,3,1,1,3));
        mSummQuantity = new ObservableField<>(10);
        mLiveData = new MutableLiveData<>();
    }

    @Override
    public ObservableField<PressUp> getPressUp() {
        return mPressUp;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEvent() {
        return mLiveData;
    }

    @Override
    public void onIncrementButton() {
        if (mPressUp.get().getFirstRepetition() == mPressUp.get().getSecondRepetition()) {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), mPressUp.get().getSecondRepetition() + 1, mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), mPressUp.get().getFifthRepetition() + 1));
        } else {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition() + 1, mPressUp.get().getSecondRepetition(), mPressUp.get().getThirdRepetition() + 1, mPressUp.get().getFourthRepetition() + 1, mPressUp.get().getFifthRepetition()));
        }
        setFinalQuantity();
        /*
        if (listOfRepetition.get(0).get() == listOfRepetition.get(1).get()) {
            increaseRepetition(1);
            increaseRepetition(4);
        } else {
            increaseRepetition(0);
            increaseRepetition(2);
            increaseRepetition(3);
        }
        setFinalQuantity();
        */
    }

    @Override
    public void onDecrementButton() {
        if (mPressUp.get().getFirstRepetition() == mPressUp.get().getSecondRepetition()) {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition() - 1, mPressUp.get().getSecondRepetition(), mPressUp.get().getThirdRepetition() - 1, mPressUp.get().getFourthRepetition() - 1, mPressUp.get().getFifthRepetition()));
        } else {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), mPressUp.get().getSecondRepetition() - 1, mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), mPressUp.get().getFifthRepetition() - 1));
        }
        setFinalQuantity();
        /*
        if (mSummQuantity.get() == 10) return;
        if (listOfRepetition.get(0).get() == listOfRepetition.get(1).get()) {
            decreaseRepetition(0);
            decreaseRepetition(2);
            decreaseRepetition(3);
        } else {
            decreaseRepetition(1);
            decreaseRepetition(4);
        }
        setFinalQuantity();
        */
    }

    @Override
    public ObservableField<Integer> getFinalQuantity() {
        return mSummQuantity;
    }


    @Override
    public void onClickTrainingButton() {
        mLiveData.postValue(new FragmentEvent());
    }

    private void setFinalQuantity() {
        mSummQuantity.set(0);
        mSummQuantity.set(mPressUp.get().getFirstRepetition() + mPressUp.get().getSecondRepetition() + mPressUp.get().getThirdRepetition() + mPressUp.get().getFourthRepetition() + mPressUp.get().getFifthRepetition());
    }
}
