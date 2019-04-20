package com.example.alexa.pressupcounter.starttraining.interactor;

import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.data.ProgramDao;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 03.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingInteractor {

    private ProgramDao mProgramDao;

    public StartTrainingInteractor(ProgramDao programDao) {
        mProgramDao = programDao;
    }

    public Single<Program> getLastProgram() {
        return mProgramDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1));
    }

    public Single<Integer> getSumOfRepetitions() {
        return mProgramDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(pressUps -> pressUps.get(pressUps.size() - 1))
                .map(pressUp -> {
                    int sum = 0;
                    for (Integer item : pressUp.getRepetitions()) {
                        sum = sum + item;
                    }
                    return sum;
                });
    }
}
