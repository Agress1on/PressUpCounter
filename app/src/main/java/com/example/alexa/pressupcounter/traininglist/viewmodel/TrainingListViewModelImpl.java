package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.EventForUpdateList;
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

    private List<PressUp> mPressUpList;
    private CompositeDisposable mCompositeDisposable;

    private ObservableField<Boolean> mProgressBarState;

    private SingleLiveEvent<EventForUpdateList> mEventForUpdateList;

    public TrainingListViewModelImpl(TrainingListInteractor trainingListInteractor, TrainingListRouter trainingListRouter) {
        mTrainingListInteractor = trainingListInteractor;
        mTrainingListRouter = trainingListRouter;

        mCompositeDisposable = new CompositeDisposable();
        mPressUpList = new ArrayList<>();
        mProgressBarState = new ObservableField<>(true);

        mEventForUpdateList = new SingleLiveEvent<>();
        Disposable disposable = mTrainingListInteractor.getAllPressUps()
                .subscribe(pressUps -> {
                    mPressUpList = pressUps;
                    mEventForUpdateList.postValue(new EventForUpdateList());
                    mProgressBarState.set(false);
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void setRouter(TrainingListRouter trainingListRouter) {
        mTrainingListRouter = trainingListRouter;
    }

    @Override
    public List<PressUp> getPressUpList() {
        return mPressUpList;
    }

    @Override
    public ObservableField<Boolean> getProgressBarState() {
        return mProgressBarState;
    }

    @Override
    public SingleLiveEvent<EventForUpdateList> getEventForUpdateList() {
        return mEventForUpdateList;
    }

    @Override
    public void onClickHomeView() {
        mTrainingListRouter.goToStartFragment();
    }
}
