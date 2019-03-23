package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

import java.util.ArrayList;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelImpl extends ViewModel implements SetTimeViewModel {

    private SetTimeModel mSetTimeModel;
    private MutableLiveData<FragmentEvent> mFragmentEventLiveData;

    private MutableLiveData<TimePickerEvent> mTimePickerEventForFirstDay;
    private MutableLiveData<TimePickerEvent> mTimePickerEventForSecondDay;
    private MutableLiveData<TimePickerEvent> mTimePickerEventForThirdDay;

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
        mFragmentEventLiveData = new MutableLiveData<>();

        mTimePickerEventForFirstDay = new MutableLiveData<>();
        mTimePickerEventForSecondDay = new MutableLiveData<>();
        mTimePickerEventForThirdDay = new MutableLiveData<>();

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
    public MutableLiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public MutableLiveData<TimePickerEvent> getTimePickerEventForFirstDay() {
        return mTimePickerEventForFirstDay;
    }

    @Override
    public MutableLiveData<TimePickerEvent> getTimePickerEventForSecondDay() {
        return mTimePickerEventForSecondDay;
    }

    @Override
    public MutableLiveData<TimePickerEvent> getTimePickerEventForThirdDay() {
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
        mTimePickerEventForFirstDay.postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetSecondDayTime() {
        mTimePickerEventForSecondDay.postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetThirdDayTime() {
        mTimePickerEventForThirdDay.postValue(new TimePickerEvent());
    }

    @Override
    public void onClickSetTimeButton() {
        mFragmentEventLiveData.postValue(new FragmentEvent());
    }
}