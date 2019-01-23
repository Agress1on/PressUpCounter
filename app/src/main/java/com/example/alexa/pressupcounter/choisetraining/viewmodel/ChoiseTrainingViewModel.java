package com.example.alexa.pressupcounter.choisetraining.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 20.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ChoiseTrainingViewModel {
    ObservableField<String> getTime();
    void onClickStartCountButton();
}
