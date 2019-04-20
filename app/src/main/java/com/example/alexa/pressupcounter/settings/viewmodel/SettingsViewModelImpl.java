package com.example.alexa.pressupcounter.settings.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.settings.interactor.SettingsInteractor;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;

import io.reactivex.CompletableObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsViewModelImpl extends ViewModel implements SettingsViewModel {

    private SettingsInteractor mSettingsInteractor;
    private SettingsRouter mSettingsRouter;

    private Program mLastProgram;
    private CompositeDisposable mCompositeDisposable;

    public SettingsViewModelImpl(SettingsInteractor settingsInteractor, SettingsRouter router) {
        mSettingsInteractor = settingsInteractor;
        mSettingsRouter = router;

        mCompositeDisposable = new CompositeDisposable();

        Disposable disposable = mSettingsInteractor.getLastPressUp()
                .subscribe(pressUp -> mLastProgram = pressUp);
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void setCurrentRouter(SettingsRouter settingsRouter) {
        mSettingsRouter = settingsRouter;
    }

    @Override
    public void onClickSetNotifications() {
        mSettingsRouter.goToSetTrainingDay();
    }

    @Override
    public void onClickDeleteLastProgram() {
        mSettingsInteractor.deleteLastProgram(mLastProgram)
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        mSettingsRouter.showToast();
                        if (mLastProgram.getId() == 1) mSettingsRouter.goToSetProgram();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mSettingsRouter.showErrorDialog();
                    }
                });
    }

    @Override
    public void onClickResetAllProgress() {
        mSettingsInteractor.deleteAllProgress()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        mSettingsRouter.goToSetProgram();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mSettingsRouter.showErrorDialog();
                    }
                });
    }
}
