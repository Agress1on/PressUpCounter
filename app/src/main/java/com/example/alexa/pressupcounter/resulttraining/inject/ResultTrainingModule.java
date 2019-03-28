package com.example.alexa.pressupcounter.resulttraining.inject;

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
    private ResultTrainingFragment mFragment;
    private boolean mResult;

    public ResultTrainingModule(ResultTrainingFragment fragment, boolean result) {
        mFragment = fragment;
        mResult = result;
    }

    @ResultTrainingScope
    @Provides
    ResultTrainingViewModel provideResultTrainingViewModel(ResultTrainingViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(ResultTrainingViewModelImpl.class);
    }

    @ResultTrainingScope
    @Provides
    ResultTrainingViewModelFactory provideFactory() {
        return new ResultTrainingViewModelFactory(mResult);
    }

    @ResultTrainingScope
    @Provides
    @Named("key")
    boolean provideResult() {
        return mResult;
    }
}
