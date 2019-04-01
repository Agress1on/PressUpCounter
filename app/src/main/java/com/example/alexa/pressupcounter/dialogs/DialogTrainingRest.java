package com.example.alexa.pressupcounter.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

/**
 * Created by Alexandr Mikhalev on 01.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DialogTrainingRest extends DialogFragment implements DialogInterface.OnClickListener {

    private OnButtonClick mOnButtonClick;

    public void initDialog(OnButtonClick onButtonClick) {
        this.mOnButtonClick = onButtonClick;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Начать отдых?")
                .setMessage("Нажмите для ОК старта отдыха")
                .setPositiveButton("Start", this)
                .setNegativeButton("Cancel", this)
                .create();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case DialogInterface.BUTTON_POSITIVE:
                mOnButtonClick.onPositiveButton();
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                mOnButtonClick.onNegativeButton();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;
        /*
        Drawable d = new ColorDrawable(Color.BLACK);
        d.setAlpha(130);
        */

        Window window = getDialog().getWindow();
        window.setLayout(width, height);
        //window.setGravity(Gravity.RIGHT | Gravity.TOP);
        window.setGravity(Gravity.CENTER);
        //window.setTitle("Начать отдых?");
        //window.setBackgroundDrawable(d);
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
