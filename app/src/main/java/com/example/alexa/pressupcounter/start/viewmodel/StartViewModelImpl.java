package com.example.alexa.pressupcounter.start.viewmodel;

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
public class StartViewModelImpl extends ViewModel implements StartViewModel {

    private ObservableField<PressUp> mPressUp;
    private ObservableField<Integer> mSummQuantity;
    private MutableLiveData<FragmentEvent> mLiveData;

    public StartViewModelImpl() {
        mPressUp = new ObservableField<>(new PressUp(new ObservableField<Integer>(2), new ObservableField<Integer>(3), new ObservableField<Integer>(1), new ObservableField<Integer>(1), new ObservableField<Integer>(3)));
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
        if (mPressUp.get().getFirstRepetition().get() == mPressUp.get().getSecondRepetition().get()) {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), new ObservableField<Integer>(mPressUp.get().getSecondRepetition().get() + 1), mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), new ObservableField<Integer>(mPressUp.get().getFifthRepetition().get() + 1)));
        } else {
            mPressUp.set(new PressUp(new ObservableField<Integer>(mPressUp.get().getFirstRepetition().get() + 1), mPressUp.get().getSecondRepetition(), new ObservableField<Integer>(mPressUp.get().getThirdRepetition().get() + 1), new ObservableField<Integer>(mPressUp.get().getFourthRepetition().get() + 1), mPressUp.get().getFifthRepetition()));
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
        if (mSummQuantity.get() == 10) return;
        if (mPressUp.get().getFirstRepetition().get() == mPressUp.get().getSecondRepetition().get()) {
            mPressUp.set(new PressUp(new ObservableField<Integer>(mPressUp.get().getFirstRepetition().get() - 1), mPressUp.get().getSecondRepetition(), new ObservableField<Integer>(mPressUp.get().getThirdRepetition().get() - 1), new ObservableField<Integer>(mPressUp.get().getFourthRepetition().get() - 1), mPressUp.get().getFifthRepetition()));
        } else {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), new ObservableField<Integer>(mPressUp.get().getSecondRepetition().get() - 1), mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), new ObservableField<Integer>(mPressUp.get().getFifthRepetition().get() - 1)));
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
        mSummQuantity.set(mPressUp.get().getFirstRepetition().get() + mPressUp.get().getSecondRepetition().get() + mPressUp.get().getThirdRepetition().get() + mPressUp.get().getFourthRepetition().get() + mPressUp.get().getFifthRepetition().get());
    }

    public interface OnTrainingListener {
        void onClick();
    }
}
