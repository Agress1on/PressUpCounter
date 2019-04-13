package com.example.alexa.pressupcounter.setprogram.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramRouterImpl implements SetProgramRouter {

    private SingleLiveEvent<FragmentEvent> mGoToStartFragmentEvent;

    public SetProgramRouterImpl(SetProgramFragment fragment) {
        mGoToStartFragmentEvent = new SingleLiveEvent<>();
        mGoToStartFragmentEvent.observe(fragment, fragmentEvent -> fragment.goToStartFragment());
    }

    @Override
    public void goToStartTraining() {
        mGoToStartFragmentEvent.postValue(new FragmentEvent());
    }
}
