package com.example.alexa.pressupcounter.dialogs;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogTrainingRestOff extends DialogFragment implements View.OnClickListener {

    private OnButtonClick mOnButtonClick;

    public void initDialog(OnButtonClick onButtonClick) {
        mOnButtonClick = onButtonClick;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Удалось сделать подход?");
        getDialog().setCanceledOnTouchOutside(false);
        View v = inflater.inflate(R.layout.dialog_training_rest_off, null);
        v.findViewById(R.id.positive_button).setOnClickListener(this);
        v.findViewById(R.id.negative_button).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.positive_button:
                mOnButtonClick.onPositiveButton();
                break;
            case R.id.negative_button:
                mOnButtonClick.onNegativeButton();
                break;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mOnButtonClick.onNegativeButton();
    }

    public interface OnButtonClick {
        void onPositiveButton();

        void onNegativeButton();
    }
}
