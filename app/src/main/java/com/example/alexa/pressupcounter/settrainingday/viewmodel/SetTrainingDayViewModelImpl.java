package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayViewModelImpl extends ViewModel implements SetTrainingDayViewModel {

    private SetTrainingDayModel mSetTrainingDayModel;

    private ObservableField<List<ObservableField<Boolean>>> mDayOfWeekStatesObservableField;
    private ObservableField<Boolean> mButtonState;

    private LiveData<FragmentEvent> mFragmentEventLiveData;

    private List<Integer> mIndexList;

    public SetTrainingDayViewModelImpl(SetTrainingDayModel setTrainingDayModel) {
        mSetTrainingDayModel = setTrainingDayModel;

        List<ObservableField<Boolean>> states = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            states.add(new ObservableField<>(false));
        }
        mDayOfWeekStatesObservableField = new ObservableField<>(states);

        mButtonState = new ObservableField<>(false);
        mFragmentEventLiveData = new SingleLiveEvent<>();
        mIndexList = new ArrayList();
    }

    @Override
    public ObservableField<List<ObservableField<Boolean>>> getDayOfWeekState() {
        return mDayOfWeekStatesObservableField;
    }

    @Override
    public LiveData<FragmentEvent> getFragmentEventLiveData() {
        return mFragmentEventLiveData;
    }

    @Override
    public ObservableField<Boolean> getCheckButtonState() {
        return mButtonState;
    }

    @Override
    public List<Integer> getDaysIndexList() {
        return mIndexList;
    }

    @Override
    public void onCheckedChanged(int i, boolean state) {
        mDayOfWeekStatesObservableField.get().get(i).set(state);
        mButtonState.set(checkQuantityDays() == 3);
    }

    @Override
    public void onCheckButton() {
        writeIndexDayOfWeekInList();
        //mFragmentEventLiveData.postValue(new FragmentEvent());
        ((SingleLiveEvent<FragmentEvent>) mFragmentEventLiveData).postValue(new FragmentEvent());
    }

    private int checkQuantityDays() {
        int count = 0;
        for (ObservableField<Boolean> item : mDayOfWeekStatesObservableField.get()) {
            if (item.get().equals(true)) count++;
        }
        return count;
    }

    private void writeIndexDayOfWeekInList() {
        for (int i = 0; i < mDayOfWeekStatesObservableField.get().size(); i++) {
            if (mDayOfWeekStatesObservableField.get().get(i).get().equals(true)) mIndexList.add(i);
        }
    }
}
