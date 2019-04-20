package com.example.alexa.pressupcounter.setprogram.interactor;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.data.ProgramDao;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 24.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramInteractor {

    private ProgramDao mProgramDao;
    private List<Integer> mInitialRepetitionList;

    public SetProgramInteractor(ProgramDao programDao) {
        mProgramDao = programDao;
        mInitialRepetitionList = Constants.initList;
    }

    public Single<List<Integer>> getInitialRepetitionList() {
        return Single.just(mInitialRepetitionList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable insertInDataBase(Program program) {
        return Completable.wrap(mProgramDao.insert(program))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
