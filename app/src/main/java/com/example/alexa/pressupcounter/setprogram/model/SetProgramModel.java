package com.example.alexa.pressupcounter.setprogram.model;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.data.PressUpDao;

import io.reactivex.Completable;

/**
 * Created by Alexandr Mikhalev on 24.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramModel {

    private PressUpDao mPressUpDao;

    public SetProgramModel(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
    }

    public Completable insertInDataBase(PressUp pressUp) {
        return Completable.wrap(mPressUpDao.insert(pressUp));
    }
}
