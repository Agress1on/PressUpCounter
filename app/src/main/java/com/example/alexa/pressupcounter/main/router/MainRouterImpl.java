package com.example.alexa.pressupcounter.main.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.main.view.MainActivity;

/**
 * Created by Alexandr Mikhalev on 19.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class MainRouterImpl implements MainRouter {

    private SingleLiveEvent<FragmentEvent> mGoToFirstLaunch;
    private SingleLiveEvent<FragmentEvent> mGoToSetProgram;
    private SingleLiveEvent<FragmentEvent> mGoToStartTraining;

    public MainRouterImpl(MainActivity activity) {
        mGoToFirstLaunch = new SingleLiveEvent<>();
        mGoToFirstLaunch.observe(activity, fragmentEvent -> activity.goToFirstLaunch());

        mGoToSetProgram = new SingleLiveEvent<>();
        mGoToSetProgram.observe(activity, fragmentEvent -> activity.goToSetProgram());

        mGoToStartTraining = new SingleLiveEvent<>();
        mGoToStartTraining.observe(activity, fragmentEvent -> activity.goToStartTraining());
    }

    @Override
    public void goToFirstLaunch() {
        mGoToFirstLaunch.postValue(new FragmentEvent());
    }

    @Override
    public void goToSetProgram() {
        mGoToSetProgram.postValue(new FragmentEvent());
    }

    @Override
    public void goToStartTraining() {
        mGoToStartTraining.postValue(new FragmentEvent());
    }
}
