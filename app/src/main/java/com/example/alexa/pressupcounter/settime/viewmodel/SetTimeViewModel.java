package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeViewModel {

    ObservableField<List<ObservableField<String>>> getListTime();

    ObservableField<String> getTextInfo();

    LiveData<FragmentEvent> getFragmentEventLiveData();

    LiveData<TimePickerEvent> getFirstDayTimePickerEvent();

    LiveData<TimePickerEvent> getSecondDayTimePickerEvent();

    LiveData<TimePickerEvent> getThirdDayTimePickerEvent();

    void setDayTime(TimePickerEvent.DayNotification dayNotification, int hours, int minutes);

    void onClickSetTime(TimePickerEvent.DayNotification dayNotification);

    void onClickSetTimeButton();
}
