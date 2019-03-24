package com.example.alexa.pressupcounter.settrainingday.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentSetTrainingDayBinding;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModelModule;
import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModel;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelFactory;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelImpl;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayFragment extends Fragment {

    private SetTrainingDayViewModel mSetTrainingDayViewModel;

    /*
    @Inject
    SetTrainingDayModel mSetTrainingDayModel;
    */

    @Inject
    SetTrainingDayModel mSetTrainingDayModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //App.getAppComponent().injectsSetTrainingDayFragment(this);

        App.getAppComponent().createSetTrainingDayModelComponent(new SetTrainingDayModelModule()).inject(this);
        //SetTrainingDayModel setTrainingDayModel = new SetTrainingDayModel();
        mSetTrainingDayViewModel = ViewModelProviders.of(this, new SetTrainingDayViewModelFactory(mSetTrainingDayModel)).get(SetTrainingDayViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTrainingDayBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_training_day, container, false);
        binding.setViewModel(mSetTrainingDayViewModel);
        return binding.getRoot();
    }

    private void init() {
        mSetTrainingDayViewModel.getFragmentEventLiveData().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappened()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, SetTimeFragment.newInstance(mSetTrainingDayViewModel.getDaysIndexList()))
                        .commit();
                fragmentEvent.setHappened(true);
            }
        });
    }

    public static SetTrainingDayFragment newInstance() {
        Bundle args = new Bundle();
        SetTrainingDayFragment fragment = new SetTrainingDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
