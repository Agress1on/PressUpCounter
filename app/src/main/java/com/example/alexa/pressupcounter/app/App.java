package com.example.alexa.pressupcounter.app;

import android.app.Application;

import com.example.alexa.pressupcounter.app.inject.AppComponent;
import com.example.alexa.pressupcounter.app.inject.DaggerAppComponent;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class App extends Application implements HasSupportFragmentInjector {

    private AppComponent sAppComponent;

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponent.builder()
                .context(this)
                .build();
        sAppComponent.inject(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingAndroidInjector;
    }
}
