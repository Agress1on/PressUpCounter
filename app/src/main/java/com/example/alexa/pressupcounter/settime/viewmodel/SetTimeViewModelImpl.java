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
        for (int i = 0; i < 3; i++ ) {
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
    public void setFirstDayTime(int hours, int minutes) {
        //mFirstDayTime.set(hours + ":" + minutes);
        mListTime.get().get(0).set(hours + ":" + minutes);
    }

    @Override
    public void setSecondDayTime(int hours, int minutes) {
        //mSecondDayTime.set(hours + ":" + minutes);
        mListTime.get().get(1).set(hours + ":" + minutes);
    }

    @Override
    public void setThirdDayTime(int hours, int minutes) {
        //mThirdDayTime.set(hours + ":" + minutes);
        mListTime.get().get(2).set(hours + ":" + minutes);
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
