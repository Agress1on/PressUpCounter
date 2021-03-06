package com.example.alexa.pressupcounter.settrainingday.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSetTrainingDayBinding;
import com.example.alexa.pressupcounter.settime.view.SetTimeFragment;
import com.example.alexa.pressupcounter.settrainingday.router.SetTrainingDayRouter;
import com.example.alexa.pressupcounter.settrainingday.viewmodel.SetTrainingDayViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 13.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTrainingDayFragment extends Fragment {

    @Inject
    SetTrainingDayViewModel mSetTrainingDayViewModel;

    @Inject
    SetTrainingDayRouter mSetTrainingDayRouter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTrainingDayBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_training_day, container, false);
        binding.setViewModel(mSetTrainingDayViewModel);
        mSetTrainingDayViewModel.setCurrentRouter(mSetTrainingDayRouter);
        return binding.getRoot();
    }

    public void setSetTime() {
        if (getActivity() == null) return;
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetTimeFragment.newInstance(mSetTrainingDayViewModel.getDaysIndexList()))
                .commit();
    }

    public static SetTrainingDayFragment newInstance() {
        Bundle args = new Bundle();
        SetTrainingDayFragment fragment = new SetTrainingDayFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
