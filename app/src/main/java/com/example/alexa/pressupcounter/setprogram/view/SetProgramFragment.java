package com.example.alexa.pressupcounter.setprogram.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentSetProgramBinding;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.setprogram.inject.SetProgramModelModule;
import com.example.alexa.pressupcounter.setprogram.model.SetProgramModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelFactory;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelImpl;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.AndroidInjection;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramFragment extends Fragment {

    @Inject
    SetProgramViewModel mSetProgramViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createSetProgramModelComponent(new SetProgramModelModule(this)).inject(this);
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
                if (fragmentEvent == null || fragmentEvent.isHappened()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, SetTrainingDayFragment.newInstance())
                        .commit();
                fragmentEvent.setHappened(true);
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
