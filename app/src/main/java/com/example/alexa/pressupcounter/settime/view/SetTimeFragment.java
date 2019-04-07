package com.example.alexa.pressupcounter.settime.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentSetTimeBinding;
import com.example.alexa.pressupcounter.dialogs.TimePickerDialogFragment;
import com.example.alexa.pressupcounter.events.TimePickerEvent;
import com.example.alexa.pressupcounter.settime.inject.SetTimeModule;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeFragment extends Fragment {

    @Inject
    SetTimeViewModel mSetTimeViewModel;

    private ArrayList<Integer> mIndexList;
    private TimePickerDialogFragment mFirstDayTimePickerEvent;
    private TimePickerDialogFragment mSecondDayTimePickerEvent;
    private TimePickerDialogFragment mThirdDayTimePickerEvent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIndexList = getArguments().getIntegerArrayList(Constants.KEY_FOR_SET_TIME_BUNDLE);
        App.getAppComponent().createSetTimeComponent(new SetTimeModule(this, mIndexList)).inject(this);
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
        //TP for first day
        mFirstDayTimePickerEvent = new TimePickerDialogFragment();
        mFirstDayTimePickerEvent.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                //mSetTimeViewModel.setFirstDayTime(hourOfDay, minute);
                mSetTimeViewModel.setDayTime(TimePickerEvent.DayNotification.FIRST_DAY, hourOfDay, minute);
            }
        });

        //TP for second day
        mSecondDayTimePickerEvent = new TimePickerDialogFragment();
        mSecondDayTimePickerEvent.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                //mSetTimeViewModel.setSecondDayTime(hourOfDay, minute);
                mSetTimeViewModel.setDayTime(TimePickerEvent.DayNotification.SECOND_DAY, hourOfDay, minute);
            }
        });

        //TP for third day
        mThirdDayTimePickerEvent = new TimePickerDialogFragment();
        mThirdDayTimePickerEvent.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                //mSetTimeViewModel.setThirdDayTime(hourOfDay, minute);
                mSetTimeViewModel.setDayTime(TimePickerEvent.DayNotification.THIRD_DAY, hourOfDay, minute);
            }
        });
    }

    public void goToStartTraining() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public void showTimePickerForFirstDay() {
        mFirstDayTimePickerEvent.show(getActivity().getSupportFragmentManager(), "TAAAG");
    }

    public void showTimePickerForSecondDay() {
        mSecondDayTimePickerEvent.show(getActivity().getSupportFragmentManager(), "TAAAG");
    }

    public void showTimePickerForThirdDay() {
        mThirdDayTimePickerEvent.show(getActivity().getSupportFragmentManager(), "TAAAG");
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
