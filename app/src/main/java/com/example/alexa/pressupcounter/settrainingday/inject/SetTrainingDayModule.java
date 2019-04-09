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

    @SetTrainingDayScope
    @Provides
    SetTrainingDayInteractor provideSetTrainingDayInteractor() {
        return new SetTrainingDayInteractor();
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModel provideSetTrainingDayViewModel(SetTrainingDayFragment fragment, SetTrainingDayViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(SetTrainingDayViewModelImpl.class);
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayViewModelFactory provideFactory(SetTrainingDayInteractor setTrainingDayInteractor, SetTrainingDayRouter router) {
        return new SetTrainingDayViewModelFactory(setTrainingDayInteractor, router);
    }

    @SetTrainingDayScope
    @Provides
    SetTrainingDayRouter provideRouter(SetTrainingDayFragment fragment) {
        return new SetTrainingDayRouterImpl(fragment);
    }
}
