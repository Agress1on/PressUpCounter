package com.example.alexa.pressupcounter.setprogram.model;

import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.PressUp;
import com.example.alexa.pressupcounter.repository.PressUpDao;

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

    public Completable insertInDataBase(PressUp pressUp) {
        return Completable.wrap(mPressUpDao.insert(pressUp));
    }
}
