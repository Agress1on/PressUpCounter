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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.alexa.pressupcounter.R;

/**
 * Created by Alexandr Mikhalev on 21.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class BackPressedDialog extends DialogFragment implements View.OnClickListener {

    private OnClickBackPressedDialog mOnClickBackPressedDialog;
    private TextView mPositiveButton;
    private TextView mNegativeButton;
    private TextView mQuestion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOnClickBackPressedDialog = (OnClickBackPressedDialog) getParentFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_back_pressed, container, false);
        mPositiveButton = (TextView) view.findViewById(R.id.positive_button);
        mNegativeButton = (TextView) view.findViewById(R.id.negative_button);
        mQuestion = (TextView) view.findViewById(R.id.attention_header);

        mPositiveButton.setOnClickListener(this);
        mNegativeButton.setOnClickListener(this);
        mQuestion.setText(getResources().getString(R.string.for_dialog_back_pressed));
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.positive_button:
                mOnClickBackPressedDialog.onPositiveButtonBackPressedDialog(this);
                break;
            case R.id.negative_button:
                mOnClickBackPressedDialog.onNegativeButtonBackPressedDialog(this);
                break;
        }
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        mOnClickBackPressedDialog.onPositiveButtonBackPressedDialog(this);
    }

    public interface OnClickBackPressedDialog {
        void onPositiveButtonBackPressedDialog(BackPressedDialog backPressedDialog);

        void onNegativeButtonBackPressedDialog(BackPressedDialog backPressedDialog);
    }
}
