package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.starttraining.interactor.StartTrainingInteractor;
import com.example.alexa.pressupcounter.starttraining.router.StartTrainingRouter;

import androidx.databinding.ObservableField;
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
    private StartTrainingRouter mStartTrainingRouter;

    private ObservableField<PressUp> mPressUpObservableField;
    private ObservableField<Integer> mFinalQuantityRepetition;

    private CompositeDisposable mCompositeDisposable;

    public StartTrainingViewModelImpl(StartTrainingInteractor startTrainingInteractor, StartTrainingRouter startTrainingRouter) {
        mStartTrainingInteractor = startTrainingInteractor;
        mStartTrainingRouter = startTrainingRouter;
        mCompositeDisposable = new CompositeDisposable();

        mPressUpObservableField = new ObservableField<>(new PressUp(1, 0, 0, 0, 0, 0));
        mFinalQuantityRepetition = new ObservableField<>(0);

        Disposable disposablePressUp = mStartTrainingInteractor.getLastProgram()
                .subscribe(pressUp -> mPressUpObservableField.set(pressUp));

        Disposable disposableSum = mStartTrainingInteractor.getSumOfRepetitions()
                .subscribe(integer -> mFinalQuantityRepetition.set(integer));
        mCompositeDisposable.addAll(disposablePressUp, disposableSum);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void setRouter(StartTrainingRouter startTrainingRouter) {
        mStartTrainingRouter = startTrainingRouter;
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
    public void onClickStartTrainingButton() {
        mStartTrainingRouter.goToTraining();
    }

    @Override
    public void onClickListButton() {
        mStartTrainingRouter.goToTrainingList();
    }

    @Override
    public void onClickSettingsButton() {
        mStartTrainingRouter.goToSettings();
    }
}
