package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelImpl extends ViewModel implements SetTimeViewModel {

    private SetTimeModel mSetTimeModel;
    private LiveData<FragmentEvent> mFragmentEventLiveData;

    private LiveData<TimePickerEvent> mTimePickerEventForFirstDay;
    private LiveData<TimePickerEvent> mTimePickerEventForSecondDay;
    private LiveData<TimePickerEvent> mTimePickerEventForThirdDay;

    private ObservableField<List<ObservableField<String>>> mListTime;

    private ArrayList<Integer> mIndexList;

    private ObservableField<String> mInfoText;

    public SetTimeViewModelImpl(SetTimeModel setTimeModel, ArrayList<Integer> indexList) {
        mSetTimeModel = setTimeModel;
        mFragmentEventLiveData = new SingleLiveEvent<>();

        mTimePickerEventForFirstDay = new SingleLiveEvent<>();
        mTimePickerEventForSecondDay = new SingleLiveEvent<>();
        mTimePickerEventForThirdDay = new SingleLiveEvent<>();

        List<ObservableField<String>> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new ObservableField<>(Constants.TEXT_FOR_SET_TIME_STRING));
        }
        mListTime = new ObservableField<>(list);

        mIndexList = indexList;
        mInfoText = new ObservableField<>(mIndexList.get(0) + " " + mIndexList.get(1) + " " + mIndexList.get(2));
    }

    @Override
    public ObservableField<List<ObservableField<String>>> getListTime() {
        return mListTime;
    }

    @Override
    public ObservableField<String> getTextInfo() {
        return mInfoText;
    }

    @Override
    public LiveData<TimePickerEvent> getFirstDayTimePickerEvent() {
        return mTimePickerEventForFirstDay;
    }

    @Override
    public LiveData<TimePickerEvent> getSecondDayTimePickerEvent() {
        return mTimePickerEventForSecondDay;
    }

    @Override
    public LiveData<TimePickerEvent> getThirdDayTimePickerEvent() {
        return mTimePickerEventForThirdDay;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public void setDayTime(TimePickerEvent.DayNotification dayNotification, int hours, int minutes) {
        switch (dayNotification) {
            case FIRST_DAY:
                mListTime.get().get(0).set(hours + ":" + minutes);
                break;
            case SECOND_DAY:
                mListTime.get().get(1).set(hours + ":" + minutes);
                break;
            case THIRD_DAY:
                mListTime.get().get(2).set(hours + ":" + minutes);
                break;
        }
    }

    @Override
    public void onClickSetTime(TimePickerEvent.DayNotification dayNotification) {
        switch (dayNotification) {
            case FIRST_DAY:
                ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForFirstDay).postValue(new TimePickerEvent(TimePickerEvent.DayNotification.FIRST_DAY));
                break;
            case SECOND_DAY:
                ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForSecondDay).postValue(new TimePickerEvent(TimePickerEvent.DayNotification.SECOND_DAY));
                break;
            case THIRD_DAY:
                ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForThirdDay).postValue(new TimePickerEvent(TimePickerEvent.DayNotification.THIRD_DAY));
                break;
        }
    }

    @Override
    public void onClickSetTimeButton() {
        //mFragmentEventLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mFragmentEventLiveData).postValue(new FragmentEvent());
    }
}
