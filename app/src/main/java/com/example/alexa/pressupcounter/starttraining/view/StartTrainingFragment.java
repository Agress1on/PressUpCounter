package com.example.alexa.pressupcounter.starttraining.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.repository.AppDatabase;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.repository.PressUpDao;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentStartTrainingBinding;
import com.example.alexa.pressupcounter.starttraining.model.StartTrainingModel;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModel;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelFactory;
import com.example.alexa.pressupcounter.starttraining.viewmodel.StartTrainingViewModelImpl;
import com.example.alexa.pressupcounter.training.view.TrainingFragment;
import com.example.alexa.pressupcounter.traininglist.view.TrainingListFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Alexandr Mikhalev on 01.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class StartTrainingFragment extends Fragment {

    private StartTrainingViewModel mStartTrainingViewModel;

    //BD
    private AppDatabase mAppDatabase;
    private PressUpDao mPressUpDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //DB
        mAppDatabase = App.getInstance().getDatabase();
        mPressUpDao = mAppDatabase.pressUpDao();

        StartTrainingModel startTrainingModel = new StartTrainingModel(mAppDatabase, mPressUpDao);
        mStartTrainingViewModel = ViewModelProviders.of(this, new StartTrainingViewModelFactory(startTrainingModel)).get(StartTrainingViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentStartTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_training, container, false);
        binding.setViewModel(mStartTrainingViewModel);
        return binding.getRoot();
    }

    private void init() {
        mStartTrainingViewModel.getFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(@Nullable FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, TrainingFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });

        mStartTrainingViewModel.getLiveDataForGoToList().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        //.replace(R.id.fragment_container, SetTrainingDayFragment.newInstance())
                        .replace(R.id.fragment_container, TrainingListFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static StartTrainingFragment newInstance() {
        Bundle args = new Bundle();
        StartTrainingFragment fragment = new StartTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
