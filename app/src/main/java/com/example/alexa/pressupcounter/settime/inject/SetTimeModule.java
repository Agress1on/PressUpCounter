package com.example.alexa.pressupcounter.settime.inject;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.settime.interactor.SetTimeInteractor;
import com.example.alexa.pressupcounter.settime.router.SetTimeRouter;
import com.example.alexa.pressupcounter.settime.router.SetTimeRouterImpl;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelFactory;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelImpl;

import java.util.ArrayList;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetTimeModule {

    @SetTimeScope
    @Provides
    SetTimeViewModel provideSetTimeViewModel(SetTimeFragment fragment, SetTimeViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(SetTimeViewModelImpl.class);
    }

    @SetTimeScope
    @Provides
    SetTimeViewModelFactory provideFactory(SetTimeFragment fragment, SetTimeInteractor interactor, SetTimeRouter router) {
        ArrayList<Integer> list = fragment.getArguments().getIntegerArrayList(Constants.KEY_FOR_SET_TIME_BUNDLE);
        return new SetTimeViewModelFactory(interactor, router, list);
    }

    @SetTimeScope
    @Provides
    SetTimeInteractor provideSetTimeInteractor() {
        return new SetTimeInteractor();
    }

    @SetTimeScope
    @Provides
    SetTimeRouter provideRouter(SetTimeFragment fragment) {
        return new SetTimeRouterImpl(fragment);
    }
}
