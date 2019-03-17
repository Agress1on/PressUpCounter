package com.example.alexa.pressupcounter.settime.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSetTimeBinding;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelFactory;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelImpl;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeFragment extends Fragment {

    private SetTimeViewModel mSetTimeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SetTimeModel setTimeModel = new SetTimeModel();
        mSetTimeViewModel = ViewModelProviders.of(this, new SetTimeViewModelFactory(setTimeModel)).get(SetTimeViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTimeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_time, container, false);
        binding.setViewModel(mSetTimeViewModel);
        return binding.getRoot();
    }

    private void init() {
        mSetTimeViewModel.getFragmentEventLiveData().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static SetTimeFragment newInstance() {
        Bundle args = new Bundle();
        SetTimeFragment fragment = new SetTimeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
