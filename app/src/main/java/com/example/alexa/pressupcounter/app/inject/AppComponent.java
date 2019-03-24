package com.example.alexa.pressupcounter.app.inject;

import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelComponent;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelModule;

import dagger.Component;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@AppScope
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent {
        SetProgramModelComponent createSetProgramModelComponent(SetProgramModelModule setProgramModelModule);

        //PressUpDao pressUpDao();

        //AppDatabase appDatabase();
}
