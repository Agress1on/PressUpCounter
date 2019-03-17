package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelImpl extends ViewModel implements SetTimeViewModel {

    private SetTimeModel mSetTimeModel;

    public SetTimeViewModelImpl(SetTimeModel setTimeModel) {
        mSetTimeModel = setTimeModel;
    }
}
