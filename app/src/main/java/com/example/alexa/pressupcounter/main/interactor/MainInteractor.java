package com.example.alexa.pressupcounter.main.interactor;

import com.example.alexa.pressupcounter.data.PressUpDao;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainInteractor {

    private PressUpDao mPressUpDao;

    public MainInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
    }

    public Single<Boolean> isExistDataBase() {
        return mPressUpDao.getPressUpById(Constants.FIRST_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> !pressUps.isEmpty());
    }
}
