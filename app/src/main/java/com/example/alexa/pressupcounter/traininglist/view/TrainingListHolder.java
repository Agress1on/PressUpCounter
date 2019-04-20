package com.example.alexa.pressupcounter.traininglist.view;

import com.example.alexa.pressupcounter.databinding.RecyclerListItemBinding;
import com.example.alexa.pressupcounter.data.Program;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 15.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListHolder extends RecyclerView.ViewHolder {
    RecyclerListItemBinding mRecyclerListItemBinding;

    public TrainingListHolder(RecyclerListItemBinding recyclerListItemBinding) {
        super(recyclerListItemBinding.getRoot());
        mRecyclerListItemBinding = recyclerListItemBinding;
    }

    public void bind(Program program) {
        mRecyclerListItemBinding.setProgram(program);
        mRecyclerListItemBinding.executePendingBindings();
    }
}
