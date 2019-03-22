package com.example.alexa.pressupcounter.settime.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.TimePickerEvent;
import com.example.alexa.pressupcounter.databinding.FragmentSetTimeBinding;
import com.example.alexa.pressupcounter.settime.model.SetTimeModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModel;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelFactory;
import com.example.alexa.pressupcounter.settime.viewmodel.SetTimeViewModelImpl;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;
import com.example.alexa.pressupcounter.utils.TimePickerDialogFragment;

import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<Integer> mIndexList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mIndexList = getArguments().getIntegerArrayList(Constants.KEY_FOR_SET_TIME_BUNDLE);
        SetTimeModel setTimeModel = new SetTimeModel();
        mSetTimeViewModel = ViewModelProviders.of(this, new SetTimeViewModelFactory(setTimeModel, mIndexList)).get(SetTimeViewModelImpl.class);
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


        //TP for first day
        final TimePickerDialogFragment timePickerDialogForFirst = new TimePickerDialogFragment();
        timePickerDialogForFirst.init(new TimePickerDialogFragment.SetTime() {
            @Override
            public void setTime(int hourOfDay, int minute) {
                mSetTimeViewModel.setFirstDayTime(hourOfDay, minute);
            }
        });

        mSetTimeViewModel.getTimePickerEventForFirstDay().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                if (timePickerEvent == null || timePickerEvent.isHappened()) return;
                timePickerDialogForFirst.show(getActivity().getSupportFragmentManager(), "TAAAG");
                timePickerEvent.setHappened(true);
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

        mSetTimeViewModel.getTimePickerEventForSecondDay().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                if (timePickerEvent == null || timePickerEvent.isHappened()) return;
                timePickerDialogForSecond.show(getActivity().getSupportFragmentManager(), "TAAAG");
                timePickerEvent.setHappened(true);
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

        mSetTimeViewModel.getTimePickerEventForThirdDay().observe(this, new Observer<TimePickerEvent>() {
            @Override
            public void onChanged(TimePickerEvent timePickerEvent) {
                if (timePickerEvent == null || timePickerEvent.isHappened()) return;
                timePickerDialogForThird.show(getActivity().getSupportFragmentManager(), "TAAAG");
                timePickerEvent.setHappened(true);
            }
        });
    }

    public static SetTimeFragment newInstance(ArrayList<Integer> indexList) {
        Bundle args = new Bundle();
        args.putSerializable(Constants.KEY_FOR_SET_TIME_BUNDLE, indexList);
        SetTimeFragment fragment = new SetTimeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
