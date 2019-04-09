package com.example.alexa.pressupcounter.starttraining.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentStartTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.ExclamationDialog;
import com.example.alexa.pressupcounter.settings.view.SettingsFragment;
import com.example.alexa.pressupcounter.starttraining.inject.StartTrainingModule;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModel;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;
import com.example.alexa.pressupcounter.traininglist.view.TrainingListFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingFragment extends Fragment {

    @Inject
    StartTrainingViewModel mStartTrainingViewModel;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentStartTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_training, container, false);
        binding.setViewModel(mStartTrainingViewModel);
        mStartTrainingViewModel.onCreateView();
        ExclamationDialog exclamationDialog = new ExclamationDialog();
        exclamationDialog.show(getFragmentManager(), "TAG");
        return binding.getRoot();
    }


    public void goToTraining() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, TrainingFragment.newInstance())
                .commit();
    }

    public void goToTrainingList() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, TrainingListFragment.newInstance())
                .commit();
    }

    public void goToSettings() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SettingsFragment.newInstance())
                .commit();
    }

    public static StartTrainingFragment newInstance() {
        Bundle args = new Bundle();
        StartTrainingFragment fragment = new StartTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
