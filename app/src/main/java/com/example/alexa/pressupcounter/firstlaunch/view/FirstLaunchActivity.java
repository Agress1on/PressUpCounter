package com.example.alexa.pressupcounter.firstlaunch.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityFirstLaunchBinding;

public class FirstLaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstLaunchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_launch);
    }
}
