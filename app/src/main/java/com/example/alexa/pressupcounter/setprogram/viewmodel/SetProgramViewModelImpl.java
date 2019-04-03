package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.setprogram.interactor.SetProgramInteractor;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelImpl extends ViewModel implements SetProgramViewModel {

    private SetProgramInteractor mSetProgramInteractor;

    private ObservableField<List<ObservableField<Integer>>> mListOfRepetitions;
    private ObservableField<Integer> mSumOfRepetitions;

    private ObservableField<String> mServiceInfo;

    private LiveData<FragmentEvent> mFragmentEventLiveData;

    CompositeDisposable mCompositeDisposable;

    public SetProgramViewModelImpl(SetProgramInteractor setProgramInteractor) {
        mSetProgramInteractor = setProgramInteractor;
        mListOfRepetitions = new ObservableField<>();
        //
        List<ObservableField<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ObservableField<>(0));
        }
        mListOfRepetitions.set(list);
        //
        mSumOfRepetitions = new ObservableField<>(0);
        mServiceInfo = new ObservableField<>();
        mFragmentEventLiveData = new SingleLiveEvent<>();
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    public void onCreateView() {
        Disposable disposable = mSetProgramInteractor.getInitialRepetitionList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observableFields -> {
                    mListOfRepetitions.set(observableFields);
                    setFinalQuantity();
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public ObservableField<List<ObservableField<Integer>>> getListOfRepetitions() {
        return mListOfRepetitions;
    }

    @Override
    public ObservableField<Integer> getSumOfRepetitions() {
        return mSumOfRepetitions;
    }

    @Override
    public ObservableField<String> getServiceInfo() {
        return mServiceInfo;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEvent() {
        return mFragmentEventLiveData;
    }

    @Override
    public void onIncrementButton() {
        if (mListOfRepetitions.get().get(0).get().equals(mListOfRepetitions.get().get(1).get())) {
            mListOfRepetitions.get().get(1).set(mListOfRepetitions.get().get(1).get() + 1);
            mListOfRepetitions.get().get(4).set(mListOfRepetitions.get().get(4).get() + 1);
        } else {
            mListOfRepetitions.get().get(0).set(mListOfRepetitions.get().get(0).get() + 1);
            mListOfRepetitions.get().get(2).set(mListOfRepetitions.get().get(2).get() + 1);
            mListOfRepetitions.get().get(3).set(mListOfRepetitions.get().get(3).get() + 1);
        }
        setFinalQuantity();
        /*
        if (mFirstRepetition.get().equals(mSecondRepetition.get())) {
            mSecondRepetition.set(mSecondRepetition.get() + 1);
            mFifthRepetition.set(mFifthRepetition.get() + 1);
        } else {
            mFirstRepetition.set(mFirstRepetition.get() + 1);
            mThirdRepetition.set(mThirdRepetition.get() + 1);
            mFourthRepetition.set(mFourthRepetition.get() + 1);
        }
        setFinalQuantity();
        */
    }

    @Override
    public void onDecrementButton() {
        if (mListOfRepetitions.get().get(0).get().equals(mListOfRepetitions.get().get(1).get())) {
            mListOfRepetitions.get().get(0).set(mListOfRepetitions.get().get(0).get() - 1);
            mListOfRepetitions.get().get(2).set(mListOfRepetitions.get().get(2).get() - 1);
            mListOfRepetitions.get().get(3).set(mListOfRepetitions.get().get(3).get() - 1);
        } else {
            mListOfRepetitions.get().get(1).set(mListOfRepetitions.get().get(1).get() - 1);
            mListOfRepetitions.get().get(4).set(mListOfRepetitions.get().get(4).get() - 1);
        }
        setFinalQuantity();
        /*
        if (mFirstRepetition.get().equals(mSecondRepetition.get())) {
            mFirstRepetition.set(mFirstRepetition.get() - 1);
            mThirdRepetition.set(mThirdRepetition.get() - 1);
            mFourthRepetition.set(mFourthRepetition.get() - 1);
        } else {
            mSecondRepetition.set(mSecondRepetition.get() - 1);
            mFifthRepetition.set(mFifthRepetition.get() - 1);
        }
        setFinalQuantity();
        */
    }

    @Override
    public void onClickTrainingButton() {
        PressUp pressUp = new PressUp(1, mListOfRepetitions.get().get(0).get(), mListOfRepetitions.get().get(1).get(),
                mListOfRepetitions.get().get(2).get(), mListOfRepetitions.get().get(3).get(), mListOfRepetitions.get().get(4).get());
        mSetProgramInteractor.insertInDataBase(pressUp)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        ((SingleLiveEvent<FragmentEvent>) mFragmentEventLiveData).postValue(new FragmentEvent());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    @Override
    public void onClickChoiceView() {
        ((SingleLiveEvent<FragmentEvent>) mFragmentEventLiveData).postValue(new FragmentEvent());
    }

    private void setFinalQuantity() {
        mSumOfRepetitions.set(0);
        for (ObservableField<Integer> item : mListOfRepetitions.get()) {
            mSumOfRepetitions.set(mSumOfRepetitions.get() + item.get());
        }
    }
}
