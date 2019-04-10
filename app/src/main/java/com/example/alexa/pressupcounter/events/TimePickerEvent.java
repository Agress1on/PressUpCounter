package com.example.alexa.pressupcounter.events;

/**
 * Created by Alexandr Mikhalev on 18.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TimePickerEvent extends AbstractEvent {

    private DayNotification mDayNotification;

    public TimePickerEvent(DayNotification dayNotification) {
        mDayNotification = dayNotification;
    }

    public DayNotification getDayNotification() {
        return mDayNotification;
    }

    public enum DayNotification {
        FIRST_DAY,
        SECOND_DAY,
        THIRD_DAY
    }
}
