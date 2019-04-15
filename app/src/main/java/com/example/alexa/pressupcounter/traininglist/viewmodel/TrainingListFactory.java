package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.traininglist.interactor.TrainingListInteractor;
import com.example.alexa.pressupcounter.traininglist.router.TrainingListRouter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListFactory extends ViewModelProvider.NewInstanceFactory {

    private final TrainingListInteractor mTrainingListInteractor;
    private final TrainingListRouter mTrainingListRouter;

    public TrainingListFactory(TrainingListInteractor trainingListInteractor, TrainingListRouter trainingListRouter) {
        super();
        mTrainingListInteractor = trainingListInteractor;
        mTrainingListRouter = trainingListRouter;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TrainingListViewModelImpl.class) {
            return (T) new TrainingListViewModelImpl(mTrainingListInteractor, mTrainingListRouter);
        }
        return null;
    }
}
