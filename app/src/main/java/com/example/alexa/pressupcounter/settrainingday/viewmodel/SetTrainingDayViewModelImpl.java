package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.settrainingday.interactor.SetTrainingDayInteractor;
import com.example.alexa.pressupcounter.settrainingday.router.SetTrainingDayRouter;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayViewModelImpl extends ViewModel implements SetTrainingDayViewModel {

    private SetTrainingDayInteractor mSetTrainingDayInteractor;
    private SetTrainingDayRouter mSetTrainingDayRouter;

    private List<ObservableField<Boolean>> mDayOfWeekStatesObservableField;
    private ObservableField<Boolean> mButtonState;

    private List<Integer> mIndexList;

    public SetTrainingDayViewModelImpl(SetTrainingDayInteractor setTrainingDayInteractor, SetTrainingDayRouter setTrainingDayRouter) {
        mSetTrainingDayInteractor = setTrainingDayInteractor;
        mSetTrainingDayRouter = setTrainingDayRouter;

        mDayOfWeekStatesObservableField = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mDayOfWeekStatesObservableField.add(new ObservableField<>(false));
        }

        mButtonState = new ObservableField<>(false);
        mIndexList = new ArrayList<>();
    }

    @Override
    public void setCurrentRouter(SetTrainingDayRouter setTrainingDayRouter) {
        mSetTrainingDayRouter = setTrainingDayRouter;
    }

    @Override
    public List<ObservableField<Boolean>> getDayOfWeekState() {
        return mDayOfWeekStatesObservableField;
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
        mDayOfWeekStatesObservableField.get(i).set(state);
        mButtonState.set(checkQuantityDays() == 3);
    }

    @Override
    public void onClickCheckButton() {
        writeIndexDayOfWeekInList();
        mSetTrainingDayRouter.goToSetTime();
    }

    private int checkQuantityDays() {
        int count = 0;
        for (ObservableField<Boolean> item : mDayOfWeekStatesObservableField) {
            if (item.get().equals(true)) count++;
        }
        return count;
    }

    private void writeIndexDayOfWeekInList() {
        for (int i = 0; i < mDayOfWeekStatesObservableField.size(); i++) {
            if (mDayOfWeekStatesObservableField.get(i).get().equals(true)) mIndexList.add(i);
        }
    }
}
