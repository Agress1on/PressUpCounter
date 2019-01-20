package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import android.arch.lifecycle.ViewModel;

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
        mOnStartMainActivityButton.onClick();
    }

    public interface OnStartMainActivityListener {
        void onClick();
    }
}
