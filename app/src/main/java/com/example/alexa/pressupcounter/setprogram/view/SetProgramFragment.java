package com.example.alexa.pressupcounter.setprogram.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSetProgramBinding;
import com.example.alexa.pressupcounter.dialogs.ErrorDialog;
import com.example.alexa.pressupcounter.setprogram.router.SetProgramRouter;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModel;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramFragment extends Fragment {

    private static final String ERROR_DIALOG = "Error_Dialog_Set_Program_Fragment";

    @Inject
    SetProgramViewModel mSetProgramViewModel;

    @Inject
    SetProgramRouter mSetProgramRouter;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetProgramBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_program, container, false);
        binding.setViewModel(mSetProgramViewModel);
        mSetProgramViewModel.setCurrentRouter(mSetProgramRouter);
        return binding.getRoot();
    }

    public void setStartTraining() {
        if (getActivity() == null) return;
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public void showErrorDialog() {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getChildFragmentManager(), ERROR_DIALOG);
    }

    public static SetProgramFragment newInstance() {
        Bundle args = new Bundle();
        SetProgramFragment fragment = new SetProgramFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
