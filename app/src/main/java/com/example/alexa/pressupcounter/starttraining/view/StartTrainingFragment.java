package com.example.alexa.pressupcounter.starttraining.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentStartTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.ExclamationDialog;
import com.example.alexa.pressupcounter.events.FragmentEvent;
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
import androidx.lifecycle.Observer;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingFragment extends Fragment {

    @Inject
    StartTrainingViewModel mStartTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createStartTrainingModelComponent(new StartTrainingModule(this)).inject(this);
        init();

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

    private void init() {
        mStartTrainingViewModel.getGoToTrainingFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(@Nullable FragmentEvent fragmentEvent) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, TrainingFragment.newInstance())
                        .commit();
            }
        });

        mStartTrainingViewModel.getGoToListFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, TrainingListFragment.newInstance())
                        .commit();
            }
        });

        mStartTrainingViewModel.getForGoToSettingsFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, SettingsFragment.newInstance())
                        .commit();
            }
        });
    }

    public static StartTrainingFragment newInstance() {
        Bundle args = new Bundle();
        StartTrainingFragment fragment = new StartTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
