package com.example.alexa.pressupcounter.app.inject;

import android.content.Context;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.PressUpDao;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class RoomModule {

    private static final String DATABASE = "database";

    @AppScope
    @Provides
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DATABASE).build();
    }

    @AppScope
    @Provides
    PressUpDao providePressUpDao(AppDatabase appDatabase) {
        return appDatabase.pressUpDao();
    }
}
