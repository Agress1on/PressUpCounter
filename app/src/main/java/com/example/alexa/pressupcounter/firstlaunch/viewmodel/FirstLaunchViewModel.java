package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface FirstLaunchViewModel {

    void setNewRouter(FirstLaunchRouter firstLaunchRouter);

    void onClickMissButton();
}
