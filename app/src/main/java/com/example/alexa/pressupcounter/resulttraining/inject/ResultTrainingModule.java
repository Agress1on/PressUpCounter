package com.example.alexa.pressupcounter.resulttraining.inject;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouterImpl;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModel;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModelFactory;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModelImpl;

import javax.inject.Named;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class ResultTrainingModule {

    @ResultTrainingScope
    @Provides
    ResultTrainingViewModel provideResultTrainingViewModel(ResultTrainingFragment fragment, ResultTrainingViewModelFactory factory) {
        return ViewModelProviders.of(fragment, factory).get(ResultTrainingViewModelImpl.class);
    }

    @ResultTrainingScope
    @Provides
    ResultTrainingViewModelFactory provideFactory(ResultTrainingRouter router, ResultTrainingFragment fragment) {
        boolean isSuccess = fragment.getArguments().getBoolean(Constants.TAG_FOR_IS_SUCCESS_TRAINING);
        return new ResultTrainingViewModelFactory(router, isSuccess);
    }

    @ResultTrainingScope
    @Provides
    ResultTrainingRouter provideRouter(ResultTrainingFragment fragment) {
        return new ResultTrainingRouterImpl(fragment);
    }
}
