package com.example.alexa.pressupcounter.choisetraining.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.os.CountDownTimer;

/**
 * Created by Alexandr Mikhalev on 20.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ChoiseTrainingViewModelImpl extends ViewModel implements ChoiseTrainingViewModel {

    private ObservableField<String> mTimeCounter;

    public ChoiseTrainingViewModelImpl() {
        mTimeCounter = new ObservableField<>("60");
    }

    @Override
    public ObservableField<String> getTime() {
        return mTimeCounter;
    }

    @Override
    public void onClickStartCountButton() {
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            mTimeCounter.set(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
            mTimeCounter.set("Отдых закончен");
            }
        }.start();
    }
}
