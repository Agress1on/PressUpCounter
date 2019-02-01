package com.example.alexa.pressupcounter.utils;

import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 26.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface DatabaseHelper {
    void addPressUp(PressUp pressUp);

    PressUp getPressUp();
}
