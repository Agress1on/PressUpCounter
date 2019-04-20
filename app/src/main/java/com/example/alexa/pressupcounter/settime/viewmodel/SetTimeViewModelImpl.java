package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.interactor.SetTimeInteractor;
import com.example.alexa.pressupcounter.settime.router.SetTimeRouter;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelImpl extends ViewModel implements SetTimeViewModel {

    private SetTimeInteractor mSetTimeInteractor;
    private SetTimeRouter mSetTimeRouter;

    private List<ObservableField<String>> mListTime;

    private ArrayList<Integer> mIndexList;

    private ObservableField<String> mInfoText;

    public SetTimeViewModelImpl(SetTimeInteractor setTimeInteractor, SetTimeRouter setTimeRouter, ArrayList<Integer> indexList) {
        mSetTimeInteractor = setTimeInteractor;
        mSetTimeRouter = setTimeRouter;

        mListTime = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            mListTime.add(new ObservableField<>(Constants.TEXT_FOR_SET_TIME_STRING));
        }

        mIndexList = indexList;
        mInfoText = new ObservableField<>(mIndexList.get(0) + " " + mIndexList.get(1) + " " + mIndexList.get(2));
    }

    @Override
    public void setCurrentRouter(SetTimeRouter setTimeRouter) {
        mSetTimeRouter = setTimeRouter;
    }

    @Override
    public List<ObservableField<String>> getListTime() {
        return mListTime;
    }

    @Override
    public ObservableField<String> getTextInfo() {
        return mInfoText;
    }

    @Override
    public void setDayTime(TimePickerEvent.DayNotification dayNotification, int hours, int minutes) {
        switch (dayNotification) {
            case FIRST_DAY:
                mListTime.get(0).set(hours + ":" + minutes);
                break;
            case SECOND_DAY:
                mListTime.get(1).set(hours + ":" + minutes);
                break;
            case THIRD_DAY:
                mListTime.get(2).set(hours + ":" + minutes);
                break;
        }
    }

    @Override
    public void onClickSetTime(TimePickerEvent.DayNotification dayNotification) {
        switch (dayNotification) {
            case FIRST_DAY:
                mSetTimeRouter.showTimePickerForFirstDay();
                break;
            case SECOND_DAY:
                mSetTimeRouter.showTimePickerForSecondDay();
                break;
            case THIRD_DAY:
                mSetTimeRouter.showTimePickerForThirdDay();
                break;
        }
    }

    @Override
    public void onClickSetTimeButton() {
        mSetTimeRouter.goStartTraining();
    }
}
