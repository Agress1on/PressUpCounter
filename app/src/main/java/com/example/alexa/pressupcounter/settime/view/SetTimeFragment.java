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
import com.example.alexa.pressupcounter.events.FragmentEvent;
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
import androidx.lifecycle.Observer;

/**
 * Created by Alexandr Mikhalev on 17.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetTimeFragment extends Fragment {

    @Inject
    SetTimeViewModel mSetTimeViewModel;
    private ArrayList<Integer> mIndexList;

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
        mSetTimeViewModel.getFragmentEventLiveData().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                        .commit();
            }
        });


        //TP for first day
        final TimePickerDialogFragment timePickerDialogForFirst = new TimePickerDialogFragment();
        timePickerDialogForFirst.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                mSetTimeViewModel.setFirstDayTime(hourOfDay, minute);
            }
        });

        mSetTimeViewModel.getFirstDayTimePickerEvent().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                timePickerDialogForFirst.show(getActivity().getSupportFragmentManager(), "TAAAG");
            }
        });

        //TP for second day
        final TimePickerDialogFragment timePickerDialogForSecond = new TimePickerDialogFragment();
        timePickerDialogForSecond.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                mSetTimeViewModel.setSecondDayTime(hourOfDay, minute);
            }
        });

        mSetTimeViewModel.getSecondDayTimePickerEvent().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                timePickerDialogForSecond.show(getActivity().getSupportFragmentManager(), "TAAAG");
            }
        });

        //TP for third day
        final TimePickerDialogFragment timePickerDialogForThird = new TimePickerDialogFragment();
        timePickerDialogForThird.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                mSetTimeViewModel.setThirdDayTime(hourOfDay, minute);
            }
        });

        mSetTimeViewModel.getThirdDayTimePickerEvent().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                timePickerDialogForThird.show(getActivity().getSupportFragmentManager(), "TAAAG");
            }
        });
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
