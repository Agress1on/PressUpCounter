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

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogFinishTraining extends DialogFragment implements View.OnClickListener {

    private OnButtonClickDialogFinishTraining mOnButtonClickDialogFinishTraining;
    private TextView mPositiveButton;
    private TextView mNegativeButton;
    private TextView mQuestion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnButtonClickDialogFinishTraining = (OnButtonClickDialogFinishTraining) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_finish_training, container, false);
        mPositiveButton = (TextView) view.findViewById(R.id.positive_button);
        mNegativeButton = (TextView) view.findViewById(R.id.negative_button);
        mQuestion = (TextView) view.findViewById(R.id.question_header);

        mPositiveButton.setOnClickListener(this);
        mNegativeButton.setOnClickListener(this);
        mQuestion.setText(getResources().getString(R.string.for_dialog_finish_training));
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setWindow();
    }

    private void setWindow() {
        getDialog().setCanceledOnTouchOutside(false);
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = getDialog().getWindow();
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.positive_button:
                mOnButtonClickDialogFinishTraining.onPositiveButtonDialogFinishTraining(this);
                break;
            case R.id.negative_button:
                mOnButtonClickDialogFinishTraining.onNegativeButtonDialogFinishTraining(this);
                break;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mOnButtonClickDialogFinishTraining.onNegativeButtonDialogFinishTraining(this);
    }

    public interface OnButtonClickDialogFinishTraining {
        void onPositiveButtonDialogFinishTraining(DialogFinishTraining dialogFinishTraining);

        void onNegativeButtonDialogFinishTraining(DialogFinishTraining dialogFinishTraining);
    }
}
