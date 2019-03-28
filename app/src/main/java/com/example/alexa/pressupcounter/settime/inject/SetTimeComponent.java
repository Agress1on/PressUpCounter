package com.example.alexa.pressupcounter.settime.inject;

import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;

import dagger.Subcomponent;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@SetTimeScope
@Subcomponent(modules = SetTimeModule.class)
public interface SetTimeComponent {
    void inject(SetTimeFragment setTimeFragment);
}
