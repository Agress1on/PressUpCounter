package com.example.alexa.pressupcounter.training.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.events.TrainingTitleSetEvent;
import com.example.alexa.pressupcounter.training.interactor.TrainingInteractor;
import com.example.alexa.pressupcounter.training.router.TrainingRouter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingViewModelImpl extends ViewModel implements TrainingViewModel {

    private TrainingInteractor mTrainingInteractor;
    private TrainingRouter mTrainingRouter;

    private ObservableField<Integer> mRepetition;
    private ObservableField<String> mCounter;
    private ObservableField<Boolean> mStateOfRestButton;

    //private String mTextForTraining;
    // private String mTextForRest;
    //private ObservableField<String> mTitle;

    private Program mProgram;

    private CompositeDisposable mCompositeDisposable;

    private SingleLiveEvent<TrainingTitleSetEvent> mTitleSetEventLiveData;

    public TrainingViewModelImpl(TrainingInteractor trainingInteractor, TrainingRouter trainingRouter) {
        mTrainingInteractor = trainingInteractor;
        mTrainingRouter = trainingRouter;

        mCompositeDisposable = new CompositeDisposable();
        mTitleSetEventLiveData = new SingleLiveEvent<>();

        mProgram = new Program(0, new ArrayList<>());
        mCounter = new ObservableField<>("0");

        Disposable disposable = mTrainingInteractor.getPressUpForTraining()
                .subscribe(pressUp -> {
                    mProgram = pressUp;
                    mCounter.set(String.valueOf(mProgram.getRepetitions().get(0)));
                });
        mCompositeDisposable.add(disposable);

        //mTextForTraining = "Эй, Амиго! Сделай количество повторений и жми кнопку отдыха!";
        //mTextForRest = "Жди, когда закончится время отдыха и приступай к следующему повторению!";
        //mTitle = new ObservableField<>("");
        mTitleSetEventLiveData.postValue(new TrainingTitleSetEvent(TrainingTitleSetEvent.TitleText.TEXT_FOR_TRAINING));

        mRepetition = new ObservableField<>(1);

        mStateOfRestButton = new ObservableField<>(true);

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void setRouter(TrainingRouter router) {
        mTrainingRouter = router;
    }

    @Override
    public ObservableField<Integer> getRepetition() {
        return mRepetition;
    }

    @Override
    public ObservableField<String> getCounter() {
        return mCounter;
    }

    /*
    @Override
    public ObservableField<String> getTitle() {
        return mTitle;
    }
    */

    @Override
    public ObservableField<Boolean> getStateOfRestButton() {
        return mStateOfRestButton;
    }

    @Override
    public SingleLiveEvent<TrainingTitleSetEvent> getTitleSetEvent() {
        return mTitleSetEventLiveData;
    }

    @Override
    public void onClickNextRepetitionButton() {
        goToNextRepetition();
    }

    @Override
    public void onClickRestButton() {
        mTrainingRouter.showDialogTrainingRest();
        mStateOfRestButton.set(false);
    }

    @Override
    public void onClickPositiveButtonOfRestDialog() {
        //mTitle.set(mTextForRest);
        mTitleSetEventLiveData.postValue(new TrainingTitleSetEvent(TrainingTitleSetEvent.TitleText.TEXT_FOR_REST));
        mTrainingInteractor.getMainTimer()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mCounter.set(String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTrainingRouter.showErrorDialog();
                    }

                    @Override
                    public void onComplete() {
                        //mTitle.set(mTextForTraining);
                        mTitleSetEventLiveData.postValue(new TrainingTitleSetEvent(TrainingTitleSetEvent.TitleText.TEXT_FOR_TRAINING));
                        mStateOfRestButton.set(true);
                        mTrainingRouter.showDialogTrainingRestOff();
                        mTrainingRouter.playSound();
                    }
                });
    }

    @Override
    public void onClickNegativeButtonOfRestDialog() {
        mStateOfRestButton.set(true);
    }

    @Override
    public void onCancelOfRestDialog() {
        mStateOfRestButton.set(true);
    }

    @Override
    public void onClickAdditionalTimeForRest() {
        //mTitle.set(mTextForRest);
        mTitleSetEventLiveData.postValue(new TrainingTitleSetEvent(TrainingTitleSetEvent.TitleText.TEXT_FOR_REST));
        mTrainingInteractor.getAdditionalTimer()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mCounter.set(String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {
                        mTrainingRouter.showErrorDialog();
                    }

                    @Override
                    public void onComplete() {
                        if (mRepetition.get() == Constants.MAX_REPETITION) return;
                        mTrainingRouter.playSound();
                        //mTitle.set(mTextForTraining);
                        mTitleSetEventLiveData.postValue(new TrainingTitleSetEvent(TrainingTitleSetEvent.TitleText.TEXT_FOR_TRAINING));
                        goToNextRepetition();
                    }
                });
    }

    @Override
    public void goToNextRepetition() {
        if (mRepetition.get() < Constants.MAX_REPETITION) {
            mRepetition.set(mRepetition.get() + 1);
        } else {
            mRepetition.set(1);
        }
        switch (mRepetition.get()) {
            case 1:
                mCounter.set(String.valueOf(mProgram.getRepetitions().get(0)));
                break;
            case 2:
                mCounter.set(String.valueOf(mProgram.getRepetitions().get(1)));
                break;
            case 3:
                mCounter.set(String.valueOf(mProgram.getRepetitions().get(2)));
                break;
            case 4:
                mCounter.set(String.valueOf(mProgram.getRepetitions().get(3)));
                break;
            case 5:
                mCounter.set(String.valueOf(mProgram.getRepetitions().get(4)));
                break;
        }
    }

    @Override
    public void onClickFinishTrainingButton() {
        mTrainingRouter.showDialogFinishTraining();
    }

    @Override
    public void onClickPositiveButtonFinishDialog() {
        Program programNew;
        List<Integer> newList = new ArrayList<>();
        long newId = mProgram.getId() + 1;
        if (mProgram.getRepetitions().get(0) == mProgram.getRepetitions().get(1)) {
            newList.add(mProgram.getRepetitions().get(0));
            newList.add(mProgram.getRepetitions().get(1) + 1);
            newList.add(mProgram.getRepetitions().get(2));
            newList.add(mProgram.getRepetitions().get(3));
            newList.add(mProgram.getRepetitions().get(4) + 1);
        } else {
            newList.add(mProgram.getRepetitions().get(0) + 1);
            newList.add(mProgram.getRepetitions().get(1));
            newList.add(mProgram.getRepetitions().get(2) + 1);
            newList.add(mProgram.getRepetitions().get(3) + 1);
            newList.add(mProgram.getRepetitions().get(4));
        }
        programNew = new Program(newId, newList);
        /*
        Program programNew;
        if (mProgram.getFirstRepetition() == mProgram.getSecondRepetition()) {
            programNew = new Program(mProgram.getId() + 1, mProgram.getFirstRepetition(), mProgram.getSecondRepetition() + 1, mProgram.getThirdRepetition(), mProgram.getFourthRepetition(), mProgram.getFifthRepetition() + 1);
        } else {
            programNew = new Program(mProgram.getId() + 1, mProgram.getFirstRepetition() + 1, mProgram.getSecondRepetition(), mProgram.getThirdRepetition() + 1, mProgram.getFourthRepetition() + 1, mProgram.getFifthRepetition());
        }
        */
        mTrainingInteractor.insertInDB(programNew).subscribe();
    }
}
