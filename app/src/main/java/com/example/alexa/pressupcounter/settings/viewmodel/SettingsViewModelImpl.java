package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.settings.model.SettingsModel;

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
public class SettingsViewModelImpl extends ViewModel implements SettingsViewModel {

    private SettingsModel mSettingsModel;

    private ObservableField<String> mTestTextView;

    public SettingsViewModelImpl(SettingsModel settingsModel) {
        mSettingsModel = settingsModel;
        mTestTextView = new ObservableField<>("Hi, I am Test. I am from Constructor");
    }

    public ObservableField<String> getTestTextView() {
        return mTestTextView;
    }

    @Override
    public void onPushButtonClick() {
        Disposable disposable = mSettingsModel.getById(1).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<PressUp>>() {
                    @Override
                    public void accept(List<PressUp> pressUp2s) throws Exception {
                        mTestTextView.set("New info" + pressUp2s.get(0).getFirstRepetition() + " " + pressUp2s.get(0).getSecondRepetition());
                    }
                });
    }
}
