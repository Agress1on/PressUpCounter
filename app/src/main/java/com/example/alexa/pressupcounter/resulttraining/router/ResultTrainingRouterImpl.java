package com.example.alexa.pressupcounter.resulttraining.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingRouterImpl implements ResultTrainingRouter {

    private SingleLiveEvent<FragmentEvent> mGoToStartTrainingEvent;

    public ResultTrainingRouterImpl(ResultTrainingFragment fragment) {
        mGoToStartTrainingEvent = new SingleLiveEvent<>();
        mGoToStartTrainingEvent.observe(fragment, fragmentEvent -> fragment.goToStartTraining());
    }

    @Override
    public void goToStartTrainingFragment() {
        mGoToStartTrainingEvent.postValue(new FragmentEvent());
    }
}
