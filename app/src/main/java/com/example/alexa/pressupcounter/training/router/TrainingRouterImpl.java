package com.example.alexa.pressupcounter.training.router;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.DialogEvent;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;

/**
 * Created by Alexandr Mikhalev on 07.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingRouterImpl implements TrainingRouter {

    private SingleLiveEvent<DialogEvent> mDialogEventForRest;
    private SingleLiveEvent<DialogEvent> mDialogEventForRestOff;
    private SingleLiveEvent<DialogEvent> mDialogEventFinishTraining;

    public TrainingRouterImpl(TrainingFragment fragment) {
        mDialogEventForRest = new SingleLiveEvent<>();
        mDialogEventForRest.observe(fragment, dialogEvent -> fragment.showDialogTrainingRest());

        mDialogEventForRestOff = new SingleLiveEvent<>();
        mDialogEventForRestOff.observe(fragment, dialogEvent -> fragment.showDialogTrainingRestOff());

        mDialogEventFinishTraining = new SingleLiveEvent<>();
        mDialogEventFinishTraining.observe(fragment, dialogEvent -> fragment.showDialogFinishTraining());
    }

    @Override
    public void showDialogTrainingRest() {
        mDialogEventForRest.postValue(new DialogEvent());
    }

    @Override
    public void showDialogTrainingRestOff() {
        mDialogEventForRestOff.postValue(new DialogEvent());
    }

    @Override
    public void showDialogFinishTraining() {
        mDialogEventFinishTraining.postValue(new DialogEvent());
    }
}
