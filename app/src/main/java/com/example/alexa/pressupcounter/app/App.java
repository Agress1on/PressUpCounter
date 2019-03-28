package com.example.alexa.pressupcounter.app;

import android.app.Application;

import com.example.alexa.pressupcounter.app.inject.AppComponent;
import com.example.alexa.pressupcounter.app.inject.AppModule;
import com.example.alexa.pressupcounter.app.inject.DaggerAppComponent;
import com.example.alexa.pressupcounter.app.inject.RoomModule;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class App extends Application {
    public static App sInstance;

    private static AppComponent sAppComponent;
    //private AppDatabase mDatabase;

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
}
