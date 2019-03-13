package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.traininglist.model.TrainingListModel;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListViewModelImpl extends ViewModel implements TrainingListViewModel {
    private TrainingListModel mTrainingListModel;

    public TrainingListViewModelImpl(TrainingListModel trainingListModel) {
        mTrainingListModel = trainingListModel;
    }
}
