package com.example.alexa.pressupcounter.settings.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentSettingsBinding;
import com.example.alexa.pressupcounter.settings.inject.SettingsModule;
import com.example.alexa.pressupcounter.settings.viewmodel.SettingsViewModel;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SettingsFragment extends Fragment {

    @Inject
    SettingsViewModel mSettingsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().createSettingsComponent(new SettingsModule(this)).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        binding.setViewModel(mSettingsViewModel);
        return binding.getRoot();
    }

    public void goToSetTrainingDay() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetTrainingDayFragment.newInstance())
                .commit();
    }

    public void showToast() {
        Toast.makeText(getContext(), "Последняя программа удалена", Toast.LENGTH_SHORT).show();
    }

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
