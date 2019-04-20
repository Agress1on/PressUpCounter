package com.example.alexa.pressupcounter.utils;

import com.example.alexa.pressupcounter.data.Program;

import java.util.List;

import androidx.recyclerview.widget.DiffUtil;

/**
 * Created by Alexandr Mikhalev on 06.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class DiffUtilTrainingList extends DiffUtil.Callback {
    private List<Program> oldList;
    private List<Program> newList;

    public DiffUtilTrainingList(List<Program> oldList, List<Program> newList) {
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
        Program oldItem = oldList.get(oldItemPosition);
        Program newItem = newList.get(newItemPosition);
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Program oldItem = oldList.get(oldItemPosition);
        Program newItem = newList.get(newItemPosition);
        boolean isSame = true;
        for (int i = 0; i < newList.size(); i++) {
            if (!oldItem.getRepetitions().get(i).equals(newItem.getRepetitions().get(i))) isSame = false;
        }
        /*
        return (oldItem.getFirstRepetition() == newItem.getFirstRepetition())
                && (oldItem.getSecondRepetition() == newItem.getSecondRepetition())
                && (oldItem.getThirdRepetition() == newItem.getThirdRepetition())
                && (oldItem.getFourthRepetition() == newItem.getFourthRepetition())
                && (oldItem.getFifthRepetition() == newItem.getFifthRepetition());
        */
        return isSame;
    }
}
