package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.FragmentEvent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingViewModelImpl extends ViewModel implements ResultTrainingViewModel {

    private ObservableField<String> mHeaderText;
    private ObservableField<String> mResultText;

    private MutableLiveData<FragmentEvent> mLiveData;

    public ResultTrainingViewModelImpl(boolean isSuccess) {
        mHeaderText = new ObservableField<>(isSuccess ? "Поздравляем!" : "ТЫ НЕУДАЧНИК");
        mResultText = new ObservableField<>(isSuccess ? "Успешно выполнил программу!" : "Получится в следующий раз");

        mLiveData = new MutableLiveData();
    }

    @Override
    public ObservableField<String> getHeaderText() {
        return mHeaderText;
    }

    @Override
    public ObservableField<String> getResultText() {
        return mResultText;
    }

    @Override
    public MutableLiveData<FragmentEvent> getFragmentEvent() {
        return mLiveData;
    }

    @Override
    public void goToStartTrainingFragment() {
        mLiveData.postValue(new FragmentEvent());
    }
}
