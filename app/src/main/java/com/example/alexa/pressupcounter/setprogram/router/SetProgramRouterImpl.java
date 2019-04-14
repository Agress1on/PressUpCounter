package com.example.alexa.pressupcounter.setprogram.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.DialogEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramRouterImpl implements SetProgramRouter {

    private SingleLiveEvent<FragmentEvent> mGoToStart;
    private SingleLiveEvent<DialogEvent> mShowErrorDialog;

    public SetProgramRouterImpl(SetProgramFragment fragment) {
        mGoToStart = new SingleLiveEvent<>();
        mGoToStart.observe(fragment, fragmentEvent -> fragment.goToStartFragment());

        mShowErrorDialog = new SingleLiveEvent<>();
        mShowErrorDialog.observe(fragment, dialogEvent -> fragment.showErrorDialog());
    }

    @Override
    public void goToStartTraining() {
        mGoToStart.postValue(new FragmentEvent());
    }

    @Override
    public void showErrorDialog() {
        mShowErrorDialog.postValue(new DialogEvent());
    }
}
