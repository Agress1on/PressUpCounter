package com.example.alexa.pressupcounter.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alexa.pressupcounter.PressUp;

/**
 * Created by Alexandr Mikhalev on 26.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DataBaseHelperImpl extends SQLiteOpenHelper implements DatabaseHelper {

    private static final String DATABASE_NAME = "pressUpFirstTraining";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_PRESS_UP = "PRESS_UP";

    private static final String KEY_FIRST_REPETITION = "FIRST";
    private static final String KEY_SECOND_REPETITION = "SECOND";
    private static final String KEY_THIRD_REPETITION = "THIRD";
    private static final String KEY_FOURTH_REPETITION = "FOURTH";
    private static final String KEY_FIFTH_REPETITION = "FIFTH";


    public DataBaseHelperImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_PRESS_UP_TABLE = "create table " + TABLE_PRESS_UP + "(" + "first repetition," + "second repetition," + "third repetition," + "fourth repetition," + "fifth repetition" + ");";
        db.execSQL(CREATE_PRESS_UP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void addPressUp(PressUp pressUp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_FIRST_REPETITION, pressUp.getFirstRepetition());
        cv.put(KEY_SECOND_REPETITION, pressUp.getSecondRepetition());
        cv.put(KEY_THIRD_REPETITION, pressUp.getThirdRepetition());
        cv.put(KEY_FOURTH_REPETITION, pressUp.getFourthRepetition());
        cv.put(KEY_FIFTH_REPETITION, pressUp.getFifthRepetition());

        db.insert(TABLE_PRESS_UP, null, cv);
        db.close();
    }

    @Override
    public PressUp getPressUp() {
        SQLiteDatabase db = this.getWritableDatabase();
        return null;
    }
}
