package com.example.alexa.pressupcounter.resulttraining.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentResultTrainingBinding;
import com.example.alexa.pressupcounter.resulttraining.router.ResultTrainingRouter;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModel;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingFragment extends Fragment {

    @Inject
    ResultTrainingViewModel mResultTrainingViewModel;

    @Inject
    ResultTrainingRouter mResultTrainingRouter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentResultTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result_training, container, false);
        binding.setViewModel(mResultTrainingViewModel);
        mResultTrainingViewModel.setCurrentRouter(mResultTrainingRouter);
        return binding.getRoot();
    }

    public void setStartTraining() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public static ResultTrainingFragment newInstance(boolean isSuccess) {
        Bundle args = new Bundle();
        args.putBoolean(Constants.TAG_FOR_IS_SUCCESS_TRAINING, isSuccess);
        ResultTrainingFragment fragment = new ResultTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
