package com.example.alexa.pressupcounter.setprogram.inject;

import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 24.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@SetProgramModelScope
@Subcomponent(modules = SetProgramModelModule.class)
public interface SetProgramModelComponent {
    void inject(SetProgramFragment setProgramFragment);
}
