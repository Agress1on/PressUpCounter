package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.EventForUpdateList;
import com.example.alexa.pressupcounter.traininglist.router.TrainingListRouter;

import java.util.List;

import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingListViewModel {

    void setRouter(TrainingListRouter trainingListRouter);

    List<PressUp> getPressUpList();

    ObservableField<Boolean> getProgressBarState();

    SingleLiveEvent<EventForUpdateList> getEventForUpdateList();

    void onClickHomeView();
}
