package com.example.alexa.pressupcounter.main.inject;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.alexa.pressupcounter.data.PressUpDao;
import com.example.alexa.pressupcounter.main.interactor.MainInteractor;
import com.example.alexa.pressupcounter.main.view.MainActivity;
import com.example.alexa.pressupcounter.main.viewmodel.MainFactory;
import com.example.alexa.pressupcounter.main.viewmodel.MainViewModel;
import com.example.alexa.pressupcounter.main.viewmodel.MainViewModelImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class MainModule {

    @Provides
    @MainScope
    MainInteractor provideMainInteractor(PressUpDao pressUpDao) {
        return new MainInteractor(pressUpDao);
    }


    @Provides
    @MainScope
    MainViewModel provideMainViewModel(MainActivity mainActivity, MainFactory mainFactory) {
        return ViewModelProviders.of(mainActivity, mainFactory).get(MainViewModelImpl.class);
    }

    @Provides
    @MainScope
    MainFactory provideMainFactory(MainInteractor mainInteractor) {
        return new MainFactory(mainInteractor);
    }
}
