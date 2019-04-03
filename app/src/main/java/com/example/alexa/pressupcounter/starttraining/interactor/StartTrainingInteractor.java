package com.example.alexa.pressupcounter.starttraining.interactor;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.data.PressUpDao;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 03.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingInteractor {

    private PressUpDao mPressUpDao;

    public StartTrainingInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
    }

    public Single<PressUp> getLastProgram() {
        return mPressUpDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1));
    }

    public Single<Integer> getSumOfRepetitions() {
        return mPressUpDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1))
                .map(pressUp -> pressUp.getFirstRepetition()
                        + pressUp.getSecondRepetition()
                        + pressUp.getThirdRepetition()
                        + pressUp.getFourthRepetition()
                        + pressUp.getFifthRepetition());
    }
}
