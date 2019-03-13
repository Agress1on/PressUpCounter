package com.example.alexa.pressupcounter.traininglist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingListBinding;
import com.example.alexa.pressupcounter.traininglist.model.TrainingListModel;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModel;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModelFactory;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModelImpl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListFragment extends Fragment {

    private TrainingListViewModel mTrainingListViewModel;

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mRecyclerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TrainingListModel trainingListModel = new TrainingListModel();
        mTrainingListViewModel = ViewModelProviders.of(this, new TrainingListViewModelFactory(trainingListModel)).get(TrainingListViewModelImpl.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training_list, container, false);


        mRecyclerView = (RecyclerView) container.findViewById(R.id.training_list_recycler);

        FragmentActivity fragmentActivity = getActivity();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(fragmentActivity);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerAdapter = new RecyclerAdapter();
        mRecyclerView.setAdapter(mRecyclerAdapter);

        binding.setViewModel(mTrainingListViewModel);
        return binding.getRoot();
    }

    public static TrainingListFragment newInstance() {
        Bundle args = new Bundle();
        TrainingListFragment fragment = new TrainingListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
