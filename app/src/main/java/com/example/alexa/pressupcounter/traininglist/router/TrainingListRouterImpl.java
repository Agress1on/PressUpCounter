package com.example.alexa.pressupcounter.traininglist.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.traininglist.view.TrainingListFragment;

/**
 * Created by Alexandr Mikhalev on 15.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListRouterImpl implements TrainingListRouter {

    private SingleLiveEvent<FragmentEvent> mGoToStartFragment;

    public TrainingListRouterImpl(TrainingListFragment fragment) {
        mGoToStartFragment = new SingleLiveEvent<>();
        mGoToStartFragment.observe(fragment, fragmentEvent -> fragment.goToStartTraining());
    }

    @Override
    public void goToStartFragment() {
        mGoToStartFragment.postValue(new FragmentEvent());
    }
}
