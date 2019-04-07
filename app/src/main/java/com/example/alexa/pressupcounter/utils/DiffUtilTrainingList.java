package com.example.alexa.pressupcounter.utils;

import com.example.alexa.pressupcounter.data.PressUp;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

/**
 * Created by Alexandr Mikhalev on 06.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DiffUtilTrainingList extends DiffUtil.Callback {
    private List<PressUp> oldList;
    private List<PressUp> newList;

    public DiffUtilTrainingList(List<PressUp> oldList, List<PressUp> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        PressUp oldItem = oldList.get(oldItemPosition);
        PressUp newItem = newList.get(newItemPosition);
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        PressUp oldItem = oldList.get(oldItemPosition);
        PressUp newItem = newList.get(newItemPosition);
        return (oldItem.getFirstRepetition() == newItem.getFirstRepetition())
                && (oldItem.getSecondRepetition() == newItem.getSecondRepetition())
                && (oldItem.getThirdRepetition() == newItem.getThirdRepetition())
                && (oldItem.getFourthRepetition() == newItem.getFourthRepetition())
                && (oldItem.getFifthRepetition() == newItem.getFifthRepetition());
    }
}