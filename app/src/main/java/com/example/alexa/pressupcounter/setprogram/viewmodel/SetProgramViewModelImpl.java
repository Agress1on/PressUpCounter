package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.setprogram.model.SetProgramModel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelImpl extends ViewModel implements SetProgramViewModel {

    private SetProgramModel mSetProgramModel;

    private ObservableField<Integer> mFirstRepetition;
    private ObservableField<Integer> mSecondRepetition;
    private ObservableField<Integer> mThirdRepetition;
    private ObservableField<Integer> mFourthRepetition;
    private ObservableField<Integer> mFifthRepetition;

    private ObservableField<Integer> mSumOfRepetitions;

    private ObservableField<String> mServiceInfo;

    private MutableLiveData<FragmentEvent> mLiveData;

    public SetProgramViewModelImpl(SetProgramModel setProgramModel) {
        mSetProgramModel = setProgramModel;

        mFirstRepetition = new ObservableField<>(2);
        mSecondRepetition = new ObservableField<>(3);
        mThirdRepetition = new ObservableField<>(1);
        mFourthRepetition = new ObservableField<>(1);
        mFifthRepetition = new ObservableField<>(3);

        mSumOfRepetitions = new ObservableField<>(10);
        mLiveData = new MutableLiveData<>();

        mServiceInfo = new ObservableField<>();
    }

    public ObservableField<Integer> getFirstRepetition() {
        return mFirstRepetition;
    }

    public ObservableField<Integer> getSecondRepetition() {
        return mSecondRepetition;
    }

    public ObservableField<Integer> getThirdRepetition() {
        return mThirdRepetition;
    }

    public ObservableField<Integer> getFourthRepetition() {
        return mFourthRepetition;
    }

    public ObservableField<Integer> getFifthRepetition() {
        return mFifthRepetition;
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
        return mLiveData;
    }

    @Override
    public void onIncrementButton() {
        if (mFirstRepetition.get().equals(mSecondRepetition.get())) {
            mSecondRepetition.set(mSecondRepetition.get() + 1);
            mFifthRepetition.set(mFifthRepetition.get() + 1);
        } else {
            mFirstRepetition.set(mFirstRepetition.get() + 1);
            mThirdRepetition.set(mThirdRepetition.get() + 1);
            mFourthRepetition.set(mFourthRepetition.get() + 1);
        }
        setFinalQuantity();
        /*
        if (mPressUp.get().getFirstRepetition() == mPressUp.get().getSecondRepetition()) {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), mPressUp.get().getSecondRepetition() + 1, mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), mPressUp.get().getFifthRepetition() + 1));
        } else {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition() + 1, mPressUp.get().getSecondRepetition(), mPressUp.get().getThirdRepetition() + 1, mPressUp.get().getFourthRepetition() + 1, mPressUp.get().getFifthRepetition()));
        }
        setFinalQuantity();
        */
    }

    @Override
    public void onDecrementButton() {
        if (mFirstRepetition.get().equals(mSecondRepetition.get())) {
            mFirstRepetition.set(mFirstRepetition.get() - 1);
            mThirdRepetition.set(mThirdRepetition.get() - 1);
            mFourthRepetition.set(mFourthRepetition.get() - 1);
        } else {
            mSecondRepetition.set(mSecondRepetition.get() - 1);
            mFifthRepetition.set(mFifthRepetition.get() - 1);
        }
        setFinalQuantity();
        /*
        if (mPressUp.get().getFirstRepetition() == mPressUp.get().getSecondRepetition()) {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition() - 1, mPressUp.get().getSecondRepetition(), mPressUp.get().getThirdRepetition() - 1, mPressUp.get().getFourthRepetition() - 1, mPressUp.get().getFifthRepetition()));
        } else {
            mPressUp.set(new PressUp(mPressUp.get().getFirstRepetition(), mPressUp.get().getSecondRepetition() - 1, mPressUp.get().getThirdRepetition(), mPressUp.get().getFourthRepetition(), mPressUp.get().getFifthRepetition() - 1));
        }
        setFinalQuantity();
        */
    }

    @Override
    public void onClickTrainingButton() {
        PressUp2 mPressUp2 = new PressUp2();
        mPressUp2.id = 1;
        mPressUp2.mFirstRepetition = mFirstRepetition.get();
        mPressUp2.mSecondRepetition = mSecondRepetition.get();
        mPressUp2.mThirdRepetition = mThirdRepetition.get();
        mPressUp2.mFourthRepetition = mFourthRepetition.get();
        mPressUp2.mFifthRepetition = mFifthRepetition.get();

        mSetProgramModel.insertInDataBase(mPressUp2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mServiceInfo.set("Началась запись в БД");
                    }

                    @Override
                    public void onComplete() {
                        mLiveData.postValue(new FragmentEvent());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mServiceInfo.set("Возникла ошибка записи в БД");
                    }
                });
    }

    private void setFinalQuantity() {
        mSumOfRepetitions.set(0);
        mSumOfRepetitions.set(mFirstRepetition.get() + mSecondRepetition.get() + mThirdRepetition.get() + mFourthRepetition.get() + mFifthRepetition.get());
    }
}
