package com.example.alexa.pressupcounter.settime.inject;

import com.example.alexa.pressupcounter.settime.model.SetTimeModel;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelFactory;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelImpl;

import java.util.ArrayList;

import javax.inject.Named;

import androidx.lifecycle.ViewModelProviders;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
@Module
public class SetTimeModule {

    private SetTimeFragment mFragment;
    private ArrayList<Integer> mIndexList;

    public SetTimeModule(SetTimeFragment fragment, ArrayList<Integer> indexList) {
        mFragment = fragment;
        mIndexList = indexList;
    }

    @SetTimeScope
    @Provides
    SetTimeViewModel provideSetTimeViewModel(SetTimeViewModelFactory factory) {
        return ViewModelProviders.of(mFragment, factory).get(SetTimeViewModelImpl.class);
    }

    @SetTimeScope
    @Provides
    SetTimeViewModelFactory provideFactory(SetTimeModel model) {
        return new SetTimeViewModelFactory(model, mIndexList);
    }

    @SetTimeScope
    @Provides
    SetTimeModel provideSetTimeModel() {
        return new SetTimeModel();
    }

    @SetTimeScope
    @Provides
    @Named("indexList")
    ArrayList<Integer> provideList() {
        return mIndexList;
    }
}
