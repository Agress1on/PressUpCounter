package com.example.alexa.pressupcounter.setprogram.inject;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.AppDatabase_Impl;
import com.example.alexa.pressupcounter.repository.PressUpDao;
import com.example.alexa.pressupcounter.repository.PressUpDao_Impl;
import com.example.alexa.pressupcounter.setprogram.model.SetProgramModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetProgramModelModule {

    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    public SetProgramModelModule() {

    }

    @SetProgramModelScope
    @Provides
    SetProgramModel provideSetProgramModel() {
        return new SetProgramModel(mAppDatabase, mPressUpDao);
    }
}
