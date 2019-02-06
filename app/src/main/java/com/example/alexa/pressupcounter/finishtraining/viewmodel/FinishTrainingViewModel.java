package com.example.alexa.pressupcounter.finishtraining.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface FinishTrainingViewModel {
    ObservableField<String> getHeaderText();
    ObservableField<String> getResultText();
}
