package com.example.alexa.pressupcounter.choisetraining.view;

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
import com.example.alexa.pressupcounter.choisetraining.viewmodel.ChoiseTrainingViewModelImpl;
import com.example.alexa.pressupcounter.databinding.FragmentChoiseTrainingBinding;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.choisetraining.viewmodel.ChoiseTrainingViewModel;

/**
 * Created by Alexandr Mikhalev on 20.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ChoiseTrainingFragment extends Fragment {

    private ChoiseTrainingViewModel mChoiseTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mChoiseTrainingViewModel = ViewModelProviders.of(this).get(ChoiseTrainingViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentChoiseTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choise_training, container, false);
        binding.setViewModel(mChoiseTrainingViewModel);
        return binding.getRoot();
    }

    public static ChoiseTrainingFragment newInstance() {
        Bundle args = new Bundle();
        ChoiseTrainingFragment fragment = new ChoiseTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
