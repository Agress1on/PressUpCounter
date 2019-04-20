package com.example.alexa.pressupcounter.settings.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.ShowToastEvent;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsRouterImpl implements SettingsRouter {

    private SingleLiveEvent<FragmentEvent> mGoToSetNotificationsEvent;
    private SingleLiveEvent<ShowToastEvent> mShowToastEvent;
    private SingleLiveEvent<FragmentEvent> mGoToSetProgram;

    public SettingsRouterImpl(SettingsFragment fragment) {
        mGoToSetNotificationsEvent = new SingleLiveEvent<>();
        mGoToSetNotificationsEvent.observe(fragment, fragmentEvent -> fragment.setSetTrainingDay());

        mShowToastEvent = new SingleLiveEvent<>();
        mShowToastEvent.observe(fragment, showToastEvent -> fragment.showToast());

        mGoToSetProgram = new SingleLiveEvent<>();
        mGoToSetProgram.observe(fragment, fragmentEvent -> fragment.setSetProgram());
    }

    @Override
    public void goToSetTrainingDay() {
        mGoToSetNotificationsEvent.postValue(new FragmentEvent());
    }

    @Override
    public void showToast() {
        mShowToastEvent.postValue(new ShowToastEvent());
    }

    @Override
    public void goToSetProgram() {
        mGoToSetProgram.postValue(new FragmentEvent());
    }
}
