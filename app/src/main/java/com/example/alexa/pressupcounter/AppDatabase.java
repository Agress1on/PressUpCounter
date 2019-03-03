package com.example.alexa.pressupcounter;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Database(entities = {PressUp2.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PressUpDao pressUpDao();
}