package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface FirstLaunchViewModel {

    void setCurrentRouter(FirstLaunchRouter firstLaunchRouter);

    void onClickMissButton();
}
