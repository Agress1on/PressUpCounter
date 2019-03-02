package com.example.alexa.pressupcounter;

import android.content.res.Resources;
import androidx.databinding.BindingAdapter;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alexandr Mikhalev on 31.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class BindingAdapters {

    @BindingAdapter("app:setCurrent")
    public static void setCurrent(TextView view, Boolean isCurrent) {
        Resources res = view.getResources();
        int color = isCurrent ? res.getColor(R.color.colorRed) : res.getColor(R.color.colorWhite);
        float size = isCurrent ? res.getDimension(R.dimen.big_size_of_repetition_text_view) : res.getDimension(R.dimen.small_size_of_repetition_text_view);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        view.setBackgroundColor(color);
    }

    @BindingAdapter("app:setButtonState")
    public static void setButtonState(Button button, Boolean isEnabled) {
        button.setEnabled(isEnabled);
    }
}
