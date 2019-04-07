package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.events.TimePickerEvent;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeViewModel {

    ObservableField<List<ObservableField<String>>> getListTime();

    ObservableField<String> getTextInfo();

    void setDayTime(TimePickerEvent.DayNotification dayNotification, int hours, int minutes);

    void onClickSetTime(TimePickerEvent.DayNotification dayNotification);

    void onClickSetTimeButton();
}
