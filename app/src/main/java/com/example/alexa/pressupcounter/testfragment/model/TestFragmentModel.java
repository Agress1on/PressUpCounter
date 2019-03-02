package com.example.alexa.pressupcounter.testfragment.model;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.PressUpDao;

import java.util.List;

import io.reactivex.Flowable;

import static io.reactivex.Flowable.just;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TestFragmentModel {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    public TestFragmentModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        mAppDatabase = appDatabase;
        mPressUpDao = pressUpDao;
    }

    public Flowable<List<PressUp2>> getById(long id) {
        return mPressUpDao.getById(id);
    }
}
