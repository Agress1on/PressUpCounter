package com.example.alexa.pressupcounter.main.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.alexa.pressupcounter.main.interactor.MainInteractor;

/**
 * Created by Alexandr Mikhalev on 06.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainViewModelImpl extends ViewModel implements MainViewModel {

    private MainInteractor mMainInteractor;

    public MainViewModelImpl(MainInteractor mainInteractor) {
        mMainInteractor = mainInteractor;
    }
}
