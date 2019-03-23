package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.repository.PressUp;
import com.example.alexa.pressupcounter.starttraining.model.StartTrainingModel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingViewModelImpl extends ViewModel implements StartTrainingViewModel {

    private StartTrainingModel mStartTrainingModel;

    private ObservableField<PressUp> mPressUpObservableField;
    private ObservableField<String> mFinalQuantityRepetition;

    private MutableLiveData<FragmentEvent> mLiveData;
    private MutableLiveData<FragmentEvent> mLiveDataForGoToList;

    private PressUp mPressUp;

    private CompositeDisposable mCompositeDisposable;

    public StartTrainingViewModelImpl(StartTrainingModel startTrainingModel) {
        mStartTrainingModel = startTrainingModel;
        mCompositeDisposable = new CompositeDisposable();
        /*
        mStartTrainingModel.getPressUpById(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pressUp2s -> {
                    mPressUp = pressUp2s.get(0);
                    mPressUpObservableField = new ObservableField<>(mPressUp);
                    mFinalQuantityRepetition = new ObservableField<>(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
                });
        */
        mPressUpObservableField = new ObservableField<>(new PressUp(1, 0,0,0,0,0));
        //не нравится то, что выше
        mFinalQuantityRepetition = new ObservableField<>("0");

        Disposable disposable = mStartTrainingModel.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pressUp2s -> {
                    mPressUp = pressUp2s.get(pressUp2s.size() - 1);
                    mPressUpObservableField.set(mPressUp);
                    mFinalQuantityRepetition.set(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
                });
        /*
        mPressUpObservableField = new ObservableField<>(mPressUp);
        mFinalQuantityRepetition = new ObservableField<>(String.valueOf(mPressUpObservableField.get().getFirstRepetition() + mPressUpObservableField.get().getSecondRepetition() + mPressUpObservableField.get().getThirdRepetition() + mPressUpObservableField.get().getFourthRepetition() + mPressUpObservableField.get().getFifthRepetition()));
        */
        mCompositeDisposable.add(disposable);
        mLiveData = new MutableLiveData<>();
        mLiveDataForGoToList = new MutableLiveData<>();
    }

    @Override
    public ObservableField<PressUp> getPressUp() {
        return mPressUpObservableField;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEvent() {
        return mLiveData;
    }

    @Override
    public MutableLiveData<FragmentEvent> getLiveDataForGoToList() {
        return mLiveDataForGoToList;
    }

    @Override
    public ObservableField<String> getFinalQuantityRepetition() {
        return mFinalQuantityRepetition;
    }

    @Override
    public void onClickStartTrainingButton() {
        mLiveData.postValue(new FragmentEvent());
    }

    @Override
    public void onClickListButton() {
        mLiveDataForGoToList.postValue(new FragmentEvent());
    }
}
