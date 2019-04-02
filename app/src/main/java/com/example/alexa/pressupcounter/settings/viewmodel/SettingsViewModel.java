package com.example.alexa.pressupcounter.settings.viewmodel;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface SettingsViewModel {

    ObservableField<String> getTestTextView();

    void onPushButtonClick();
}
