package com.example.alexa.pressupcounter.settime.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSetTimeBinding;
import com.example.alexa.pressupcounter.dialogs.TimePickerDialog;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.router.SetTimeRouter;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeFragment extends Fragment implements TimePickerDialog.SetTimeListener {

    @Inject
    SetTimeViewModel mSetTimeViewModel;

    @Inject
    SetTimeRouter mSetTimeRouter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetTimeBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_time, container, false);
        binding.setViewModel(mSetTimeViewModel);
        mSetTimeViewModel.setCurrentRouter(mSetTimeRouter);
        return binding.getRoot();
    }

    public void setStartTraining() {
        if (getActivity() == null) return;
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public void showTimePickerDialog(TimePickerEvent.DayNotification dayNotification) {
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(dayNotification);
//        timePickerDialog.setSetTimeListener((hourOfDay, minute)
//                -> mSetTimeViewModel.setDayTime(dayNotification, hourOfDay, minute));
        timePickerDialog.show(getChildFragmentManager(), "TAG");
    }

    @Override
    public void setTime(TimePickerEvent.DayNotification dayNotification, int hourOfDay, int minute) {
        mSetTimeViewModel.setDayTime(dayNotification, hourOfDay, minute);
    }

    public static SetTimeFragment newInstance(List<Integer> indexList) {
        ArrayList<Integer> list = (ArrayList<Integer>) indexList;
        Bundle args = new Bundle();
        args.putSerializable(Constants.KEY_FOR_SET_TIME_BUNDLE, list);
        SetTimeFragment fragment = new SetTimeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
