package com.example.alexa.pressupcounter.setprogram.inject;

import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.setprogram.interactor.SetProgramInteractor;
import com.example.alexa.pressupcounter.setprogram.router.SetProgramRouter;
import com.example.alexa.pressupcounter.setprogram.router.SetProgramRouterImpl;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelFactory;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetProgramModule {

    private SetProgramFragment mFragment;

    public SetProgramModule(SetProgramFragment fragment) {
        mFragment = fragment;
    }

    @SetProgramScope
    @Provides
    SetProgramInteractor provideSetProgramModel(PressUpDao pressUpDao) {
        return new SetProgramInteractor(pressUpDao);
    }

    @SetProgramScope
    @Provides
    SetProgramViewModel provideSetTrainingDayViewModel(SetProgramViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(SetProgramViewModelImpl.class);
    }

    @SetProgramScope
    @Provides
    SetProgramViewModelFactory provideFactory(SetProgramInteractor setProgramInteractor, SetProgramRouter router) {
        return new SetProgramViewModelFactory(setProgramInteractor, router);
    }

    @SetProgramScope
    @Provides
    SetProgramRouter provideRouter() {
        return new SetProgramRouterImpl(mFragment);
    }
}
