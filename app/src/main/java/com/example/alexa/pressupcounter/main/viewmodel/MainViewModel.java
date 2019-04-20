package com.example.alexa.pressupcounter.main.viewmodel;

import androidx.databinding.ObservableField;

import com.example.alexa.pressupcounter.main.router.MainRouter;

/**
 * Created by Alexandr Mikhalev on 06.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface MainViewModel {

    void onFirstLaunch();

    void setCurrentRouter(MainRouter mainRouter);

    ObservableField<Boolean> isVisibleContainer();
}
