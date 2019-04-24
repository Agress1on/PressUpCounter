package com.example.alexa.pressupcounter.main.interactor;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.ProgramDao;
import com.example.alexa.pressupcounter.preferences.Preferences;

import io.reactivex.Completable;
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
    private Preferences mPreferences;

    public MainInteractor(ProgramDao programDao, Preferences preferences) {
        mProgramDao = programDao;
        mPreferences = preferences;
    }

    public Single<Boolean> isExistDataBase() {
        return mProgramDao.getProgramById(Constants.FIRST_ID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> !pressUps.isEmpty());
    }

    public Single<Boolean> isVisited() {
        return mPreferences.isVisited()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable setVisited(boolean isVisited) {
        return mPreferences.setIsVisited(isVisited)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
