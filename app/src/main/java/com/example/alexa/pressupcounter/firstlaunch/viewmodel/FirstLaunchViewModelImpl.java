package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchViewModelImpl extends ViewModel implements FirstLaunchViewModel {

    private FirstLaunchRouter mFirstLaunchRouter;

    public FirstLaunchViewModelImpl(FirstLaunchRouter firstLaunchRouter) {
        mFirstLaunchRouter = firstLaunchRouter;
    }

    @Override
    public void onClickMissButton() {
        mFirstLaunchRouter.goToSetProgram();
    }
}
