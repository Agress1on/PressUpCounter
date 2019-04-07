package com.example.alexa.pressupcounter.settime.viewmodel;

import com.example.alexa.pressupcounter.settime.model.SetTimeModel;
import com.example.alexa.pressupcounter.settime.router.SetTimeRouter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final SetTimeModel mSetTimeModel;
    private final SetTimeRouter mSetTimeRouter;
    private final ArrayList<Integer> mIndexList;

    public SetTimeViewModelFactory(SetTimeModel setTimeModel, SetTimeRouter router, ArrayList<Integer> indexList) {
        super();
        mSetTimeModel = setTimeModel;
        mSetTimeRouter = router;
        mIndexList = indexList;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == SetTimeViewModelImpl.class) {
            return (T) new SetTimeViewModelImpl(mSetTimeModel, mSetTimeRouter, mIndexList);
        }
        return null;
    }
}
