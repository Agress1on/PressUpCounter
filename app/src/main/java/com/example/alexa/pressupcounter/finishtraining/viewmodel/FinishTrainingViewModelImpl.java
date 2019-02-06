package com.example.alexa.pressupcounter.finishtraining.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FinishTrainingViewModelImpl extends ViewModel implements FinishTrainingViewModel {

    private ObservableField<String> mHeaderText;
    private ObservableField<String> mResultText;

    public FinishTrainingViewModelImpl() {
        mHeaderText = new ObservableField<>("Поздравляем!");
        mResultText = new ObservableField<>("Успешно выполнил программу!");
    }

    public ObservableField<String> getHeaderText() {
        return mHeaderText;
    }

    public ObservableField<String> getResultText() {
        return mResultText;
    }
}
