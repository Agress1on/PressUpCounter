package com.example.alexa.pressupcounter.training.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelImpl extends ViewModel implements TrainingViewModel {

    private PressUp mPressUp;

    private ObservableField<Integer> mRepetition;
    private ObservableField<Integer> mQuantityOfRepetition;

    public TrainingViewModelImpl(PressUp pressUp) {
        mPressUp = pressUp;
        mRepetition = new ObservableField<>(1);
        mQuantityOfRepetition = new ObservableField<>(mPressUp.getFirstRepetition());
    }

    @Override
    public ObservableField<Integer> getRepetition() {
        return mRepetition;
    }

    @Override
    public ObservableField<Integer> getQuantityOfRepetition() {
        return mQuantityOfRepetition;
    }

    @Override
    public void onClickRestButton() {
        if (mRepetition.get() < 5) {
            mRepetition.set(mRepetition.get() + 1);
        } else {
            mRepetition.set(1);
        }
        switch (mRepetition.get()) {
            case 1:
                mQuantityOfRepetition.set(mPressUp.getFirstRepetition());
                break;
            case 2:
                mQuantityOfRepetition.set(mPressUp.getSecondRepetition());
                break;
            case 3:
                mQuantityOfRepetition.set(mPressUp.getThirdRepetition());
                break;
            case 4:
                mQuantityOfRepetition.set(mPressUp.getFourthRepetition());
                break;
            case 5:
                mQuantityOfRepetition.set(mPressUp.getFifthRepetition());
                break;
        }
    }
}
