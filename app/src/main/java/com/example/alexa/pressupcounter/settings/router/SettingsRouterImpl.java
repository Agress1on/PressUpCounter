package com.example.alexa.pressupcounter.settings.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.ShowToastEvent;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsRouterImpl implements SettingsRouter {

    private LiveData<FragmentEvent> mGoToSetNotificationsEvent;
    private LiveData<ShowToastEvent> mShowToastEvent;

    public SettingsRouterImpl(SettingsFragment fragment) {
        mGoToSetNotificationsEvent = new SingleLiveEvent<>();
        mGoToSetNotificationsEvent.observe(fragment, fragmentEvent -> fragment.goToSetTrainingDay());

        mShowToastEvent = new SingleLiveEvent<>();
        mShowToastEvent.observe(fragment, new Observer<ShowToastEvent>() {
            @Override
            public void onChanged(ShowToastEvent showToastEvent) {
                fragment.showToast();
            }
        });
    }

    @Override
    public void goToSetTrainingDay() {
        ((SingleLiveEvent<FragmentEvent>) mGoToSetNotificationsEvent).postValue(new FragmentEvent());
    }

    @Override
    public void showToast() {
        ((SingleLiveEvent<ShowToastEvent>) mShowToastEvent).postValue(new ShowToastEvent());
    }
}
