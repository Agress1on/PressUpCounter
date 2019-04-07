package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 13.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final boolean isSuccess;
    private final ResultTrainingRouter mRouter;

    public ResultTrainingViewModelFactory(ResultTrainingRouter router, boolean isSuccess) {
        super();
        this.isSuccess = isSuccess;
        mRouter = router;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == ResultTrainingViewModelImpl.class) {
            return (T) new ResultTrainingViewModelImpl(mRouter, isSuccess);
        }
        return null;
    }
}
