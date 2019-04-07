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
import com.example.alexa.pressupcounter.settrainingday.inject.SetTrainingDayModule;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayFragment extends Fragment {

    @Inject
    SetTrainingDayViewModel mSetTrainingDayViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createSetTrainingDayModelComponent(new SetTrainingDayModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTrainingDayBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_training_day, container, false);
        binding.setViewModel(mSetTrainingDayViewModel);
        return binding.getRoot();
    }

    public void goToSetTime() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetTimeFragment.newInstance(mSetTrainingDayViewModel.getDaysIndexList()))
                .commit();
    }

    public static SetTrainingDayFragment newInstance() {
        Bundle args = new Bundle();
        SetTrainingDayFragment fragment = new SetTrainingDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
