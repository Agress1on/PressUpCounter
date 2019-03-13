package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayViewModelImpl extends ViewModel implements SetTrainingDayViewModel {

    private SetTrainingDayModel mSetTrainingDayModel;

    public SetTrainingDayViewModelImpl(SetTrainingDayModel setTrainingDayModel) {
        mSetTrainingDayModel = setTrainingDayModel;
    }
}
