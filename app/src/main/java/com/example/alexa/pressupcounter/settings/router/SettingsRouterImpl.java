package com.example.alexa.pressupcounter.settings.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsRouterImpl implements SettingsRouter {

    private LiveData<FragmentEvent> mGoToSetNotificationsEvent;

    public SettingsRouterImpl(SettingsFragment fragment) {
        mGoToSetNotificationsEvent = new SingleLiveEvent<>();
        mGoToSetNotificationsEvent.observe(fragment, fragmentEvent -> fragment.goToSetTrainingDay());
    }

    @Override
    public void goToSetTrainingDay() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSetNotificationsEvent).postValue(new FragmentEvent());
    }
}
