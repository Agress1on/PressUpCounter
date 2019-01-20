package com.example.alexa.pressupcounter.main.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityMainBinding;
import com.example.alexa.pressupcounter.start.view.StartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, StartFragment.newInstance())
                    .commit();
        }
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
