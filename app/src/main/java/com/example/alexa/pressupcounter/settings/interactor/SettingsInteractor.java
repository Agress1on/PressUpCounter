package com.example.alexa.pressupcounter.settings.interactor;

import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.data.ProgramDao;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsInteractor {

    private ProgramDao mProgramDao;

    public SettingsInteractor(ProgramDao programDao) {
        mProgramDao = programDao;
    }

    public Single<Program> getLastPressUp() {
        return mProgramDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1));
    }

    public Completable deleteLastProgram(Program program) {
        return mProgramDao.delete(program)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable deleteAllProgress() {
        return mProgramDao.deleteAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
