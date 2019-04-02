package com.example.alexa.pressupcounter.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.alexa.pressupcounter.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogTrainingRestOff extends DialogFragment implements View.OnClickListener {

    private OnButtonClick mOnButtonClick;
    private TextView mPositiveButton;
    private TextView mNegativeButton;
    private TextView mQuestion;

    public void initDialog(OnButtonClick onButtonClick) {
        mOnButtonClick = onButtonClick;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setWindow();
        View view = inflater.inflate(R.layout.dialog_training_rest_off, container, false);
        mPositiveButton= (TextView) view.findViewById(R.id.positive_button);
        mNegativeButton = (TextView) view.findViewById(R.id.negative_button);
        mQuestion = (TextView)view.findViewById(R.id.question_header);

        mQuestion.setText("Удалось сделать подход?");
        mPositiveButton.setOnClickListener(this);
        mNegativeButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = getDialog().getWindow();
        window.setLayout(width, height);
    }

    private void setWindow() {
        getDialog().setCanceledOnTouchOutside(false);
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        int height = WindowManager.LayoutParams.MATCH_PARENT;

        Window window = getDialog().getWindow();
        window.requestFeature(Window.FEATURE_NO_TITLE);
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
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
