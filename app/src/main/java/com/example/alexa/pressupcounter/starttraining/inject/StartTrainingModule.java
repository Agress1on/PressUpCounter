package com.example.alexa.pressupcounter.starttraining.inject;

import com.example.alexa.pressupcounter.data.ProgramDao;
import com.example.alexa.pressupcounter.starttraining.interactor.StartTrainingInteractor;
import com.example.alexa.pressupcounter.starttraining.router.StartTrainingRouter;
import com.example.alexa.pressupcounter.starttraining.router.StartTrainingRouterImpl;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModel;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelFactory;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelImpl;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class StartTrainingModule {

    @StartTrainingScope
    @Provides
    StartTrainingInteractor provideStartTrainingInteractor(ProgramDao programDao) {
        return new StartTrainingInteractor(programDao);
    }

    @StartTrainingScope
    @Provides
    StartTrainingViewModel provideStartTrainingViewModel(StartTrainingFragment fragment, StartTrainingViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(StartTrainingViewModelImpl.class);
    }

    @StartTrainingScope
    @Provides
    StartTrainingViewModelFactory provideFactory(StartTrainingInteractor interactor, StartTrainingRouter startTrainingRouter) {
        return new StartTrainingViewModelFactory(interactor, startTrainingRouter);
    }

    @Provides
    StartTrainingRouter provideRouter(StartTrainingFragment fragment) {
        return new StartTrainingRouterImpl(fragment);
    }
}
