package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayViewModelImpl extends ViewModel implements SetTrainingDayViewModel {

    private SetTrainingDayModel mSetTrainingDayModel;

    private ObservableField<Boolean> mMonday;
    private ObservableField<Boolean> mTuesday;
    private ObservableField<Boolean> mWednesday;
    private ObservableField<Boolean> mThursday;
    private ObservableField<Boolean> mFriday;
    private ObservableField<Boolean> mSaturday;
    private ObservableField<Boolean> mSunday;

    private ObservableField<Boolean> mButtonState;

    private MutableLiveData<FragmentEvent> mFragmentEventLiveData;

    private ArrayList<Integer> mIndexList;

    public SetTrainingDayViewModelImpl(SetTrainingDayModel setTrainingDayModel) {
        mSetTrainingDayModel = setTrainingDayModel;

        mMonday = new ObservableField<>(false);
        mTuesday = new ObservableField<>(false);
        mWednesday= new ObservableField<>(false);
        mThursday = new ObservableField<>(false);
        mFriday = new ObservableField<>(false);
        mSaturday = new ObservableField<>(false);
        mSunday = new ObservableField<>(false);

        mButtonState = new ObservableField<>(false);

        mFragmentEventLiveData = new MutableLiveData<>();
        mIndexList = new ArrayList();
    }

    @Override
    public ObservableField<Boolean> getMonday() {
        return mMonday;
    }

    @Override
    public ObservableField<Boolean> getTuesday() {
        return mTuesday;
    }

    @Override
    public ObservableField<Boolean> getWednesday() {
        return mWednesday;
    }

    @Override
    public ObservableField<Boolean> getThursday() {
        return mThursday;
    }

    @Override
    public ObservableField<Boolean> getFriday() {
        return mFriday;
    }

    @Override
    public ObservableField<Boolean> getSaturday() {
        return mSaturday;
    }

    @Override
    public ObservableField<Boolean> getSunday() {
        return mSunday;
    }

    @Override
    public MutableLiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public ObservableField<Boolean> getCheckButtonState() {
        return mButtonState;
    }

    @Override
    public ArrayList<Integer> getDaysIndexList() {
        return mIndexList;
    }

    @Override
    public void onCheckedChanged(int i, boolean state) {
        switch (i) {
            case 1: mMonday.set(state); break;
            case 2: mTuesday.set(state) ;break;
            case 3: mWednesday.set(state); break;
            case 4: mThursday.set(state); break;
            case 5: mFriday.set(state); break;
            case 6: mSaturday.set(state); break;
            case 7: mSunday.set(state); break;
        }
        mButtonState.set(checkQuantityDays() == 3);
    }

    @Override
    public void onCheckButton() {
        writeIndexDayOfWeekInList();
        mFragmentEventLiveData.postValue(new FragmentEvent());
    }

    private int checkQuantityDays() {
        int count = 0;
        if (mMonday.get().equals(true)) count++;
        if (mTuesday.get().equals(true)) count++;
        if (mWednesday.get().equals(true)) count++;
        if (mThursday.get().equals(true)) count++;
        if (mFriday.get().equals(true)) count++;
        if (mSaturday.get().equals(true)) count++;
        if (mSunday.get().equals(true)) count++;
        return count;
    }
    private void writeIndexDayOfWeekInList() {
        if (mMonday.get().equals(true)) mIndexList.add(1);
        if (mTuesday.get().equals(true)) mIndexList.add(2);
        if (mWednesday.get().equals(true)) mIndexList.add(3);
        if (mThursday.get().equals(true)) mIndexList.add(4);
        if (mFriday.get().equals(true)) mIndexList.add(5);
        if (mSaturday.get().equals(true)) mIndexList.add(6);
        if (mSunday.get().equals(true)) mIndexList.add(7);
    }
}
