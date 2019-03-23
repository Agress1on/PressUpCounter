package com.example.alexa.pressupcounter.resulttraining.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.events.FragmentEvent;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentResultTrainingBinding;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModel;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModelFactory;
import com.example.alexa.pressupcounter.resulttraining.viewmodel.ResultTrainingViewModelImpl;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

/**
 * Created by Alexandr Mikhalev on 06.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ResultTrainingFragment extends Fragment {

    private ResultTrainingViewModel mResultTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isSuccess = getArguments().getBoolean(Constants.TAG_FOR_IS_SUCCESS_TRAINING);
        mResultTrainingViewModel = ViewModelProviders.of(this, new ResultTrainingViewModelFactory(isSuccess)).get(ResultTrainingViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentResultTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result_training, container, false);
        binding.setViewModel(mResultTrainingViewModel);
        return binding.getRoot();
    }

    private void init() {
        mResultTrainingViewModel.getFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static ResultTrainingFragment newInstance(boolean isSuccess) {
        Bundle args = new Bundle();
        args.putBoolean(Constants.TAG_FOR_IS_SUCCESS_TRAINING, isSuccess);
        ResultTrainingFragment fragment = new ResultTrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
