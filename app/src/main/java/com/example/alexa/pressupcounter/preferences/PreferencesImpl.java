package com.example.alexa.pressupcounter.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 24.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PreferencesImpl implements Preferences {

    private static final String LAUNCH_SETTINGS = "launch";
    private static final String HAS_VISITED = "has_visited";

    private SharedPreferences mSharedPreferences;

    public PreferencesImpl(Context context) {
        mSharedPreferences = context.getSharedPreferences(LAUNCH_SETTINGS, Context.MODE_PRIVATE);
    }

    @Override
    public Completable setIsVisited(final boolean isVisited) {
        return Completable.fromRunnable(() -> mSharedPreferences.edit().putBoolean(HAS_VISITED, isVisited).apply());
    }

    @Override
    public Single<Boolean> isVisited() {
        return Single.fromCallable(() -> mSharedPreferences.getBoolean(HAS_VISITED, false));
    }
}
