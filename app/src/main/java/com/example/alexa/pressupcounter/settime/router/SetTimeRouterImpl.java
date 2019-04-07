package com.example.alexa.pressupcounter.settime.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeRouterImpl implements SetTimeRouter {

    private LiveData<FragmentEvent> mGoToStartTrainingEvent;

    private LiveData<TimePickerEvent> mTimePickerEventForFirstDay;
    private LiveData<TimePickerEvent> mTimePickerEventForSecondDay;
    private LiveData<TimePickerEvent> mTimePickerEventForThirdDay;

    public SetTimeRouterImpl(SetTimeFragment fragment) {
        mGoToStartTrainingEvent = new SingleLiveEvent<>();
        mGoToStartTrainingEvent.observe(fragment, fragmentEvent -> fragment.goToStartTraining());

        mTimePickerEventForFirstDay = new SingleLiveEvent<>();
        mTimePickerEventForFirstDay.observe(fragment, timePickerEvent -> fragment.showTimePickerForFirstDay());

        mTimePickerEventForSecondDay = new SingleLiveEvent<>();
        mTimePickerEventForSecondDay.observe(fragment, timePickerEvent -> fragment.showTimePickerForSecondDay());

        mTimePickerEventForThirdDay = new SingleLiveEvent<>();
        mTimePickerEventForThirdDay.observe(fragment, timePickerEvent -> fragment.showTimePickerForThirdDay());
    }

    @Override
    public void goStartTraining() {
        ((SingleLiveEvent<FragmentEvent>) mGoToStartTrainingEvent).postValue(new FragmentEvent());
    }

    @Override
    public void showTimePickerForFirstDay() {
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForFirstDay)
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.FIRST_DAY));
    }

    @Override
    public void showTimePickerForSecondDay() {
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForSecondDay)
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.SECOND_DAY));
    }

    @Override
    public void showTimePickerForThirdDay() {
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForThirdDay)
                .postValue(new TimePickerEvent(TimePickerEvent.DayNotification.THIRD_DAY));
    }
}
