package com.example.alexa.pressupcounter.testfragment.viewmodel;

import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.testfragment.model.TestFragmentModel;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
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
        mTestFragmentModel.getById(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<PressUp2>>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(List<PressUp2> pressUp2s) {
                        mTestTextView.set("New info" + pressUp2s.get(0).mSecondRepetition);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

        //mTestTextView.set("New info" + pressUp2.mFirstRepetition + pressUp2.mSecondRepetition);
        //s.request(Long.MAX_VALUE);
    }
}
