package com.example.alexa.pressupcounter.setprogram.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.setprogram.interactor.SetProgramInteractor;
import com.example.alexa.pressupcounter.setprogram.router.SetProgramRouter;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramViewModelImpl extends ViewModel implements SetProgramViewModel {

    private SetProgramInteractor mSetProgramInteractor;
    private SetProgramRouter mSetProgramRouter;

    private List<ObservableField<Integer>> mListOfRepetitions;
    private ObservableField<Integer> mSumOfRepetitions;

    private CompositeDisposable mCompositeDisposable;

    public SetProgramViewModelImpl(SetProgramInteractor setProgramInteractor, SetProgramRouter setProgramRouter) {
        mSetProgramInteractor = setProgramInteractor;
        mSetProgramRouter = setProgramRouter;

        mListOfRepetitions = new ArrayList<>();
        //
        for (int i = 0; i < Constants.initList.size(); i++) {
            mListOfRepetitions.add(new ObservableField<>(0));
        }
        //
        mSumOfRepetitions = new ObservableField<>(0);
        mCompositeDisposable = new CompositeDisposable();

        Disposable disposable = mSetProgramInteractor.getInitialRepetitionList()
                .subscribe(observableFields -> {
                    for (int i = 0; i < observableFields.size(); i++) {
                        mListOfRepetitions.get(i).set(observableFields.get(i));
                    }
                    setFinalQuantity();
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void setRouter(SetProgramRouter setProgramRouter) {
        mSetProgramRouter = setProgramRouter;
    }

    @Override
    public List<ObservableField<Integer>> getListOfRepetitions() {
        return mListOfRepetitions;
    }

    @Override
    public ObservableField<Integer> getSumOfRepetitions() {
        return mSumOfRepetitions;
    }

    @Override
    public void onIncrementButtonClick() {
        if (mListOfRepetitions.get(0).get().equals(mListOfRepetitions.get(1).get())) {
            mListOfRepetitions.get(1).set(mListOfRepetitions.get(1).get() + 1);
            mListOfRepetitions.get(4).set(mListOfRepetitions.get(4).get() + 1);
        } else {
            mListOfRepetitions.get(0).set(mListOfRepetitions.get(0).get() + 1);
            mListOfRepetitions.get(2).set(mListOfRepetitions.get(2).get() + 1);
            mListOfRepetitions.get(3).set(mListOfRepetitions.get(3).get() + 1);
        }
        setFinalQuantity();
    }

    @Override
    public void onDecrementButtonClick() {
        if (mListOfRepetitions.get(0).get().equals(mListOfRepetitions.get(1).get())) {
            mListOfRepetitions.get(0).set(mListOfRepetitions.get(0).get() - 1);
            mListOfRepetitions.get(2).set(mListOfRepetitions.get(2).get() - 1);
            mListOfRepetitions.get(3).set(mListOfRepetitions.get(3).get() - 1);
        } else {
            mListOfRepetitions.get(1).set(mListOfRepetitions.get(1).get() - 1);
            mListOfRepetitions.get(4).set(mListOfRepetitions.get(4).get() - 1);
        }
        setFinalQuantity();
    }

    @Override
    public void onSetProgramButtonClick() {
        int id = 1;
        int firstRepetition = mListOfRepetitions.get(0).get();
        int secondRepetition = mListOfRepetitions.get(1).get();
        int thirdRepetition = mListOfRepetitions.get(2).get();
        int fourthRepetition = mListOfRepetitions.get(3).get();
        int fifthRepetition = mListOfRepetitions.get(4).get();

        PressUp pressUp = new PressUp(id, firstRepetition, secondRepetition, thirdRepetition,
                fourthRepetition, fifthRepetition);
        mSetProgramInteractor.insertInDataBase(pressUp)
                .subscribe(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {
                        mSetProgramRouter.goToStartTraining();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mSetProgramRouter.showErrorDialog();
                    }
                });
    }

    @Override
    public void onChoiceViewClick() {
        mSetProgramRouter.goToStartTraining();
    }

    private void setFinalQuantity() {
        mSumOfRepetitions.set(0);
        for (ObservableField<Integer> item : mListOfRepetitions) {
            mSumOfRepetitions.set(mSumOfRepetitions.get() + item.get());
        }
    }
}
