package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SettingsViewModel {

    ObservableField<String> getTestTextView();

    LiveData<FragmentEvent> getLiveDataForSetNotifications();

    void onSetNotificationsClick();
}
