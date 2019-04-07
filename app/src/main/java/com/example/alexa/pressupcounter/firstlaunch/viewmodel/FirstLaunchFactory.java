package com.example.alexa.pressupcounter.firstlaunch.viewmodel;

import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchFactory extends ViewModelProvider.NewInstanceFactory {
    private final FirstLaunchRouter mRouter;

    public FirstLaunchFactory(FirstLaunchRouter router) {
        super();
        mRouter = router;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == FirstLaunchViewModelImpl.class) {
            return (T) new FirstLaunchViewModelImpl(mRouter);
        }
        return null;
    }
}
