package com.example.alexa.pressupcounter.training.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.training.interactor.TrainingInteractor;
import com.example.alexa.pressupcounter.training.router.TrainingRouter;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
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
    private ObservableField<String> mQuantityOfRepetitionOrRestTime;
    private ObservableField<Boolean> mStateOfRestButton;

    private String mTextForTraining;
    private String mTextForRest;
    private ObservableField<String> mTextForTrainingOrRest;

    private PressUp mPressUp;

    private CompositeDisposable mCompositeDisposable;

    public TrainingViewModelImpl(TrainingInteractor trainingInteractor, TrainingRouter trainingRouter) {
        mTrainingInteractor = trainingInteractor;
        mTrainingRouter = trainingRouter;

        mCompositeDisposable = new CompositeDisposable();

        mPressUp = new PressUp(0, 0, 0, 0, 0, 0);
        mQuantityOfRepetitionOrRestTime = new ObservableField<>("0");

        Disposable disposable = mTrainingInteractor.getPressUpForTraining()
                .subscribe(pressUp -> {
                    mPressUp = pressUp;
                    mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getFirstRepetition()));
                });
        mCompositeDisposable.add(disposable);

        mTextForTraining = "Эй, Амиго! Сделай количество повторений и жми кнопку отдыха!";
        mTextForRest = "Жди, когда закончится время отдыха и приступай к следующему повторению!";
        mTextForTrainingOrRest = new ObservableField<>(mTextForTraining);

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
    public ObservableField<String> getQuantityOfRepetitionOrRestTime() {
        return mQuantityOfRepetitionOrRestTime;
    }

    @Override
    public ObservableField<String> getTextForTrainingOrRest() {
        return mTextForTrainingOrRest;
    }

    @Override
    public ObservableField<Boolean> getStateOfRestButton() {
        return mStateOfRestButton;
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
        mTextForTrainingOrRest.set(mTextForRest);
        mTrainingInteractor.getMainTimer()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mQuantityOfRepetitionOrRestTime.set(String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mTextForTrainingOrRest.set(mTextForTraining);
                        mStateOfRestButton.set(true);
                        mTrainingRouter.showDialogTrainingRestOff();
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
        mTextForTrainingOrRest.set(mTextForRest);
        mTrainingInteractor.getAdditionalTimer()
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mQuantityOfRepetitionOrRestTime.set(String.valueOf(aLong));
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        if (mRepetition.get() == 5) return;
                        goToNextRepetition();
                    }
                });
    }

    @Override
    public void goToNextRepetition() {
        if (mRepetition.get() < 5) {
            mRepetition.set(mRepetition.get() + 1);
        } else {
            mRepetition.set(1);
        }
        switch (mRepetition.get()) {
            case 1:
                mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getFirstRepetition()));
                break;
            case 2:
                mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getSecondRepetition()));
                break;
            case 3:
                mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getThirdRepetition()));
                break;
            case 4:
                mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getFourthRepetition()));
                break;
            case 5:
                mQuantityOfRepetitionOrRestTime.set(String.valueOf(mPressUp.getFifthRepetition()));
                break;
        }
    }

    @Override
    public void onClickFinishTrainingButton() {
        mTrainingRouter.showDialogFinishTraining();
    }

    @Override
    public void onClickPositiveButtonFinishDialog() {
        PressUp pressUpNew;
        if (mPressUp.getFirstRepetition() == mPressUp.getSecondRepetition()) {
            pressUpNew = new PressUp(mPressUp.getId() + 1, mPressUp.getFirstRepetition(), mPressUp.getSecondRepetition() + 1, mPressUp.getThirdRepetition(), mPressUp.getFourthRepetition(), mPressUp.getFifthRepetition() + 1);
        } else {
            pressUpNew = new PressUp(mPressUp.getId() + 1, mPressUp.getFirstRepetition() + 1, mPressUp.getSecondRepetition(), mPressUp.getThirdRepetition() + 1, mPressUp.getFourthRepetition() + 1, mPressUp.getFifthRepetition());
        }
        mTrainingInteractor.insertInDB(pressUpNew).subscribe();
    }
}
