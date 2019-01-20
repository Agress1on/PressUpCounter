package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.main.view.MainActivity;

/**
 * Created by Alexandr Mikhalev on 12.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchViewModelImpl extends ViewModel implements FirstLaunchViewModel {

    private OnStartMainActivityListener mOnStartMainActivityButton;

    public FirstLaunchViewModelImpl(OnStartMainActivityListener onStartMainActivityButton) {
        mOnStartMainActivityButton = onStartMainActivityButton;
    }

    @Override
    public void onStartMainActivityButton() {
        Logger.d(Constants.LOGGER, "onClickFirstLaunch");
        mOnStartMainActivityButton.onClick();
    }

    public interface OnStartMainActivityListener {
        void onClick();
    }
}
