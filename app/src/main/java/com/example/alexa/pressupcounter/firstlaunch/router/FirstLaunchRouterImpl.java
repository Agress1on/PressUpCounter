package com.example.alexa.pressupcounter.firstlaunch.router;

import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchRouterImpl implements FirstLaunchRouter {

    private SingleLiveEvent<FragmentEvent> mGoToSetProgramEvent;

    public FirstLaunchRouterImpl(FirstLaunchFragment fragment) {
        mGoToSetProgramEvent = new SingleLiveEvent<>();
        mGoToSetProgramEvent.observe(fragment, fragmentEvent -> {
            Logger.d("FirstLaunchRouterImpl", "Event");
            fragment.goToSetProgram();
        });
        Logger.d("FirstLaunchRouterImpl", "constructor");
    }

    @Override
    public void setSubscription() {

    }

    @Override
    public void goToSetProgram() {
        //mGoToSetProgramEvent.postValue(new FragmentEvent());
        mGoToSetProgramEvent.postValue(new FragmentEvent());
        Logger.d("FirstLaunchRouterImpl", "goToSetProgram");
    }
}
