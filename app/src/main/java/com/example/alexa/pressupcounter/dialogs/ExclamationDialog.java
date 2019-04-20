package com.example.alexa.pressupcounter.dialogs;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
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
public class ExclamationDialog extends DialogFragment implements View.OnClickListener {

    private TextView mMessageTextView;
    private ImageView mCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_exclamation, container, false);
        mMessageTextView = (TextView) view.findViewById(R.id.message);
        mCancel = (ImageView) view.findViewById(R.id.cancel_image_view);
        mMessageTextView.setText("Установите уведомления");
        mCancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setWindow();
    }

    @Override
    public void onClick(View view) {
        dismiss();
    }

    private void setWindow() {
        getDialog().setCanceledOnTouchOutside(false);
        int width = WindowManager.LayoutParams.WRAP_CONTENT;
        int height = WindowManager.LayoutParams.WRAP_CONTENT;

        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.y = +90;
        params.x = +90;

        Window window = getDialog().getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setLayout(width, height);
        window.setGravity(Gravity.TOP | Gravity.RIGHT);
        window.setAttributes(params);
    }
}
