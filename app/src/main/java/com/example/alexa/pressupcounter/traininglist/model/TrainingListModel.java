package com.example.alexa.pressupcounter.traininglist.model;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.PressUpDao;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListModel {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    public TrainingListModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        mAppDatabase = appDatabase;
        mPressUpDao = pressUpDao;
    }

    public Single<List<PressUp>> getAllPressUps() {
        return mPressUpDao.getAll();
    }
}
