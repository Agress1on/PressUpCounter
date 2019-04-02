package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeViewModel {

    LiveData<FragmentEvent> getFragmentEventLiveData();

    LiveData<TimePickerEvent> getTimePickerEventForFirstDay();

    LiveData<TimePickerEvent> getTimePickerEventForSecondDay();

    LiveData<TimePickerEvent> getTimePickerEventForThirdDay();

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
