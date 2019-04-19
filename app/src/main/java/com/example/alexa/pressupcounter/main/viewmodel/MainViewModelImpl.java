package com.example.alexa.pressupcounter.main.viewmodel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.alexa.pressupcounter.main.interactor.MainInteractor;
import com.example.alexa.pressupcounter.main.router.MainRouter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 06.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainViewModelImpl extends ViewModel implements MainViewModel {

    private MainInteractor mMainInteractor;
    private MainRouter mMainRouter;

    private ObservableField<Boolean> mVisibleFrame;
    private CompositeDisposable mCompositeDisposable;

    private boolean mIsExistDatabase;
    private boolean mIsFirstLaunch;

    public MainViewModelImpl(MainInteractor mainInteractor, MainRouter mainRouter) {
        mMainInteractor = mainInteractor;
        mMainRouter = mainRouter;

        mVisibleFrame = new ObservableField<>(false);
        mCompositeDisposable = new CompositeDisposable();

        Disposable disposable = mMainInteractor.isExistDataBase()
                .subscribe(aBoolean -> {
                    mIsExistDatabase = aBoolean;
                    if (!mIsExistDatabase && !mIsFirstLaunch) mMainRouter.goToSetProgram();
                    if (mIsExistDatabase) mMainRouter.goToStartTraining();
                    mVisibleFrame.set(true);
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void onFirstLaunch() {
        mMainRouter.goToFirstLaunch();
        mIsFirstLaunch = true;
    }

    @Override
    public void setRouter(MainRouter mainRouter) {
        mMainRouter = mainRouter;
    }

    @Override
    public void goToNextFragment() {
        if (mIsExistDatabase) {
            mMainRouter.goToStartTraining();
        } else {
            mMainRouter.goToSetProgram();
        }
    }

    @Override
    public ObservableField<Boolean> isVisibleFrame() {
        return mVisibleFrame;
    }
}
