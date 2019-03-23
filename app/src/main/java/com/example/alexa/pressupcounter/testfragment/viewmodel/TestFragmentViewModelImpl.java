package com.example.alexa.pressupcounter.testfragment.viewmodel;

import com.example.alexa.pressupcounter.repository.PressUp;
import com.example.alexa.pressupcounter.testfragment.model.TestFragmentModel;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TestFragmentViewModelImpl extends ViewModel implements TestFragmentViewModel {

    private TestFragmentModel mTestFragmentModel;

    private ObservableField<String> mTestTextView;

    public TestFragmentViewModelImpl(TestFragmentModel testFragmentModel) {
        mTestFragmentModel = testFragmentModel;
        mTestTextView = new ObservableField<>("Hi, I am Test. I am from Constructor");
    }

    public ObservableField<String> getTestTextView() {
        return mTestTextView;
    }

    @Override
    public void onPushButtonClick() {
        Disposable disposable = mTestFragmentModel.getById(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PressUp>>() {
                    @Override
                    public void accept(List<PressUp> pressUp2s) throws Exception {
                        mTestTextView.set("New info" + pressUp2s.get(0).getFirstRepetition() + " " + pressUp2s.get(0).getSecondRepetition());
                    }
                });
    }
}
