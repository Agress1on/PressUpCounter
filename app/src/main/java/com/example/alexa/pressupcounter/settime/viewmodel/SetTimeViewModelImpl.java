package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import java.util.ArrayList;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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

    private ObservableField<String> mFirstDayTime;
    private ObservableField<String> mSecondDayTime;
    private ObservableField<String> mThirdDayTime;

    private ArrayList<Integer> mIndexList;
    private int mFirstDayIndex;
    private int mSecondDayIndex;
    private int mThirdDayIndex;
    private ObservableField<String> mInfoText;

    public SetTimeViewModelImpl(SetTimeModel setTimeModel, ArrayList<Integer> indexList) {
        mSetTimeModel = setTimeModel;
        mFragmentEventLiveData = new SingleLiveEvent<>();

        mTimePickerEventForFirstDay = new SingleLiveEvent<>();
        mTimePickerEventForSecondDay = new SingleLiveEvent<>();
        mTimePickerEventForThirdDay = new SingleLiveEvent<>();

        mFirstDayTime = new ObservableField<>(Constants.TEXT_FOR_SET_TIME_STRING);
        mSecondDayTime = new ObservableField<>(Constants.TEXT_FOR_SET_TIME_STRING);
        mThirdDayTime = new ObservableField<>(Constants.TEXT_FOR_SET_TIME_STRING);

        mIndexList = indexList;
        mFirstDayIndex = mIndexList.get(0);
        mSecondDayIndex = mIndexList.get(1);
        mThirdDayIndex = mIndexList.get(2);
        mInfoText = new ObservableField<>(mFirstDayIndex + " " + mSecondDayIndex + " " + mThirdDayIndex);
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public LiveData<TimePickerEvent> getTimePickerEventForFirstDay() {
        return mTimePickerEventForFirstDay;
    }

    @Override
    public LiveData<TimePickerEvent> getTimePickerEventForSecondDay() {
        return mTimePickerEventForSecondDay;
    }

    @Override
    public LiveData<TimePickerEvent> getTimePickerEventForThirdDay() {
        return mTimePickerEventForThirdDay;
    }

    @Override
    public ObservableField<String> getFirstDayTime() {
        return mFirstDayTime;
    }

    @Override
    public ObservableField<String> getSecondDayTime() {
        return mSecondDayTime;
    }

    @Override
    public ObservableField<String> getThirdDayTime() {
        return mThirdDayTime;
    }

    @Override
    public ObservableField<String> getTextInfo() {
        return mInfoText;
    }

    @Override
    public void setFirstDayTime(int hours, int minutes) {
        mFirstDayTime.set(hours + ":" + minutes);
    }

    @Override
    public void setSecondDayTime(int hours, int minutes) {
        mSecondDayTime.set(hours + ":" + minutes);
    }

    @Override
    public void setThirdDayTime(int hours, int minutes) {
        mThirdDayTime.set(hours + ":" + minutes);
    }

    @Override
    public void onClickSetFirstDayTime() {
        //mTimePickerEventForFirstDay.postValue(new TimePickerEvent());
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForFirstDay).postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetSecondDayTime() {
        //mTimePickerEventForSecondDay.postValue(new TimePickerEvent());
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForSecondDay).postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetThirdDayTime() {
        //mTimePickerEventForThirdDay.postValue(new TimePickerEvent());
        ((SingleLiveEvent<TimePickerEvent>) mTimePickerEventForThirdDay).postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetTimeButton() {
        //mFragmentEventLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mFragmentEventLiveData).postValue(new FragmentEvent());
    }
}
