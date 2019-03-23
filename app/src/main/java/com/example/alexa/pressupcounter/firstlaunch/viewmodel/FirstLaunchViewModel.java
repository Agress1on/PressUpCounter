package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.events.ActivityEvent;

import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface FirstLaunchViewModel {
    MutableLiveData<ActivityEvent> getActivityEventMutableLiveData();

    void onClickMissButton();
}
