package com.example.alexa.pressupcounter.training.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.training.TrainingViewModelFactory;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelImpl;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingFragment extends Fragment {

    private TrainingViewModel mTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTrainingViewModel = ViewModelProviders.of(this, new TrainingViewModelFactory()).get(TrainingViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false);
        binding.setViewModel(mTrainingViewModel);
        return binding.getRoot();
    }

    /*
    public static TrainingFragment newInstance(int firstRepetition, int secondRepetition, int thirdRepetition, int fourthRepetition, int fifthRepetition) {
        Bundle args = new Bundle();
        args.putInt(Constants.KEY_FOR_FIRST_REPETITION, firstRepetition);
        args.putInt(Constants.KEY_FOR_SECOND_REPETITION, secondRepetition);
        args.putInt(Constants.KEY_FOR_THIRD_REPETITION, thirdRepetition);
        args.putInt(Constants.KEY_FOR_FOURTH_REPETITION, fourthRepetition);
        args.putInt(Constants.KEY_FOR_FIFTH_REPETITION, fifthRepetition);
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
    */

    public static TrainingFragment newInstance() {
        Bundle args = new Bundle();
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
