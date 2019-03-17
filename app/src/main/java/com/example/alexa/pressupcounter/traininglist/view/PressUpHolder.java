package com.example.alexa.pressupcounter.traininglist.view;

import android.view.View;

import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.databinding.RecyclerListItemBinding;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 15.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class PressUpHolder extends RecyclerView.ViewHolder {
    RecyclerListItemBinding mRecyclerListItemBinding;

    public PressUpHolder(RecyclerListItemBinding recyclerListItemBinding) {
        super(recyclerListItemBinding.getRoot());
        mRecyclerListItemBinding = recyclerListItemBinding;
    }

    public void bind(PressUp pressUp) {
        mRecyclerListItemBinding.setPressUp(pressUp);
        mRecyclerListItemBinding.executePendingBindings();
    }
}
