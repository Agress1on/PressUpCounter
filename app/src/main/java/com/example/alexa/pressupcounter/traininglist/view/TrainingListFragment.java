package com.example.alexa.pressupcounter.traininglist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingListBinding;
import com.example.alexa.pressupcounter.traininglist.inject.TrainingListModule;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListFragment extends Fragment {

    @Inject
    TrainingListViewModel mTrainingListViewModel;

    private RecyclerView mRecyclerView;
    private PressUpAdapter mPressUpAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createTrainingListModelComponent(new TrainingListModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training_list, container, false);
        binding.setViewModel(mTrainingListViewModel);

        mRecyclerView = binding.trainingListRecycler;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        mPressUpAdapter = new PressUpAdapter();

        mRecyclerView.setAdapter(mPressUpAdapter);
        mPressUpAdapter.setData(mTrainingListViewModel.getPressUpList());
        return binding.getRoot();
    }

    public static TrainingListFragment newInstance() {
        Bundle args = new Bundle();
        TrainingListFragment fragment = new TrainingListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
