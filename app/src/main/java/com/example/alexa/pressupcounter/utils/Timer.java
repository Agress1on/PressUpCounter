package com.example.alexa.pressupcounter.utils;

import com.example.alexa.pressupcounter.Constants;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by Alexandr Mikhalev on 04.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class Timer {

    private Observable<Long> mMainTimer;
    private Observable<Long> mAdditionalTimer;

    public Timer() {
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
    }

    public Observable<Long> getMainTimer() {
        return mMainTimer;
    }

    public Observable<Long> getAdditionalTimer() {
        return mAdditionalTimer;
    }
}
