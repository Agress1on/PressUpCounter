package com.example.alexa.pressupcounter.main.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.alexa.pressupcounter.main.interactor.MainInteractor;
import com.example.alexa.pressupcounter.main.router.MainRouter;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainFactory extends ViewModelProvider.NewInstanceFactory {

    private final MainInteractor mMainInteractor;
    private final MainRouter mMainRouter;

    public MainFactory(MainInteractor mainInteractor, MainRouter mainRouter) {
        super();
        mMainInteractor = mainInteractor;
        mMainRouter = mainRouter;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == MainViewModelImpl.class) {
            return (T) new MainViewModelImpl(mMainInteractor, mMainRouter);
        }
        return null;
    }
}
