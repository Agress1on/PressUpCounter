package com.example.alexa.pressupcounter.training.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.DialogFinishTraining;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRest;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRestOff;
import com.example.alexa.pressupcounter.events.DialogEvent;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModule;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingFragment extends Fragment {

    public static final String TAG_FOR_DIALOG_TRAINING_REST = "TAG_FOR_DIALOG_TRAINING_REST";
    public static final String TAG_FOR_DIALOG_TRAINING_REST_OFF = "TAG_FOR_DIALOG_TRAINING_REST_OFF";
    public static final String TAG_FOR_DIALOG_TRAINING_FINISH = "TAG_FOR_DIALOG_TRAINING_FINISH";

    @Inject
    TrainingViewModel mTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createTrainingFragmentModelComponent(new TrainingFragmentModule(this)).inject(this);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false);
        binding.setViewModel(mTrainingViewModel);
        mTrainingViewModel.onCreateView();
        return binding.getRoot();
    }

    private void init() {
        DialogTrainingRest trainingRest = new DialogTrainingRest();
        trainingRest.initDialog(new DialogTrainingRest.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.onClickPositiveButtonOfRestDialog();
                trainingRest.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickNegativeButtonOfRestDialog();
                trainingRest.dismiss();
            }

            @Override
            public void onCancel() {
                mTrainingViewModel.onCancelOfRestDialog();
            }
        });
        mTrainingViewModel.getRestDialogEvent().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                trainingRest.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST);
            }
        });

        //show training off dialog or choose additional time of rest
        final DialogTrainingRestOff trainingRestOff = new DialogTrainingRestOff();
        trainingRestOff.initDialog(new DialogTrainingRestOff.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.goToNextRepetition();
                trainingRestOff.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickAdditionalTimeForRest();
                trainingRestOff.dismiss();
            }
        });
        mTrainingViewModel.getRestOffDialogEvent().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                trainingRestOff.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST_OFF);
            }
        });

        //show finish training dialog
        final DialogFinishTraining finishTraining = new DialogFinishTraining();
        finishTraining.init(new DialogFinishTraining.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.onClickPositiveButtonFinishDialog();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(true))
                        .commit();
                finishTraining.dismiss();
            }

            @Override
            public void onNegativeButton() {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(false))
                        .commit();
                finishTraining.dismiss();
            }
        });
        mTrainingViewModel.getFinishTrainingDialogEvent().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                finishTraining.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_FINISH);
            }
        });
    }

    public static TrainingFragment newInstance() {
        Bundle args = new Bundle();
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
