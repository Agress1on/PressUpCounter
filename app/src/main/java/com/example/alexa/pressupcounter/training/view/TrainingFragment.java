package com.example.alexa.pressupcounter.training.view;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.FinishTrainingDialog;
import com.example.alexa.pressupcounter.dialogs.TrainingRestDialog;
import com.example.alexa.pressupcounter.dialogs.TrainingRestOffDialog;
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
        implements TrainingRestDialog.OnButtonDialogRestClickListener,
        TrainingRestOffDialog.OnButtonDialogRestOffClickListener,
        FinishTrainingDialog.OnButtonClickDialogFinishTraining,
        SoundPool.OnLoadCompleteListener {

    public static final String TAG_FOR_DIALOG_TRAINING_REST = "TAG_FOR_DIALOG_TRAINING_REST";
    public static final String TAG_FOR_DIALOG_TRAINING_REST_OFF = "TAG_FOR_DIALOG_TRAINING_REST_OFF";
    public static final String TAG_FOR_DIALOG_TRAINING_FINISH = "TAG_FOR_DIALOG_TRAINING_FINISH";

    @Inject
    TrainingViewModel mTrainingViewModel;

    @Inject
    TrainingRouter mTrainingRouter;

    private SoundPool mSoundPool;
    private int soundIdShot;

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
        init();
        return binding.getRoot();
    }

    private void init() {
        mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        mSoundPool.setOnLoadCompleteListener(this);
        soundIdShot = mSoundPool.load(getContext(), R.raw.timer, 1);
    }

    public void playSound() {
        mSoundPool.play(soundIdShot, 1, 1, 0, 0, 1);
    }

    public void showDialogTrainingRest() {
        TrainingRestDialog trainingRestDialog = new TrainingRestDialog();
        trainingRestDialog.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST);
    }

    public void showDialogTrainingRestOff() {
        TrainingRestOffDialog trainingRestOffDialog = new TrainingRestOffDialog();
        trainingRestOffDialog.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_REST_OFF);
    }

    public void showDialogFinishTraining() {
        FinishTrainingDialog finishTrainingDialog = new FinishTrainingDialog();
        finishTrainingDialog.show(getChildFragmentManager(), TAG_FOR_DIALOG_TRAINING_FINISH);
    }

    public static TrainingFragment newInstance() {
        Bundle args = new Bundle();
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onPositiveButtonTrainingRestDialog(TrainingRestDialog trainingRestDialog) {
        mTrainingViewModel.onClickPositiveButtonOfRestDialog();
        trainingRestDialog.dismiss();
    }

    @Override
    public void onNegativeButtonTrainingRestDialog(TrainingRestDialog trainingRestDialog) {
        mTrainingViewModel.onClickNegativeButtonOfRestDialog();
        trainingRestDialog.dismiss();
    }

    @Override
    public void onCancelTrainingRestDialog(TrainingRestDialog trainingRestDialog) {
        mTrainingViewModel.onCancelOfRestDialog();
        trainingRestDialog.dismiss();
    }

    @Override
    public void onPositiveButtonTrainingRestOfDialog(TrainingRestOffDialog trainingRestOffDialog) {
        mTrainingViewModel.goToNextRepetition();
        trainingRestOffDialog.dismiss();
    }

    @Override
    public void onNegativeButtonTrainingRestOfDialog(TrainingRestOffDialog trainingRestOffDialog) {
        mTrainingViewModel.onClickAdditionalTimeForRest();
        trainingRestOffDialog.dismiss();
    }

    @Override
    public void onPositiveButtonDialogFinishTraining(FinishTrainingDialog finishTrainingDialog) {
        mTrainingViewModel.onClickPositiveButtonFinishDialog();
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(true))
                .commit();
        finishTrainingDialog.dismiss();
    }

    @Override
    public void onNegativeButtonDialogFinishTraining(FinishTrainingDialog finishTrainingDialog) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(false))
                .commit();
        finishTrainingDialog.dismiss();
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int i, int i1) {

    }
}
