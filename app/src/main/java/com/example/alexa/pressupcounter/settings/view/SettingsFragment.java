package com.example.alexa.pressupcounter.settings.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentSettingsBinding;
import com.example.alexa.pressupcounter.dialogs.ErrorDialog;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.example.alexa.pressupcounter.settings.router.SettingsRouter;
import com.example.alexa.pressupcounter.settings.viewmodel.SettingsViewModel;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsFragment extends Fragment {

    @Inject
    SettingsViewModel mSettingsViewModel;

    @Inject
    SettingsRouter mSettingsRouter;

    private static final String ERROR_DIALOG = "Error_Dialog_Settings_Fragment";

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        binding.setViewModel(mSettingsViewModel);
        mSettingsViewModel.setCurrentRouter(mSettingsRouter);
        return binding.getRoot();
    }

    public void setSetTrainingDay() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetTrainingDayFragment.newInstance())
                .commit();
    }

    public void setSetProgram() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetProgramFragment.newInstance())
                .commit();
    }

    public void showToast() {
        Toast.makeText(getContext(), "Последняя программа удалена", Toast.LENGTH_SHORT).show();
    }

    public void showErrorDialog() {
        ErrorDialog errorDialog = new ErrorDialog();
        errorDialog.show(getChildFragmentManager(), ERROR_DIALOG);
    }

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
