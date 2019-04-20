package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.events.UpdateListEvent;
import com.example.alexa.pressupcounter.traininglist.router.TrainingListRouter;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingListViewModel {

    void setCurrentRouter(TrainingListRouter trainingListRouter);

    List<Program> getProgramList();

    ObservableField<Boolean> getProgressBarState();

    SingleLiveEvent<UpdateListEvent> getEventForUpdateList();

    void onClickHomeView();
}
