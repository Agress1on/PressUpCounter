package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.events.ActivityEvent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchViewModelImpl extends ViewModel implements FirstLaunchViewModel {

    private MutableLiveData<ActivityEvent> mActivityEventMutableLiveData;

    public FirstLaunchViewModelImpl() {
        mActivityEventMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public MutableLiveData<ActivityEvent> getActivityEventMutableLiveData() {
        return mActivityEventMutableLiveData;
    }

    @Override
    public void onClickMissButton() {
        mActivityEventMutableLiveData.postValue(new ActivityEvent());
    }
}
