package com.example.alexa.pressupcounter.starttraining.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.Program;
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

    private ObservableField<Program> mProgram;
    private ObservableField<Integer> mSumRepetitions;

    private CompositeDisposable mCompositeDisposable;

    public StartTrainingViewModelImpl(StartTrainingInteractor startTrainingInteractor, StartTrainingRouter startTrainingRouter) {
        mStartTrainingInteractor = startTrainingInteractor;
        mStartTrainingRouter = startTrainingRouter;
        mCompositeDisposable = new CompositeDisposable();

        mProgram = new ObservableField<>(new Program(1, Constants.initList));
        mSumRepetitions = new ObservableField<>(Constants.INIT_SUM);

        Disposable disposablePressUp = mStartTrainingInteractor.getLastProgram()
                .subscribe(pressUp -> mProgram.set(pressUp));

        Disposable disposableSum = mStartTrainingInteractor.getSumOfRepetitions()
                .subscribe(integer -> mSumRepetitions.set(integer));

        mCompositeDisposable.addAll(disposablePressUp, disposableSum);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void setCurrentRouter(StartTrainingRouter startTrainingRouter) {
        mStartTrainingRouter = startTrainingRouter;
    }

    @Override
    public ObservableField<Program> getProgram() {
        return mProgram;
    }

    @Override
    public ObservableField<Integer> getSumRepetitions() {
        return mSumRepetitions;
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
