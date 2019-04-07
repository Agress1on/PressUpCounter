package com.example.alexa.pressupcounter.settrainingday.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayRouterImpl implements SetTrainingDayRouter {

    private LiveData<FragmentEvent> mGoToSetTimeEvent;

    public SetTrainingDayRouterImpl(SetTrainingDayFragment fragment) {
        mGoToSetTimeEvent = new SingleLiveEvent<>();
        mGoToSetTimeEvent.observe(fragment, fragmentEvent -> fragment.goToSetTime());
    }

    @Override
    public void goToSetTime() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSetTimeEvent).postValue(new FragmentEvent());
    }
}
