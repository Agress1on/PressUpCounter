package com.example.alexa.pressupcounter.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.alexa.pressupcounter.events.TimePickerEvent;

/**
 * Created by Alexandr Mikhalev on 18.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TimePickerDialog extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener {

    private SetTimeListener mSetTimeListener;
    private TimePickerEvent.DayNotification dayNotification;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof SetTimeListener) {
            mSetTimeListener = (SetTimeListener) getParentFragment();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dayNotification = (TimePickerEvent.DayNotification) getArguments().getSerializable("day");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return new android.app.TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        if (mSetTimeListener == null) return;
        mSetTimeListener.setTime(dayNotification, i, i1);
    }

    public static TimePickerDialog newInstance(TimePickerEvent.DayNotification dayNotification) {
        Bundle args = new Bundle();
        args.putSerializable("day", dayNotification);
        TimePickerDialog fragment = new TimePickerDialog();
        fragment.setArguments(args);
        return fragment;
    }

    public interface SetTimeListener {
        void setTime(TimePickerEvent.DayNotification dayNotification, int hourOfDay, int minute);
    }
}
