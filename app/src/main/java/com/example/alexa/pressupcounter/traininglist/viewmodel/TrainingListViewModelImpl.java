package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.EventForUpdateList;
import com.example.alexa.pressupcounter.traininglist.interactor.TrainingListInteractor;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListViewModelImpl extends ViewModel implements TrainingListViewModel {

    private TrainingListInteractor mTrainingListInteractor;

    private List<PressUp> mPressUpList;
    private CompositeDisposable mCompositeDisposable;

    private ObservableField<Boolean> mProgressBarState;

    private LiveData<EventForUpdateList> mEventForUpdateList;

    public TrainingListViewModelImpl(TrainingListInteractor trainingListInteractor) {
        mTrainingListInteractor = trainingListInteractor;
        mCompositeDisposable = new CompositeDisposable();
        mPressUpList = new ArrayList<>();
        mProgressBarState = new ObservableField<>(true);

        mEventForUpdateList = new SingleLiveEvent<>();
    }

    @Override
    public void onCreateView() {
        Disposable disposable = mTrainingListInteractor.getAllPressUps()
                .subscribe(pressUps -> {
                    mPressUpList = pressUps;
                    ((SingleLiveEvent<EventForUpdateList>) mEventForUpdateList).postValue(new EventForUpdateList());
                    mProgressBarState.set(false);
                });
        mCompositeDisposable.add(disposable);
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
    public LiveData<EventForUpdateList> getEventForUpdateList() {
        return mEventForUpdateList;
    }
}
