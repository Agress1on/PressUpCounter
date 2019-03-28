package com.example.alexa.pressupcounter.training.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.dialogs.DialogFinishTraining;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRest;
import com.example.alexa.pressupcounter.dialogs.DialogTrainingRestOff;
import com.example.alexa.pressupcounter.events.DialogEvent;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;
import com.example.alexa.pressupcounter.training.inject.TrainingFragmentModelModule;
import com.example.alexa.pressupcounter.training.model.TrainingFragmentModel;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelFactory;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelImpl;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingFragment extends Fragment {

    @Inject
    TrainingViewModel mTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createTrainingFragmentModelComponent(new TrainingFragmentModelModule(this)).inject(this);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentTrainingBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_training, container, false);
        binding.setViewModel(mTrainingViewModel);
        return binding.getRoot();
    }

    private void init() {
        //show startRestDialog
        final DialogTrainingRest dg = new DialogTrainingRest();
        dg.initDialog(new DialogTrainingRest.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.onClickPositiveButtonOfRestDialog();
                dg.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickNegativeButtonOfRestDialog();
                dg.dismiss();
            }
        });
        mTrainingViewModel.getDialogEventForRest().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                if (dialogEvent.isHappened()) return;
                dg.show(getActivity().getFragmentManager(), Constants.TAG_FOR_DIALOG_TRAINING_REST);
                dialogEvent.setHappened(true);
            }
        });

        //show training off dialog or choose additional time of rest
        final DialogTrainingRestOff dg2 = new DialogTrainingRestOff();
        dg2.initDialog(new DialogTrainingRestOff.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.goToNextRepetition();
                dg2.dismiss();
            }

            @Override
            public void onNegativeButton() {
                mTrainingViewModel.onClickAdditionalTimeForRest();
                dg2.dismiss();
            }
        });
        mTrainingViewModel.getDialogEventForRestOff().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                if (dialogEvent.isHappened()) return;
                dg2.show(getActivity().getFragmentManager(), Constants.TAG_FOR_DIALOG_TRAINING_REST_OFF);
                dialogEvent.setHappened(true);
            }
        });

        //show finish training dialog
        final DialogFinishTraining dg3 = new DialogFinishTraining();
        dg3.init(new DialogFinishTraining.OnButtonClick() {
            @Override
            public void onPositiveButton() {
                mTrainingViewModel.writeNewProgramInDB();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(true))
                        .commit();
                dg3.dismiss();
            }

            @Override
            public void onNegativeButton() {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, ResultTrainingFragment.newInstance(false))
                        .commit();
                dg3.dismiss();
            }
        });
        mTrainingViewModel.getDialogEventFinishTraining().observe(this, new Observer<DialogEvent>() {
            @Override
            public void onChanged(@Nullable DialogEvent dialogEvent) {
                if (dialogEvent.isHappened()) return;
                dg3.show(getActivity().getFragmentManager(), Constants.TAG_FOR_DIALOG_TRAINING_FINISH);
                dialogEvent.setHappened(true);
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
