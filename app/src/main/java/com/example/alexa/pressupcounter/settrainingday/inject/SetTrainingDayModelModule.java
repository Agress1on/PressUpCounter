package com.example.alexa.pressupcounter.settrainingday.inject;

import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModel;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelFactory;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetTrainingDayModelModule {

    private SetTrainingDayFragment mFragment;

    public SetTrainingDayModelModule(SetTrainingDayFragment fragment) {
        mFragment = fragment;
    }

    @SetTrainingDayModelScope
    @Provides
    SetTrainingDayModel provideSetTrainingDayModelModule() {
        return new SetTrainingDayModel();
    }

    @SetTrainingDayModelScope
    @Provides
    SetTrainingDayViewModelFactory provideFactory(SetTrainingDayModel setTrainingDayModel) {
        return new SetTrainingDayViewModelFactory(setTrainingDayModel);
    }

    @SetTrainingDayModelScope
    @Provides
    SetTrainingDayViewModel provideSetTrainingDayViewModel(SetTrainingDayViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(SetTrainingDayViewModelImpl.class);
    }
}
