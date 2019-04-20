package com.example.alexa.pressupcounter.starttraining.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.DialogEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingRouterImpl implements StartTrainingRouter {

    private SingleLiveEvent<FragmentEvent> mGoToTrainingEvent;
    private SingleLiveEvent<FragmentEvent> mGoToTrainingListEvent;
    private SingleLiveEvent<FragmentEvent> mGoToSettingsEvent;
    private SingleLiveEvent<DialogEvent> mShowExclamationDialog;

    public StartTrainingRouterImpl(StartTrainingFragment fragment) {
        mGoToTrainingEvent = new SingleLiveEvent<>();
        mGoToTrainingEvent.observe(fragment, fragmentEvent -> fragment.setTraining());

        mGoToTrainingListEvent = new SingleLiveEvent<>();
        mGoToTrainingListEvent.observe(fragment, fragmentEvent -> fragment.setTrainingList());

        mGoToSettingsEvent = new SingleLiveEvent<>();
        mGoToSettingsEvent.observe(fragment, fragmentEvent -> fragment.setSettings());

        mShowExclamationDialog = new SingleLiveEvent<>();
        mShowExclamationDialog.observe(fragment, dialogEvent -> fragment.showExclamationDialog());
    }


    @Override
    public void showExclamationDialog() {
        mShowExclamationDialog.postValue(new DialogEvent());
    }

    @Override
    public void goToTraining() {
        mGoToTrainingEvent.postValue(new FragmentEvent());
    }

    @Override
    public void goToTrainingList() {
        mGoToTrainingListEvent.postValue(new FragmentEvent());
    }

    @Override
    public void goToSettings() {
        mGoToSettingsEvent.postValue(new FragmentEvent());
    }
}
