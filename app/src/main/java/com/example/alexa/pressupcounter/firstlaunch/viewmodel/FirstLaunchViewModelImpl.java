package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchViewModelImpl extends ViewModel implements FirstLaunchViewModel {

    private LiveData<FragmentEvent> mActivityEventMutableLiveData;

    public FirstLaunchViewModelImpl() {
        mActivityEventMutableLiveData = new SingleLiveEvent<>();
    }

    @Override
    public LiveData<FragmentEvent> getActivityEventMutableLiveData() {
        return mActivityEventMutableLiveData;
    }

    @Override
    public void onClickMissButton() {
        ((SingleLiveEvent<FragmentEvent>) mActivityEventMutableLiveData).postValue(new FragmentEvent());
    }
}
