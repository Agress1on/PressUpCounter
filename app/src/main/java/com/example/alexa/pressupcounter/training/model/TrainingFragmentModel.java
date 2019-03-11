package com.example.alexa.pressupcounter.training.model;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.PressUpDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Alexandr Mikhalev on 06.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingFragmentModel {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    private Observable<Long> mMainTimer;
    private Observable<Long> mAdditionalTimer;

    public TrainingFragmentModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        mAppDatabase = appDatabase;
        mPressUpDao = pressUpDao;
    }

    public Single<List<PressUp2>> getPressUp2ById(long id) {
        return mPressUpDao.getPressUpById(id);
    }

    public Observable<Long> getMainTimer() {
        mMainTimer = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return Constants.TIME_OF_MAIN_REST - aLong;
                    }
                }).takeUntil(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong == 0;
                    }
                });
        return mMainTimer;
    }

    public Observable<Long> getAdditionalTimer() {
        mAdditionalTimer = Observable.interval(1, TimeUnit.SECONDS)
                .map(new Function<Long, Long>() {
                    @Override
                    public Long apply(Long aLong) throws Exception {
                        return Constants.TIME_OF_ADDITIONAL_REST - aLong;
                    }
                }).takeUntil(new Predicate<Long>() {
                    @Override
                    public boolean test(Long aLong) throws Exception {
                        return aLong == 0;
                    }
                });
        return mAdditionalTimer;
    }

    /*
    public Flowable<List<PressUp2>> getPressUpById(long id) {
        return mPressUpDao.getById(id);
    }
    */
}
