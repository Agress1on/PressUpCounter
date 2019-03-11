package com.example.alexa.pressupcounter.starttraining.model;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.PressUpDao;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 03.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingModel {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    public StartTrainingModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        mAppDatabase = appDatabase;
        mPressUpDao = pressUpDao;
    }

    public Single<List<PressUp2>> getPressUpById(long id) {
        return mPressUpDao.getPressUpById(id);
    }

    /*
    public Flowable<List<PressUp2>> getPressUpById(long id) {
        return mPressUpDao.getById(id);
    }
    */
}
