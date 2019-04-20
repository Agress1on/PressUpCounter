package com.example.alexa.pressupcounter.traininglist.interactor;

import com.example.alexa.pressupcounter.data.AppDatabase;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.data.ProgramDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListInteractor {

    private AppDatabase mAppDatabase;
    private ProgramDao mProgramDao;

    public TrainingListInteractor(AppDatabase appDatabase, ProgramDao programDao) {
        mAppDatabase = appDatabase;
        mProgramDao = programDao;
    }

    public Single<List<Program>> getAllPressUps() {
        return mProgramDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .delay(3, TimeUnit.SECONDS);
    }
}
