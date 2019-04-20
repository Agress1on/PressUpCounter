package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.events.UpdateListEvent;
import com.example.alexa.pressupcounter.traininglist.interactor.TrainingListInteractor;
import com.example.alexa.pressupcounter.traininglist.router.TrainingListRouter;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListViewModelImpl extends ViewModel implements TrainingListViewModel {

    private TrainingListInteractor mTrainingListInteractor;
    private TrainingListRouter mTrainingListRouter;

    private List<Program> mProgramList;
    private CompositeDisposable mCompositeDisposable;

    private ObservableField<Boolean> mProgressBarState;

    private SingleLiveEvent<UpdateListEvent> mEventForUpdateList;

    public TrainingListViewModelImpl(TrainingListInteractor trainingListInteractor, TrainingListRouter trainingListRouter) {
        mTrainingListInteractor = trainingListInteractor;
        mTrainingListRouter = trainingListRouter;

        mCompositeDisposable = new CompositeDisposable();
        mProgramList = new ArrayList<>();
        mProgressBarState = new ObservableField<>(true);

        mEventForUpdateList = new SingleLiveEvent<>();
        Disposable disposable = mTrainingListInteractor.getAllPressUps()
                .subscribe(pressUps -> {
                    mProgramList = pressUps;
                    mEventForUpdateList.postValue(new UpdateListEvent());
                    mProgressBarState.set(false);
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void setCurrentRouter(TrainingListRouter trainingListRouter) {
        mTrainingListRouter = trainingListRouter;
    }

    @Override
    public List<Program> getProgramList() {
        return mProgramList;
    }

    @Override
    public ObservableField<Boolean> getProgressBarState() {
        return mProgressBarState;
    }

    @Override
    public SingleLiveEvent<UpdateListEvent> getEventForUpdateList() {
        return mEventForUpdateList;
    }

    @Override
    public void onClickHomeView() {
        mTrainingListRouter.goToStartFragment();
    }
}
