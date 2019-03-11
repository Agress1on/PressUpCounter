package com.example.alexa.pressupcounter.utils;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexa.pressupcounter.R;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogFinishTraining extends DialogFragment implements View.OnClickListener {

    private OnButtonClick mOnButtonClick;

    public void init(OnButtonClick onButtonClick) {
        mOnButtonClick = onButtonClick;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle("Тренировка закончена");
        getDialog().setCanceledOnTouchOutside(false);
        View v = inflater.inflate(R.layout.dialog_finish_training, null);
        TextView textView = (TextView) v.findViewById(R.id.question_text_view);
        textView.setText(getResources().getString(R.string.for_dialog_finish_training));
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

    public interface OnButtonClick {
        void onPositiveButton();

        void onNegativeButton();
    }
}
