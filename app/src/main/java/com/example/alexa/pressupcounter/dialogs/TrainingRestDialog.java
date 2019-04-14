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
 * Created by Alexandr Mikhalev on 01.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingRestDialog extends DialogFragment implements View.OnClickListener {

    private OnButtonDialogRestClickListener mOnButtonDialogRestClickListener;

    private TextView mPositiveButton;
    private TextView mNegativeButton;
    private TextView mMessage;

    /*
    public void initDialog(OnButtonDialogRestClickListener onButtonClickListener) {
        this.mOnButtonDialogRestClickListener = onButtonClickListener;
    }
    */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnButtonDialogRestClickListener = (OnButtonDialogRestClickListener) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_training_rest, container, false);
        mPositiveButton = (TextView) view.findViewById(R.id.positive_button);
        mNegativeButton = (TextView) view.findViewById(R.id.negative_button);
        mMessage = (TextView) view.findViewById(R.id.attention_header);

        mMessage.setText("Начать отдых?");
        mPositiveButton.setOnClickListener(this);
        mNegativeButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setWindow();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.positive_button:
                mOnButtonDialogRestClickListener.onPositiveButtonTrainingRestDialog(this);
                break;
            case R.id.negative_button:
                mOnButtonDialogRestClickListener.onNegativeButtonTrainingRestDialog(this);
                break;
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        mOnButtonDialogRestClickListener.onCancelTrainingRestDialog(this);
    }

    private void setWindow() {
        getDialog().setCanceledOnTouchOutside(false);
        int width = WindowManager.LayoutParams.MATCH_PARENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        Window window = getDialog().getWindow();
        window.setLayout(width, height);
        window.setGravity(Gravity.CENTER);
    }

    public interface OnButtonDialogRestClickListener {
        void onPositiveButtonTrainingRestDialog(TrainingRestDialog trainingRestDialog);

        void onNegativeButtonTrainingRestDialog(TrainingRestDialog trainingRestDialog);

        void onCancelTrainingRestDialog(TrainingRestDialog trainingRestDialog);
    }
}
