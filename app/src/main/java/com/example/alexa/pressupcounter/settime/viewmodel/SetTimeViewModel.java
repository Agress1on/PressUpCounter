package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;

import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeViewModel {
    MutableLiveData<FragmentEvent> getFragmentEventLiveData();
    void onClickSetTimeButton();
}
