package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.starttraining.model.StartTrainingModel;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelImpl extends ViewModel implements StartTrainingViewModel {

    private StartTrainingModel mStartTrainingModel;

    private ObservableField<PressUp2> mPressUpObservableField;
    private MutableLiveData<FragmentEvent> mLiveData;
    private ObservableField<String> mFinalQuantityRepetition;

    private PressUp2 mPressUp2;

    CompositeDisposable mCompositeDisposable;

    public StartTrainingViewModelImpl(StartTrainingModel startTrainingModel) {
        mStartTrainingModel = startTrainingModel;
        mCompositeDisposable = new CompositeDisposable();
        /*
        mStartTrainingModel.getPressUpById(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pressUp2s -> {
                    mPressUp2 = pressUp2s.get(0);
                    mPressUpObservableField = new ObservableField<>(mPressUp2);
                    mFinalQuantityRepetition = new ObservableField<>(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
                });
        */
        mPressUpObservableField = new ObservableField<>(new PressUp2(1, 0,0,0,0,0));
        //не нравится то, что выше
        mFinalQuantityRepetition = new ObservableField<>("0");

        Disposable disposable = mStartTrainingModel.getPressUp2ById(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pressUp2s -> {
                    mPressUp2 = pressUp2s.get(0);
                    mPressUpObservableField.set(mPressUp2);
                    mFinalQuantityRepetition.set(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
                });
        /*
        mPressUpObservableField = new ObservableField<>(mPressUp2);
        mFinalQuantityRepetition = new ObservableField<>(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
        */
        mCompositeDisposable.add(disposable);
        mLiveData = new MutableLiveData<>();
    }

    @Override
    public ObservableField<PressUp2> getPressUp() {
        return mPressUpObservableField;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEvent() {
        return mLiveData;
    }

    @Override
    public ObservableField<String> getFinalQuantityRepetition() {
        return mFinalQuantityRepetition;
    }

    @Override
    public void onClickStartTrainingButton() {
        mLiveData.postValue(new FragmentEvent());
    }
}
