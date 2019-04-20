package com.example.alexa.pressupcounter.resulttraining.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.events.ResultTrainingSetTextEvent;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingViewModelImpl extends ViewModel implements ResultTrainingViewModel {

    private ResultTrainingRouter mResultTrainingRouter;

    //private ObservableField<String> mHeaderText;
    //private ObservableField<String> mResultText;
    private SingleLiveEvent<ResultTrainingSetTextEvent> mSetTextEvent;

    public ResultTrainingViewModelImpl(ResultTrainingRouter router, boolean isSuccess) {
        mResultTrainingRouter = router;
        //mHeaderText = new ObservableField<>(isSuccess ? "Поздравляем!" : "ТЫ НЕУДАЧНИК");
        //mResultText = new ObservableField<>(isSuccess ? "Успешно выполнил программу!" : "Получится в следующий раз");

        mSetTextEvent = new SingleLiveEvent<>();
        mSetTextEvent.postValue(new ResultTrainingSetTextEvent(isSuccess));
    }

    @Override
    public void setCurrentRouter(ResultTrainingRouter router) {
        mResultTrainingRouter = router;
    }

    @Override
    public SingleLiveEvent<ResultTrainingSetTextEvent> getSetTextEvent() {
        return mSetTextEvent;
    }

    /*
    @Override
    public ObservableField<String> getHeaderText() {
        return mHeaderText;
    }

    @Override
    public ObservableField<String> getResultText() {
        return mResultText;
    }
    */

    @Override
    public void onClickHomeButton() {
        mResultTrainingRouter.goToStartTraining();
    }
}
