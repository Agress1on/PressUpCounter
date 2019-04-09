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
    public static App sInstance;

    private static AppComponent sAppComponent;
    //private AppDatabase mDatabase;

    @Inject
    DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        //mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database").build();
        /*
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .roomModule(new RoomModule(this))
                .build();
        */


        sAppComponent = DaggerAppComponent.builder()
                .context(this)
                .build();
        sAppComponent.inject(this);
    }

    public static App getInstance() {
        return sInstance;
    }

    /*
    public AppDatabase getDatabase() {
        return mDatabase;
    }
    */

    //dagger
    public static AppComponent getAppComponent() {
        return sAppComponent;
    }


    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mDispatchingAndroidInjector;
    }
}
