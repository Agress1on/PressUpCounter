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
public class SetTrainingDayModule {

    private SetTrainingDayFragment mFragment;

    public SetTrainingDayModule(SetTrainingDayFragment fragment) {
        mFragment = fragment;
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayModel provideSetTrainingDayModelModule() {
        return new SetTrainingDayModel();
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModelFactory provideFactory(SetTrainingDayModel setTrainingDayModel) {
        return new SetTrainingDayViewModelFactory(setTrainingDayModel);
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModel provideSetTrainingDayViewModel(SetTrainingDayViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(SetTrainingDayViewModelImpl.class);
    }
}
