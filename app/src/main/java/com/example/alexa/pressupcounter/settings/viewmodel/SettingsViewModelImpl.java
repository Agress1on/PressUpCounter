package com.example.alexa.pressupcounter.settings.viewmodel;

import com.example.alexa.pressupcounter.SingleLiveEvent;
import com.example.alexa.pressupcounter.data.PressUp;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.settings.model.SettingsModel;

import java.util.List;

import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
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

    private LiveData<FragmentEvent> mLiveDataForSetNotifications;

    public SettingsViewModelImpl(SettingsModel settingsModel) {
        mSettingsModel = settingsModel;
        mTestTextView = new ObservableField<>("Hi, I am Test. I am from Constructor");
        mLiveDataForSetNotifications = new SingleLiveEvent<>();
    }

    public ObservableField<String> getTestTextView() {
        return mTestTextView;
    }

    @Override
    public LiveData<FragmentEvent> getLiveDataForSetNotifications() {
        return mLiveDataForSetNotifications;
    }

    @Override
    public void onSetNotificationsClick() {
        ((SingleLiveEvent<FragmentEvent>) mLiveDataForSetNotifications).postValue(new FragmentEvent());
    }
}
