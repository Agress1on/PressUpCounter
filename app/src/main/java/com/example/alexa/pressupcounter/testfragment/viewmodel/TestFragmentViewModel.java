package com.example.alexa.pressupcounter.testfragment.viewmodel;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TestFragmentViewModel {
    ObservableField<String> getTestTextView();
    void onPushButtonClick();
}
