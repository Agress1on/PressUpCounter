package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import android.util.Log;

import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchViewModelImpl extends ViewModel implements FirstLaunchViewModel {

    private FirstLaunchRouter mFirstLaunchRouter;

    @Inject
    public FirstLaunchViewModelImpl(FirstLaunchRouter firstLaunchRouter) {
        mFirstLaunchRouter = firstLaunchRouter;
        Logger.d("FirstLaunchViewModelImpl", "create");
    }

    @Override
    public void setNewRouter(FirstLaunchRouter firstLaunchRouter) {
        mFirstLaunchRouter = firstLaunchRouter;
    }

    @Override
    public void onClickMissButton() {
        mFirstLaunchRouter.goToSetProgram();
    }
}
