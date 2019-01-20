package com.example.alexa.pressupcounter;

import android.util.Log;

/**
 * Created by Alexandr Mikhalev on 18.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class Logger {
    public static void d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }
}
