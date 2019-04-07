package com.example.alexa.pressupcounter.training.interactor;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.data.PressUpDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 06.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingInteractor {

    private PressUpDao mPressUpDao;

    private Observable<Long> mMainTimer;
    private Observable<Long> mAdditionalTimer;

    public TrainingInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
    }

    public Completable insertInDB(PressUp pressUp) {
        return mPressUpDao.insert(pressUp)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<PressUp> getPressUpForTraining() {
        return mPressUpDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1));
    }

    public Observable<Long> getMainTimer() {
        mMainTimer = Observable.interval(1, TimeUnit.SECONDS)
                .map(aLong -> Constants.TIME_OF_MAIN_REST - aLong)
                .takeUntil(aLong -> aLong == 0);
        return mMainTimer;
    }

    public Observable<Long> getAdditionalTimer() {
        mAdditionalTimer = Observable.interval(1, TimeUnit.SECONDS)
                .map(aLong -> Constants.TIME_OF_ADDITIONAL_REST - aLong)
                .takeUntil(aLong -> aLong == 0);
        return mAdditionalTimer;
    }
}
