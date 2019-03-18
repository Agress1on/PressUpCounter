package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;

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

    public SetTimeViewModelImpl(SetTimeModel setTimeModel) {
        mSetTimeModel = setTimeModel;
        mFragmentEventLiveData = new MutableLiveData<>();

        mTimePickerEventForFirstDay = new MutableLiveData<>();
        mTimePickerEventForSecondDay = new MutableLiveData<>();
        mTimePickerEventForThirdDay = new MutableLiveData<>();

        mFirstDayTime = new ObservableField<>("Hi");
        mSecondDayTime = new ObservableField<>("Hi");
        mThirdDayTime = new ObservableField<>("Hi");
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
    public void setFirstDayTime(int hours, int minutes) {
        mFirstDayTime.set("Hours: " + hours + " minutes: " + minutes);
    }

    @Override
    public void setSecondDayTime(int hours, int minutes) {
        mSecondDayTime.set("Hours: " + hours + " minutes: " + minutes);
    }

    @Override
    public void setThirdDayTime(int hours, int minutes) {
        mThirdDayTime.set("Hours: " + hours + " minutes: " + minutes);
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
