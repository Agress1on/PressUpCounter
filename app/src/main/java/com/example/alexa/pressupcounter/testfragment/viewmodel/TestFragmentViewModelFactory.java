package com.example.alexa.pressupcounter.testfragment.viewmodel;

import com.example.alexa.pressupcounter.testfragment.model.TestFragmentModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * Created by Alexandr Mikhalev on 02.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TestFragmentViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final TestFragmentModel mTestFragmentModel;

    public TestFragmentViewModelFactory(TestFragmentModel testFragmentModel) {
        super();
        mTestFragmentModel = testFragmentModel;
    }

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == TestFragmentViewModelImpl.class) {
            return (T) new TestFragmentViewModelImpl(mTestFragmentModel);
        }
        return null;
    }
}
