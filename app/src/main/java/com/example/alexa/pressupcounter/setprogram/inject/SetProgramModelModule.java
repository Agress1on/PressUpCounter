package com.example.alexa.pressupcounter.setprogram.inject;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.repository.PressUpDao;
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

    @SetProgramModelScope
    @Provides
    SetProgramModel provideSetProgramModel(AppDatabase appDatabase, PressUpDao pressUpDao) {
        return new SetProgramModel(appDatabase, pressUpDao);
    }
}
