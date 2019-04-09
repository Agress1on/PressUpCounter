package com.example.alexa.pressupcounter.training.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.DialogFinishTraining;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRest;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRestOff;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import dagger.android.support.AndroidSupportInjection;

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

    private DialogTrainingRest mDialogTrainingRest;
    private DialogTrainingRestOff mDialogTrainingRestOff;
    private DialogFinishTraining mDialogFinishTraining;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //App.getAppComponent().createTrainingFragmentModelComponent(new TrainingFragmentModule(this)).inject(this);
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
        mDialogTrainingRest = new DialogTrainingRest();
        mDialogTrainingRest.initDialog(new DialogTrainingRest.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.onClickPositiveButtonOfRestDialog();
                mDialogTrainingRest.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickNegativeButtonOfRestDialog();
                mDialogTrainingRest.dismiss();
            }

            @Override
            public void onCancel() {
                mTrainingViewModel.onCancelOfRestDialog();
            }
        });

        mDialogTrainingRestOff = new DialogTrainingRestOff();
        mDialogTrainingRestOff.initDialog(new DialogTrainingRestOff.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.goToNextRepetition();
                mDialogTrainingRestOff.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickAdditionalTimeForRest();
                mDialogTrainingRestOff.dismiss();
            }
        });

        mDialogFinishTraining = new DialogFinishTraining();
        mDialogFinishTraining.init(new DialogFinishTraining.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.onClickPositiveButtonFinishDialog();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(true))
                        .commit();
                mDialogFinishTraining.dismiss();
            }

            @Override
            public void onNegativeButton() {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(false))
                        .commit();
                mDialogFinishTraining.dismiss();
            }
        });
    }

    public void showDialogTrainingRest() {
        mDialogTrainingRest.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST);
    }

    public void showDialogTrainingRestOff() {
        mDialogTrainingRestOff.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST_OFF);
    }

    public void showDialogFinishTraining() {
        mDialogFinishTraining.show(getFragmentManager(), TAG_FOR_DIALOG_TRAINING_FINISH);
    }

    public static TrainingFragment newInstance() {
        Bundle args = new Bundle();
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
