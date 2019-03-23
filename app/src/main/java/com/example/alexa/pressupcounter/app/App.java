package com.example.alexa.pressupcounter.app;

import android.app.Application;
import androidx.room.Room;

import com.example.alexa.pressupcounter.repository.AppDatabase;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class App extends Application {
    public static App sInstance;

    private AppDatabase mDatabase;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mDatabase = Room.databaseBuilder(this, AppDatabase.class, "database").build();
    }

    public static App getInstance() {
        return sInstance;
    }


    public AppDatabase getDatabase() {
        return mDatabase;
    }

}
