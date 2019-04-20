package com.example.alexa.pressupcounter.main.interactor;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.ProgramDao;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainInteractor {

    private ProgramDao mProgramDao;

    public MainInteractor(ProgramDao programDao) {
        mProgramDao = programDao;
    }

    public Single<Boolean> isExistDataBase() {
        return mProgramDao.getProgramById(Constants.FIRST_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> !pressUps.isEmpty());
    }
}
