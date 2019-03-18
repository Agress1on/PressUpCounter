package com.example.alexa.pressupcounter.utils;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Alexandr Mikhalev on 18.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TimePickerDialogFragment extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener {

    SetTime mSetTime;

    public void init(SetTime setTime) {
        mSetTime = setTime;
    }

    public TimePickerDialogFragment() {
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
            mSetTime.setTime(i, i1);
    }

    public interface SetTime {
        void setTime(int hourOfDay, int minute);
    }
}
