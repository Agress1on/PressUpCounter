package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingViewModelImpl extends ViewModel implements ResultTrainingViewModel {

    private ObservableField<String> mHeaderText;
    private ObservableField<String> mResultText;

    public ResultTrainingViewModelImpl(boolean isSuccess) {
        mHeaderText = new ObservableField<>(isSuccess ? "Поздравляем!" : "ТЫ НЕУДАЧНИК");
        mResultText = new ObservableField<>(isSuccess ? "Успешно выполнил программу!" : "Получится в следующий раз");
    }

    public ObservableField<String> getHeaderText() {
        return mHeaderText;
    }

    public ObservableField<String> getResultText() {
        return mResultText;
    }
}
