package com.example.alexa.pressupcounter.settime.router;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SetTimeRouter {

    void goStartTraining();

    void showTimePickerForFirstDay();

    void showTimePickerForSecondDay();

    void showTimePickerForThirdDay();
}
