package com.example.alexa.pressupcounter.traininglist.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.data.Program;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingListBinding;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;
import com.example.alexa.pressupcounter.traininglist.router.TrainingListRouter;
import com.example.alexa.pressupcounter.traininglist.viewmodel.TrainingListViewModel;
import com.example.alexa.pressupcounter.utils.DiffUtilTrainingList;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 12.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingListFragment extends Fragment {

    @Inject
    TrainingListViewModel mTrainingListViewModel;

    @Inject
    TrainingListRouter mTrainingListRouter;

    private RecyclerView mRecyclerView;
    private TrainingListAdapter mTrainingListAdapter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training_list, container, false);
        binding.setViewModel(mTrainingListViewModel);

        mRecyclerView = binding.trainingListRecycler;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        mTrainingListAdapter = new TrainingListAdapter();

        mRecyclerView.setAdapter(mTrainingListAdapter);
        mTrainingListAdapter.setData(mTrainingListViewModel.getProgramList());
        mTrainingListViewModel.setCurrentRouter(mTrainingListRouter);
        return binding.getRoot();
    }

    private void init() {
        mTrainingListViewModel.getEventForUpdateList()
                .observe(this, eventForUpdateList -> updateAdapter(mTrainingListViewModel.getProgramList()));
    }

    private void updateAdapter(List<Program> newList) {
        DiffUtilTrainingList diffUtilTrainingList = new DiffUtilTrainingList(mTrainingListAdapter.getData(), newList);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffUtilTrainingList);
        mTrainingListAdapter.setData(newList);
        diffResult.dispatchUpdatesTo(mTrainingListAdapter);
    }

    public void goToStartTraining() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public static TrainingListFragment newInstance() {
        Bundle args = new Bundle();
        TrainingListFragment fragment = new TrainingListFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
