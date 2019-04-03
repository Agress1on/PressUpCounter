package com.example.alexa.pressupcounter.setprogram.interactor;

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
    private List<ObservableField<Integer>> mInitialRepetitionList;

    public SetProgramInteractor(PressUpDao pressUpDao) {
        mPressUpDao = pressUpDao;

        mInitialRepetitionList = new ArrayList<>();
        mInitialRepetitionList.add(new ObservableField<>(2)); //FirstRepetition
        mInitialRepetitionList.add(new ObservableField<>(3)); //SecondRepetition
        mInitialRepetitionList.add(new ObservableField<>(1)); //ThirdRepetition
        mInitialRepetitionList.add(new ObservableField<>(1)); //FourthRepetition
        mInitialRepetitionList.add(new ObservableField<>(3)); //FifthRepetition

    }

    public Single<List<ObservableField<Integer>>> getInitialRepetitionList() {
        return Single.just(mInitialRepetitionList);
    }

    public Completable insertInDataBase(PressUp pressUp) {
        return Completable.wrap(mPressUpDao.insert(pressUp))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
