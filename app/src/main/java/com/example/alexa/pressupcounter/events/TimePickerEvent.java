package com.example.alexa.pressupcounter.events;

/**
 * Created by Alexandr Mikhalev on 18.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TimePickerEvent {
    private boolean happened = false;

    public boolean isHappened() {
        return happened;
    }

    public void setHappened(boolean happened) {
        this.happened = happened;
    }
}
