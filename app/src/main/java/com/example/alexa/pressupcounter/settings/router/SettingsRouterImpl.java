package com.example.alexa.pressupcounter.settings.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.ShowToastEvent;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsRouterImpl implements SettingsRouter {

    private LiveData<FragmentEvent> mGoToSetNotificationsEvent;
    private LiveData<ShowToastEvent> mShowToastEvent;
    private LiveData<FragmentEvent> mGoToSetProgram;

    public SettingsRouterImpl(SettingsFragment fragment) {
        mGoToSetNotificationsEvent = new SingleLiveEvent<>();
        mGoToSetNotificationsEvent.observe(fragment, fragmentEvent -> fragment.goToSetTrainingDay());

        mShowToastEvent = new SingleLiveEvent<>();
        mShowToastEvent.observe(fragment, showToastEvent -> fragment.showToast());

        mGoToSetProgram = new SingleLiveEvent<>();
        mGoToSetProgram.observe(fragment, fragmentEvent -> fragment.goToSetProgram());
    }

    @Override
    public void goToSetTrainingDay() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSetNotificationsEvent).postValue(new FragmentEvent());
    }

    @Override
    public void showToast() {
        ((SingleLiveEvent<ShowToastEvent>) mShowToastEvent).postValue(new ShowToastEvent());
    }

    @Override
    public void goToSetProgram() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSetProgram).postValue(new FragmentEvent());
    }
}
