package com.example.alexa.pressupcounter.start.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartViewModelImpl extends ViewModel implements StartViewModel {

    private List<ObservableField<Integer>> listOfRepetition = new ArrayList<>();
    private ObservableField<Integer> mSummQuantity;

    public StartViewModelImpl() {
        listOfRepetition.add(new ObservableField<>(2)); //first repetition
        listOfRepetition.add(new ObservableField<>(3)); // secont repetition
        listOfRepetition.add(new ObservableField<>(1)); // third repetition
        listOfRepetition.add(new ObservableField<>(1)); // fourth repetition
        listOfRepetition.add(new ObservableField<>(3)); // fifth repetition
        mSummQuantity = new ObservableField<>(10);
    }

    @Override
    public List<ObservableField<Integer>> getListOfRepetition() {
        return listOfRepetition;
    }

    @Override
    public void onIncrementButton() {
       if (listOfRepetition.get(0).get() == listOfRepetition.get(1).get()) {
           increaseRepetition(1);
           increaseRepetition(4);
       } else {
           increaseRepetition(0);
           increaseRepetition(2);
           increaseRepetition(3);
       }
        setFinalQuantity();
    }

    @Override
    public void onDecrementButton() {
        if (mSummQuantity.get() == 10) return;
        if (listOfRepetition.get(0).get() == listOfRepetition.get(1).get()) {
            decreaseRepetition(0);
            decreaseRepetition(2);
            decreaseRepetition(3);
        } else {
            decreaseRepetition(1);
            decreaseRepetition(4);
        }
        setFinalQuantity();
    }

    @Override
    public ObservableField<Integer> getFinalQuantity() {
        return mSummQuantity;
    }

    private void setFinalQuantity() {
        mSummQuantity.set(0);
        for (ObservableField<Integer> integerObservableField : listOfRepetition) {
            mSummQuantity.set(mSummQuantity.get() + integerObservableField.get());
        }
    }

    private void increaseRepetition(int numberOfList) {
        listOfRepetition.get(numberOfList).set(listOfRepetition.get(numberOfList).get() + 1);
    }

    private void decreaseRepetition(int numberOfList) {
        listOfRepetition.get(numberOfList).set(listOfRepetition.get(numberOfList).get() - 1);
    }
}
