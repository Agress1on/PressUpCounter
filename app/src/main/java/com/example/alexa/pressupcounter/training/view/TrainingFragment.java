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
import com.example.alexa.pressupcounter.training.router.TrainingRouter;
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
public class TrainingFragment extends Fragment
        implements DialogTrainingRest.OnButtonDialogRestClickListener,
        DialogTrainingRestOff.OnButtonDialogRestOffClickListener,
        DialogFinishTraining.OnButtonClickDialogFinishTraining {

    public static final String TAG_FOR_DIALOG_TRAINING_REST = "TAG_FOR_DIALOG_TRAINING_REST";
    public static final String TAG_FOR_DIALOG_TRAINING_REST_OFF = "TAG_FOR_DIALOG_TRAINING_REST_OFF";
    public static final String TAG_FOR_DIALOG_TRAINING_FINISH = "TAG_FOR_DIALOG_TRAINING_FINISH";

    @Inject
    TrainingViewModel mTrainingViewModel;

    @Inject
    TrainingRouter mTrainingRouter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false);
        binding.setViewModel(mTrainingViewModel);
        mTrainingViewModel.setRouter(mTrainingRouter);
        return binding.getRoot();
    }

    public void showDialogTrainingRest() {
        DialogTrainingRest dialogTrainingRest = new DialogTrainingRest();
        dialogTrainingRest.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST);
    }

    public void showDialogTrainingRestOff() {
        DialogTrainingRestOff dialogTrainingRestOff = new DialogTrainingRestOff();
        dialogTrainingRestOff.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST_OFF);
    }

    public void showDialogFinishTraining() {
        DialogFinishTraining dialogFinishTraining = new DialogFinishTraining();
        dialogFinishTraining.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_FINISH);
    }

    public static TrainingFragment newInstance() {
        Bundle args = new Bundle();
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPositiveButtonTrainingRestDialog(DialogTrainingRest dialogTrainingRest) {
        mTrainingViewModel.onClickPositiveButtonOfRestDialog();
        dialogTrainingRest.dismiss();
    }

    @Override
    public void onNegativeButtonTrainingRestDialog(DialogTrainingRest dialogTrainingRest) {
        mTrainingViewModel.onClickNegativeButtonOfRestDialog();
        dialogTrainingRest.dismiss();
    }

    @Override
    public void onCancelTrainingRestDialog(DialogTrainingRest dialogTrainingRest) {
        mTrainingViewModel.onCancelOfRestDialog();
        dialogTrainingRest.dismiss();
    }

    @Override
    public void onPositiveButtonTrainingRestOfDialog(DialogTrainingRestOff dialogTrainingRestOff) {
        mTrainingViewModel.goToNextRepetition();
        dialogTrainingRestOff.dismiss();
    }

    @Override
    public void onNegativeButtonTrainingRestOfDialog(DialogTrainingRestOff dialogTrainingRestOff) {
        mTrainingViewModel.onClickAdditionalTimeForRest();
        dialogTrainingRestOff.dismiss();
    }

    @Override
    public void onPositiveButtonDialogFinishTraining(DialogFinishTraining dialogFinishTraining) {
        mTrainingViewModel.onClickPositiveButtonFinishDialog();
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(true))
                .commit();
        dialogFinishTraining.dismiss();
    }

    @Override
    public void onNegativeButtonDialogFinishTraining(DialogFinishTraining dialogFinishTraining) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(false))
                .commit();
        dialogFinishTraining.dismiss();
    }
}
