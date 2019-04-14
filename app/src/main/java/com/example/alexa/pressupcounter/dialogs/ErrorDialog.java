package com.example.alexa.pressupcounter.dialogs;

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
 * Created by Alexandr Mikhalev on 14.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ErrorDialog extends DialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_error, container, false);
        TextView closeView = (TextView) view.findViewById(R.id.positive_button);
        TextView attention = (TextView) view.findViewById(R.id.attention_header);
        attention.setText("Возникла внутренняя ошибка приложения");
        closeView.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        dismiss();
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
}
