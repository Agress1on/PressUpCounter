package com.example.alexa.pressupcounter.setprogram.model;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.PressUpDao;

import io.reactivex.Completable;

/**
 * Created by Alexandr Mikhalev on 24.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramModel {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;


    public SetProgramModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        mAppDatabase = appDatabase;
        mPressUpDao = pressUpDao;
    }

    public Completable getPressUpDao(PressUp2 pressUp) {
        //return mPressUpDao.insert(pressUp);
        //return Completable.wrap(mPressUpDao.insert(pressUp));
        return null;
    }
}
