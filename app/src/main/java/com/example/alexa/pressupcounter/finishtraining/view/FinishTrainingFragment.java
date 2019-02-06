package com.example.alexa.pressupcounter.finishtraining.view;

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
import com.example.alexa.pressupcounter.databinding.FragmentFinishTrainingBinding;
import com.example.alexa.pressupcounter.finishtraining.viewmodel.FinishTrainingViewModel;
import com.example.alexa.pressupcounter.finishtraining.viewmodel.FinishTrainingViewModelImpl;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FinishTrainingFragment extends Fragment {

    private FinishTrainingViewModel mFinishTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFinishTrainingViewModel = ViewModelProviders.of(this).get(FinishTrainingViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFinishTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_finish_training, container, false);
        binding.setViewModel(mFinishTrainingViewModel);
        return binding.getRoot();
    }

    public static FinishTrainingFragment newInstance() {
        Bundle args = new Bundle();
        FinishTrainingFragment fragment = new FinishTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
