package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.starttraining.interactor.StartTrainingInteractor;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelImpl extends ViewModel implements StartTrainingViewModel {

    private StartTrainingInteractor mStartTrainingInteractor;

    private ObservableField<PressUp> mPressUpObservableField;
    private ObservableField<Integer> mFinalQuantityRepetition;

    private LiveData<FragmentEvent> mGoToTrainingLiveData;
    private LiveData<FragmentEvent> mGoToListLiveData;
    private LiveData<FragmentEvent> mGoToSettingsLiveData;

    private CompositeDisposable mCompositeDisposable;

    public StartTrainingViewModelImpl(StartTrainingInteractor startTrainingInteractor) {
        mStartTrainingInteractor = startTrainingInteractor;
        mCompositeDisposable = new CompositeDisposable();

        mPressUpObservableField = new ObservableField<>(new PressUp(1, 0, 0, 0, 0, 0));
        mFinalQuantityRepetition = new ObservableField<>(0);

        mGoToTrainingLiveData = new SingleLiveEvent<>();
        mGoToListLiveData = new SingleLiveEvent<>();
        mGoToSettingsLiveData = new SingleLiveEvent<>();
    }

    @Override
    public void onCreateView() {
        Disposable disposablePressUp = mStartTrainingInteractor.getLastProgram()
                .subscribe(pressUp -> mPressUpObservableField.set(pressUp));

        Disposable disposableSum = mStartTrainingInteractor.getSumOfRepetitions()
                .subscribe(integer -> mFinalQuantityRepetition.set(integer));
        mCompositeDisposable.add(disposablePressUp);
        mCompositeDisposable.add(disposableSum);
    }

    @Override
    public ObservableField<PressUp> getPressUp() {
        return mPressUpObservableField;
    }

    @Override
    public ObservableField<Integer> getFinalQuantityRepetition() {
        return mFinalQuantityRepetition;
    }

    @Override
    public LiveData<FragmentEvent> getGoToTrainingFragmentEvent() {
        return mGoToTrainingLiveData;
    }

    @Override
    public LiveData<FragmentEvent> getGoToListFragmentEvent() {
        return mGoToListLiveData;
    }

    @Override
    public LiveData<FragmentEvent> getForGoToSettingsFragmentEvent() {
        return mGoToSettingsLiveData;
    }

    @Override
    public void onClickStartTrainingButton() {
        //mGoToTrainingLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mGoToTrainingLiveData).postValue(new FragmentEvent());
    }

    @Override
    public void onClickListButton() {
        //mGoToListLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mGoToListLiveData).postValue(new FragmentEvent());
    }

    @Override
    public void onClickSettingsButton() {
        //mGoToSettingsLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mGoToSettingsLiveData).postValue(new FragmentEvent());
    }
}
