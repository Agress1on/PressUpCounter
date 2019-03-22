package com.example.alexa.pressupcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchActivity;
import com.example.alexa.pressupcounter.main.view.MainActivity;

public class SplashActivity extends AppCompatActivity {


    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences(Constants.MY_SETTINGS, Context.MODE_PRIVATE);

        boolean hasVisited = sp.getBoolean(Constants.TAG_FOR_SPLASH_BOOLEAN, false);
        if (!hasVisited) {
            Intent intent = FirstLaunchActivity.getIntent(this);
            startActivity(intent);

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(Constants.TAG_FOR_SPLASH_BOOLEAN, true);
            editor.commit();
        } else {
            Intent intent = MainActivity.getIntent(this);
            startActivity(intent);

        }
        finish();

    }
}
