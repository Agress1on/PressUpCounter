package com.example.alexa.pressupcounter.training.view;

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
import com.example.alexa.pressupcounter.DialogEvent;
import com.example.alexa.pressupcounter.PressUp;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentTrainingBinding;
import com.example.alexa.pressupcounter.resulttraining.view.ResultTrainingFragment;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModel;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelFactory;
import com.example.alexa.pressupcounter.training.viewmodel.TrainingViewModelImpl;
import com.example.alexa.pressupcounter.utils.DialogFinishTraining;
import com.example.alexa.pressupcounter.utils.DialogTrainingRest;
import com.example.alexa.pressupcounter.utils.DialogTrainingRestOff;
import com.example.alexa.pressupcounter.utils.Timer;

/**
 * Created by Alexandr Mikhalev on 23.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class TrainingFragment extends Fragment {

    private TrainingViewModel mTrainingViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PressUp pressUp2 = getArguments().getParcelable(Constants.KEY_FOR_PRESS_UP);
        Timer timer = new Timer();
        mTrainingViewModel = ViewModelProviders.of(this, new TrainingViewModelFactory(pressUp2, timer)).get(TrainingViewModelImpl.class);
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

    public static TrainingFragment newInstance(PressUp pressUp) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.KEY_FOR_PRESS_UP, pressUp);
        TrainingFragment fragment = new TrainingFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
