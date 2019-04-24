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

    private ObservableField<Boolean> mVisibleContainer;
    private CompositeDisposable mCompositeDisposable;

    private boolean mIsExistDatabase;
    private boolean mIsFirstLaunch;

    public MainViewModelImpl(MainInteractor mainInteractor, MainRouter mainRouter) {
        mMainInteractor = mainInteractor;
        mMainRouter = mainRouter;

        mVisibleContainer = new ObservableField<>(false);
        mCompositeDisposable = new CompositeDisposable();

        init();
    }

    private void init() {
        Disposable isVisitedDisposable = mMainInteractor.isVisited()
                .filter((isVisited) -> !isVisited)
                .subscribe((isVisited) -> {
                    setVisited();
                    mMainRouter.goToFirstLaunch();
                    mIsFirstLaunch = true;
                });

        Disposable disposable = mMainInteractor.isExistDataBase()
                .subscribe(aBoolean -> {
                    mIsExistDatabase = aBoolean;
                    if (!mIsExistDatabase && !mIsFirstLaunch) mMainRouter.goToSetProgram();
                    if (mIsExistDatabase) mMainRouter.goToStartTraining();
                    mVisibleContainer.set(true);
                });
        mCompositeDisposable.addAll(disposable, isVisitedDisposable);
    }

    private void setVisited() {
        Disposable disposable = mMainInteractor.setVisited(true).subscribe();
        mCompositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeDisposable.clear();
    }

    @Override
    public void setCurrentRouter(MainRouter mainRouter) {
        mMainRouter = mainRouter;
    }

    @Override
    public ObservableField<Boolean> isVisibleContainer() {
        return mVisibleContainer;
    }
}
