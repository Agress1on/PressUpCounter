package com.example.alexa.pressupcounter.traininglist.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.RecyclerListItemBinding;
import com.example.alexa.pressupcounter.data.Program;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 15.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListAdapter extends RecyclerView.Adapter<TrainingListHolder> {

    private List<Program> items = new ArrayList<>();

    public void setData(List<Program> data) {
        //items.clear();
        items.addAll(data);
        //notifyDataSetChanged();
    }

    public List<Program> getData() {
        return items;
    }

    @NonNull
    @Override
    public TrainingListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        RecyclerListItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.recycler_list_item, parent, false);
        return new TrainingListHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrainingListHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
