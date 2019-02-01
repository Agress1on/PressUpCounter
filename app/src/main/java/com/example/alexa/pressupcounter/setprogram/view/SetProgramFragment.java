package com.example.alexa.pressupcounter.setprogram.view;

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
import com.example.alexa.pressupcounter.databinding.FragmentSetProgramBinding;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelImpl;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramFragment extends Fragment {

    private SetProgramViewModel mSetProgramViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSetProgramViewModel = ViewModelProviders.of(this).get(SetProgramViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetProgramBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_program, container, false);
        binding.setViewModel(mSetProgramViewModel);
        return binding.getRoot();
    }

    private void init() {
        mSetProgramViewModel.getFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(@Nullable FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, TrainingFragment.newInstance(mSetProgramViewModel.getPressUp().get()))
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static SetProgramFragment newInstance() {
        Bundle args = new Bundle();
        SetProgramFragment fragment = new SetProgramFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
