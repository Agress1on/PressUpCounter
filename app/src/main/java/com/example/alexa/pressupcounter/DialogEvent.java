package com.example.alexa.pressupcounter;

/**
 * Created by Alexandr Mikhalev on 05.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogEvent {
    private boolean happened = false;

    public boolean isHappened() {
        return happened;
    }

    public void setHappened(boolean happened) {
        this.happened = happened;
    }
}
