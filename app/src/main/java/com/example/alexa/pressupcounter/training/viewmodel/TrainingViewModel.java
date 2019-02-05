package com.example.alexa.pressupcounter.training.viewmodel;

import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingViewModel {

    ObservableField<Integer> getRepetition();

    ObservableField<Integer> getQuantityOfRepetition();

    ObservableField<String> getRestTime();

    ObservableField<Boolean> getStateOfRestButton();

    void onClickNextRepetitionButton();

    void onClickRestButton();
}
