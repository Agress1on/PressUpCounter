package com.example.alexa.pressupcounter;

import android.content.res.Resources;
import androidx.databinding.BindingAdapter;

import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Alexandr Mikhalev on 31.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class BindingAdapters {

    @BindingAdapter("setCurrent")
    public static void setCurrent(TextView view, Boolean isCurrent) {
        Resources res = view.getResources();
        int backgroundColor = isCurrent ? res.getColor(R.color.colorRed) : res.getColor(R.color.colorWhite);
        int textColor = isCurrent ? res.getColor(R.color.colorWhite) : res.getColor(R.color.colorBlack);
        float size = isCurrent ? res.getDimension(R.dimen.big_size_of_repetition_text_view) : res.getDimension(R.dimen.small_size_of_repetition_text_view);
        view.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        view.setBackgroundColor(backgroundColor);
        view.setTextColor(textColor);
    }

    @BindingAdapter("customTextColor")
    public static void customTextColor(TextView textView, String text) {
        Resources res = textView.getResources();
        int color = text.equals(Constants.TEXT_FOR_SET_TIME_STRING) ? res.getColor(R.color.colorFireBrick) : res.getColor(R.color.colorForestGreen);
        textView.setTextColor(color);
    }

    @BindingAdapter("buttonStyle")
    public static void buttonStyle(Button button, boolean state) {
        Resources res = button.getResources();
        Drawable drawable = state ? res.getDrawable(R.drawable.ic_checked) : res.getDrawable(R.drawable.ic_unchecked);
        button.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        button.setEnabled(state);
    }
}
