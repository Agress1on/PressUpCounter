package com.example.alexa.pressupcounter.settime.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeRouterImpl implements SetTimeRouter {

    private SingleLiveEvent<FragmentEvent> mGoToStartTrainingEvent;

    private SingleLiveEvent<TimePickerEvent> mTimePickerEventForFirstDay;
    private SingleLiveEvent<TimePickerEvent> mTimePickerEventForSecondDay;
    private SingleLiveEvent<TimePickerEvent> mTimePickerEventForThirdDay;

    public SetTimeRouterImpl(SetTimeFragment fragment) {
        mGoToStartTrainingEvent = new SingleLiveEvent<>();
        mGoToStartTrainingEvent.observe(fragment, fragmentEvent
                -> fragment.goToStartTraining());

        mTimePickerEventForFirstDay = new SingleLiveEvent<>();
        mTimePickerEventForFirstDay.observe(fragment, timePickerEvent
                -> fragment.showTimePickerDialog(TimePickerEvent.DayNotification.FIRST_DAY));

        mTimePickerEventForSecondDay = new SingleLiveEvent<>();
        mTimePickerEventForSecondDay.observe(fragment, timePickerEvent
                -> fragment.showTimePickerDialog(TimePickerEvent.DayNotification.SECOND_DAY));

        mTimePickerEventForThirdDay = new SingleLiveEvent<>();
        mTimePickerEventForThirdDay.observe(fragment, timePickerEvent
                -> fragment.showTimePickerDialog(TimePickerEvent.DayNotification.THIRD_DAY));
    }

    @Override
    public void goStartTraining() {
        mGoToStartTrainingEvent.postValue(new FragmentEvent());
    }

    @Override
    public void showTimePickerForFirstDay() {
        mTimePickerEventForFirstDay
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.FIRST_DAY));
    }

    @Override
    public void showTimePickerForSecondDay() {
        mTimePickerEventForSecondDay
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.SECOND_DAY));
    }

    @Override
    public void showTimePickerForThirdDay() {
        mTimePickerEventForThirdDay
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.THIRD_DAY));
    }
}
