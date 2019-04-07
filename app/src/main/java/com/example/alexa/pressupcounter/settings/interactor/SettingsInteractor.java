package com.example.alexa.pressupcounter.settings.interactor;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.data.PressUpDao;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsInteractor {

    private PressUpDao mPressUpDao;

    public SettingsInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
    }

    public Single<List<PressUp>> getById(long id) {
        return mPressUpDao.getPressUpById(id);
    }

    /*
    public Flowable<List<PressUp>> getById(long id) {
        return mPressUpDao.getById(id);
    }
    */
}
