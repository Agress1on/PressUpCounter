package com.example.alexa.pressupcounter.start.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentStartBinding;
import com.example.alexa.pressupcounter.start.viewmodel.StartViewModel;
import com.example.alexa.pressupcounter.start.viewmodel.StartViewModelImpl;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartFragment extends Fragment {

    private StartViewModel mStartViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStartViewModel = ViewModelProviders.of(this).get(StartViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentStartBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false);
        binding.setViewModel(mStartViewModel);
        return binding.getRoot();
    }

    private void init() {
        mStartViewModel.getFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(@Nullable FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, TrainingFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static StartFragment newInstance() {
        Bundle args = new Bundle();
        StartFragment fragment = new StartFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
