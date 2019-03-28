package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingListViewModel {

    List<PressUp> getPressUpList();

    ObservableField<Boolean> getProgressBarState();
}
