package com.example.alexa.pressupcounter.settrainingday.inject;

import com.example.alexa.pressupcounter.settrainingday.interactor.SetTrainingDayInteractor;
import com.example.alexa.pressupcounter.settrainingday.router.SetTrainingDayRouter;
import com.example.alexa.pressupcounter.settrainingday.router.SetTrainingDayRouterImpl;
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
    SetTrainingDayInteractor provideSetTrainingDayInteractor() {
        return new SetTrainingDayInteractor();
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModel provideSetTrainingDayViewModel(SetTrainingDayViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(SetTrainingDayViewModelImpl.class);
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModelFactory provideFactory(SetTrainingDayInteractor setTrainingDayInteractor, SetTrainingDayRouter router) {
        return new SetTrainingDayViewModelFactory(setTrainingDayInteractor, router);
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayRouter provideRouter() {
        return new SetTrainingDayRouterImpl(mFragment);
    }
}
