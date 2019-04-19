package com.example.alexa.pressupcounter.main.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.alexa.pressupcounter.main.interactor.MainInteractor;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainFactory extends ViewModelProvider.NewInstanceFactory {

    private final MainInteractor mMainInteractor;

    public MainFactory(MainInteractor mainInteractor) {
        super();
        mMainInteractor = mainInteractor;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == MainViewModelImpl.class) {
            return (T) new MainViewModelImpl(mMainInteractor);
        }
        return null;
    }
}
