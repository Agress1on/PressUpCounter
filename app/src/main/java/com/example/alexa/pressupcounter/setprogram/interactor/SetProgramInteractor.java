package com.example.alexa.pressupcounter.setprogram.interactor;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.data.PressUpDao;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
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

    private PressUpDao mPressUpDao;
    private List<Integer> mInitialRepetitionList;

    public SetProgramInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;
        mInitialRepetitionList = Constants.initList;
    }

    public Single<List<Integer>> getInitialRepetitionList() {
        return Single.just(mInitialRepetitionList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Completable insertInDataBase(PressUp pressUp) {
        return Completable.wrap(mPressUpDao.insert(pressUp))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
