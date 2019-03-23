package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.repository.PressUp;
import com.example.alexa.pressupcounter.traininglist.model.TrainingListModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListViewModelImpl extends ViewModel implements TrainingListViewModel {
    private TrainingListModel mTrainingListModel;

    private List<PressUp> mPressUpList;
    private CompositeDisposable mCompositeDisposable;

    private ObservableField<Boolean> mProgressBarState;

    public TrainingListViewModelImpl(TrainingListModel trainingListModel) {
        mTrainingListModel = trainingListModel;
        mCompositeDisposable = new CompositeDisposable();
        mPressUpList = new ArrayList<>();
        mProgressBarState = new ObservableField<>(true);

        Disposable disposable = mTrainingListModel.getAllPressUps()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PressUp>>() {
                    @Override
                    public void accept(List<PressUp> pressUps) throws Exception {

                        mPressUpList = pressUps;
                        mProgressBarState.set(false);
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public List<PressUp> getPressUpList() {
        return mPressUpList;
    }

    @Override
    public ObservableField<Boolean> getProgressBarState() {
        return mProgressBarState;
    }
}
