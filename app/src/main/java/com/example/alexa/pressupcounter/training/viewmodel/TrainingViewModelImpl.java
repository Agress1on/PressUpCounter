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
    private ObservableField<String> mObservableField;

    public TrainingViewModelImpl(PressUp pressUp) {
        mPressUp = pressUp;
        mObservableField = new ObservableField<>("Подх:" + mPressUp.getFirstRepetition() + " " + mPressUp.getSecondRepetition());
    }

    @Override
    public ObservableField<String> getText() {
        return mObservableField;
    }
}
