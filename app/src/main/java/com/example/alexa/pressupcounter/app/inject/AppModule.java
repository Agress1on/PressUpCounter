package com.example.alexa.pressupcounter.app.inject;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class AppModule {
    private final Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @AppScope
    @Provides
    Context provideContext() {
        return mContext;
    }
}
