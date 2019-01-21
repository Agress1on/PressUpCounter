package com.example.alexa.pressupcounter.training.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 20.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {
    ObservableField<String> getTime();
    void onClickStartCountButton();
}
