package com.example.alexa.pressupcounter.firstlaunch.router;

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
            fragment.setSetProgram();
        });
    }

    @Override
    public void goToSetProgram() {
        mGoToSetProgramEvent.postValue(new FragmentEvent());
    }
}
