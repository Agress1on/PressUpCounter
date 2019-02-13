package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ResultTrainingViewModel {
    ObservableField<String> getHeaderText();
    ObservableField<String> getResultText();
}
