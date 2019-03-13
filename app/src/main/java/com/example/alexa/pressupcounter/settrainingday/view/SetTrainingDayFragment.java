package com.example.alexa.pressupcounter.settrainingday.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSetTrainingDayBinding;
import com.example.alexa.pressupcounter.settrainingday.model.SetTrainingDayModel;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModel;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelFactory;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModelImpl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayFragment extends Fragment {

    private SetTrainingDayViewModel mSetTrainingDayViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SetTrainingDayModel setTrainingDayModel = new SetTrainingDayModel();
        mSetTrainingDayViewModel = ViewModelProviders.of(this, new SetTrainingDayViewModelFactory(setTrainingDayModel)).get(SetTrainingDayViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTrainingDayBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_training_day, container, false);
        binding.setViewModel(mSetTrainingDayViewModel);
        return binding.getRoot();
    }

    public static SetTrainingDayFragment newInstance() {
        Bundle args = new Bundle();
        SetTrainingDayFragment fragment = new SetTrainingDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
