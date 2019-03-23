package com.example.alexa.pressupcounter.events;

/**
 * Created by Alexandr Mikhalev on 23.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public abstract class AbstractEvent {
    private boolean happened = false;

    public boolean isHappened() {
        return happened;
    }

    public void setHappened(boolean happened) {
        this.happened = happened;
    }
}
