package com.example.alexa.pressupcounter.setprogram.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;

import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramRouterImpl implements SetProgramRouter {

    private LiveData<FragmentEvent> mGoToStartFragmentEvent;

    public SetProgramRouterImpl(SetProgramFragment fragment) {
        mGoToStartFragmentEvent = new SingleLiveEvent<>();
        mGoToStartFragmentEvent.observe(fragment, fragmentEvent -> fragment.goToStartFragment());
    }

    @Override
    public void goToStartTraining() {
        ((SingleLiveEvent<FragmentEvent>) mGoToStartFragmentEvent).postValue(new FragmentEvent());
    }
}
