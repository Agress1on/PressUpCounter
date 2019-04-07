package com.example.alexa.pressupcounter.settrainingday.viewmodel;

import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;
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

    private SetTrainingDayModel mSetTrainingDayModel;
    private SetTrainingDayRouter mSetTrainingDayRouter;

    private ObservableField<List<ObservableField<Boolean>>> mDayOfWeekStatesObservableField;
    private ObservableField<Boolean> mButtonState;

    private List<Integer> mIndexList;

    public SetTrainingDayViewModelImpl(SetTrainingDayModel setTrainingDayModel, SetTrainingDayRouter setTrainingDayRouter) {
        mSetTrainingDayModel = setTrainingDayModel;
        mSetTrainingDayRouter = setTrainingDayRouter;

        List<ObservableField<Boolean>> states = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            states.add(new ObservableField<>(false));
        }
        mDayOfWeekStatesObservableField = new ObservableField<>(states);

        mButtonState = new ObservableField<>(false);
        mIndexList = new ArrayList();
    }

    @Override
    public ObservableField<List<ObservableField<Boolean>>> getDayOfWeekState() {
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
        mDayOfWeekStatesObservableField.get().get(i).set(state);
        mButtonState.set(checkQuantityDays() == 3);
    }

    @Override
    public void onCheckButton() {
        writeIndexDayOfWeekInList();
        mSetTrainingDayRouter.goToSetTime();
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
