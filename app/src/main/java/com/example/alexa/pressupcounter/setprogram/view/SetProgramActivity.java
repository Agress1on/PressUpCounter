package com.example.alexa.pressupcounter.setprogram.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * Created by Alexandr Mikhalev on 22.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_program);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, SetProgramFragment.newInstance())
                    .commit();
        }
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, SetProgramActivity.class);
    }
}
