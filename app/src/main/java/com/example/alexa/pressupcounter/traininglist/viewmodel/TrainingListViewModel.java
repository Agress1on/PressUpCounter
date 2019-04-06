package com.example.alexa.pressupcounter.traininglist.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.EventForUpdateList;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public interface TrainingListViewModel {

    void onCreateView();

    List<PressUp> getPressUpList();

    ObservableField<Boolean> getProgressBarState();

    LiveData<EventForUpdateList> getEventForUpdateList();
}
