package com.example.alexa.pressupcounter.starttraining.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingRouterImpl implements StartTrainingRouter {

    private LiveData<FragmentEvent> mGoToTrainingEvent;
    private LiveData<FragmentEvent> mGoToTrainingListEvent;
    private LiveData<FragmentEvent> mGoToSettingsEvent;

    public StartTrainingRouterImpl(StartTrainingFragment fragment) {
        mGoToTrainingEvent = new SingleLiveEvent<>();
        mGoToTrainingEvent.observe(fragment, fragmentEvent -> fragment.goToTraining());

        mGoToTrainingListEvent = new SingleLiveEvent<>();
        mGoToTrainingListEvent.observe(fragment, fragmentEvent -> fragment.goToTrainingList());

        mGoToSettingsEvent = new SingleLiveEvent<>();
        mGoToSettingsEvent.observe(fragment, fragmentEvent -> fragment.goToSettings());
    }


    @Override
    public void goToTraining() {
        ((SingleLiveEvent<FragmentEvent>) mGoToTrainingEvent).postValue(new FragmentEvent());
    }

    @Override
    public void goToTrainingList() {
        ((SingleLiveEvent<FragmentEvent>) mGoToTrainingListEvent).postValue(new FragmentEvent());
    }

    @Override
    public void goToSettings() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSettingsEvent).postValue(new FragmentEvent());
    }
}
