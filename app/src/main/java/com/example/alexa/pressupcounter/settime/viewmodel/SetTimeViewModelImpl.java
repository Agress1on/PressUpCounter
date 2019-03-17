package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelImpl extends ViewModel implements SetTimeViewModel {

    private SetTimeModel mSetTimeModel;
    private MutableLiveData<FragmentEvent> mFragmentEventLiveData;

    public SetTimeViewModelImpl(SetTimeModel setTimeModel) {
        mSetTimeModel = setTimeModel;
        mFragmentEventLiveData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public void onClickSetTimeButton() {
        mFragmentEventLiveData.postValue(new FragmentEvent());
    }
}
