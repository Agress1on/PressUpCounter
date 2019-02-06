package com.example.alexa.pressupcounter.training.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.example.alexa.pressupcounter.DialogEvent;
import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.utils.Timer;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelImpl extends ViewModel implements TrainingViewModel {

    private PressUp mPressUp;
    private Timer mTimer;

    private ObservableField<Integer> mRepetition;
    private ObservableField<Integer> mQuantityOfRepetition;
    private ObservableField<String> mRestTime;
    private ObservableField<Boolean> mStateOfRestButton;

    private MutableLiveData<DialogEvent> mDialogEventMutableLiveData;

    public TrainingViewModelImpl(PressUp pressUp, Timer timer) {
        mPressUp = pressUp;
        mTimer = timer;

        mRepetition = new ObservableField<>(1);
        mQuantityOfRepetition = new ObservableField<>(mPressUp.getFirstRepetition());
        mRestTime = new ObservableField<>("0");

        mStateOfRestButton = new ObservableField<>(true);

        mDialogEventMutableLiveData = new MutableLiveData<>();
    }

    @Override
    public ObservableField<Integer> getRepetition() {
        return mRepetition;
    }

    @Override
    public ObservableField<Integer> getQuantityOfRepetition() {
        return mQuantityOfRepetition;
    }

    @Override
    public ObservableField<String> getRestTime() {
        return mRestTime;
    }

    @Override
    public ObservableField<Boolean> getStateOfRestButton() {
        return mStateOfRestButton;
    }

    @Override
    public MutableLiveData<DialogEvent> getDialogEventMutableLiveData() {
        return mDialogEventMutableLiveData;
    }

    @Override
    public void onClickNegativeButtonDialog() {
        mStateOfRestButton.set(true);
    }

    @Override
    public void onClickNextRepetitionButton() {
        goToNextRepetition();
    }

    @Override
    public void onClickRestButton() {
        mDialogEventMutableLiveData.postValue(new DialogEvent());
        mStateOfRestButton.set(false);

    }

    @Override
    public void onClickPositiveButtonDialog() {
        Observer<Long> observer = new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {
                mRestTime.set("Start");
            }

            @Override
            public void onNext(Long aLong) {
                mRestTime.set(String.valueOf(aLong));
            }

            @Override
            public void onError(Throwable e) {
                mRestTime.set("Error");
            }

            @Override
            public void onComplete() {
                mRestTime.set("Отдых закончен");
                mStateOfRestButton.set(true);
                goToNextRepetition();
            }
        };
        Observable<Long> observable = mTimer.getLongObservable();
        observable.subscribe(observer);
    }

    private void goToNextRepetition() {
        if (mRepetition.get() < 5) {
            mRepetition.set(mRepetition.get() + 1);
        } else {
            mRepetition.set(1);
        }
        switch (mRepetition.get()) {
            case 1:
                mQuantityOfRepetition.set(mPressUp.getFirstRepetition());
                break;
            case 2:
                mQuantityOfRepetition.set(mPressUp.getSecondRepetition());
                break;
            case 3:
                mQuantityOfRepetition.set(mPressUp.getThirdRepetition());
                break;
            case 4:
                mQuantityOfRepetition.set(mPressUp.getFourthRepetition());
                break;
            case 5:
                mQuantityOfRepetition.set(mPressUp.getFifthRepetition());
                break;
        }
    }
}
