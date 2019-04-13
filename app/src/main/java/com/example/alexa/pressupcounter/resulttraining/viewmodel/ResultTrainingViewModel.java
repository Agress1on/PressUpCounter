package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface ResultTrainingViewModel {

    void setRouter(ResultTrainingRouter router);

    ObservableField<String> getHeaderText();

    ObservableField<String> getResultText();

    void goToStartTrainingFragment();
}
