package com.example.alexa.pressupcounter.starttraining.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelImpl extends ViewModel implements StartTrainingViewModel {

    private PressUp mPressUp;
    private ObservableField<PressUp> mPressUpObservableField;
    private MutableLiveData<FragmentEvent> mLiveData;
    private ObservableField<String> mFinalQuantityRepetition;

    public StartTrainingViewModelImpl(PressUp pressUp) {
        mPressUp = pressUp;
        mPressUpObservableField = new ObservableField<>(mPressUp);
        mLiveData = new MutableLiveData<>();
        mFinalQuantityRepetition = new ObservableField<>(String.valueOf(mPressUp.getFirstRepetition() + mPressUp.getSecondRepetition() + mPressUp.getThirdRepetition() + mPressUp.getFourthRepetition() + mPressUp.getFifthRepetition()));
    }

    @Override
    public ObservableField<PressUp> getPressUpObservableField() {
        return mPressUpObservableField;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEvent() {
        return mLiveData;
    }

    @Override
    public ObservableField<String> getFinalQuantityRepetition() {
        return mFinalQuantityRepetition;
    }

    @Override
    public void onClickStartTrainingButton() {
        mLiveData.postValue(new FragmentEvent());
    }
}
