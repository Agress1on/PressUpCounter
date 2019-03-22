package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.TimePickerEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeViewModel {

    MutableLiveData<FragmentEvent> getFragmentEventLiveData();

    MutableLiveData<TimePickerEvent> getTimePickerEventForFirstDay();

    MutableLiveData<TimePickerEvent> getTimePickerEventForSecondDay();

    MutableLiveData<TimePickerEvent> getTimePickerEventForThirdDay();

    ObservableField<String> getFirstDayTime();

    ObservableField<String> getSecondDayTime();

    ObservableField<String> getThirdDayTime();

    ObservableField<String> getTextInfo();

    void setFirstDayTime(int hours, int minutes);

    void setSecondDayTime(int hours, int minutes);

    void setThirdDayTime(int hours, int minutes);

    void onClickSetFirstDayTime();

    void onClickSetSecondDayTime();

    void onClickSetThirdDayTime();

    void onClickSetTimeButton();
}
