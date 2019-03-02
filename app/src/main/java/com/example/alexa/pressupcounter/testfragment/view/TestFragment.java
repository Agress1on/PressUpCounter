package com.example.alexa.pressupcounter.testfragment.view;

import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.PressUpDao;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentTestBinding;
import com.example.alexa.pressupcounter.testfragment.model.TestFragmentModel;
import com.example.alexa.pressupcounter.testfragment.viewmodel.TestFragmentViewModel;
import com.example.alexa.pressupcounter.testfragment.viewmodel.TestFragmentViewModelFactory;
import com.example.alexa.pressupcounter.testfragment.viewmodel.TestFragmentViewModelImpl;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TestFragment extends Fragment {

    private TestFragmentViewModel mTestFragmentViewModel;

    private AppDatabase db;
    private PressUpDao pressUpDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DB
        db = App.getInstance().getDatabase();
        pressUpDao = db.pressUpDao();

        TestFragmentModel testFragmentModel = new TestFragmentModel(db, pressUpDao);
        mTestFragmentViewModel = ViewModelProviders.of(this, new TestFragmentViewModelFactory(testFragmentModel)).get(TestFragmentViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTestBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false);
        binding.setViewModel(mTestFragmentViewModel);
        return binding.getRoot();
    }

    public static TestFragment newInstance() {
        Bundle args = new Bundle();
        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
