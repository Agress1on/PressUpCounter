package com.example.alexa.pressupcounter.main.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityMainBinding;
import com.example.alexa.pressupcounter.firstlaunch.view.FirstLaunchFragment;
import com.example.alexa.pressupcounter.main.router.MainRouter;
import com.example.alexa.pressupcounter.main.viewmodel.MainViewModel;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.example.alexa.pressupcounter.starttraining.view.StartTrainingFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel mMainViewModel;

    @Inject
    MainRouter mMainRouter;

    private SharedPreferences mSharedPreferences;

    private static final String LAUNCH_SETTINGS = "launch";
    private static final String HAS_VISITED = "has_visited";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mMainViewModel);
        mMainViewModel.setRouter(mMainRouter);
        mSharedPreferences = getSharedPreferences(LAUNCH_SETTINGS, Context.MODE_PRIVATE);
        boolean hasVisited = mSharedPreferences.getBoolean(HAS_VISITED, false);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            if (!hasVisited) {
                mMainViewModel.onFirstLaunch();
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putBoolean(HAS_VISITED, true);
                editor.apply();
            }
        }
        // JSON example
        /*
        try {
            JSONObject object = new JSONObject();
            object.put("test", true);
            JSONObject data = new JSONObject();
            data.put("age", 25);
            JSONArray array = new JSONArray();
            array.put("blond");
            array.put("brown");
            data.put("hair", array);
            object.put("data", data);
            Log.d("MAIN", "json: " + object.toString());

            boolean test = object.getBoolean("test");
            JSONObject jData = object.getJSONObject("data");
            int age = jData.getInt("age");
            Log.d("MAIN", "test=" + test + " age=" + age);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */
    }

    public void goToFirstLaunch() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, FirstLaunchFragment.newInstance())
                .commit();
    }

    public void goToSetProgram() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, SetProgramFragment.newInstance())
                .commit();
    }

    public void goToStartTraining() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, StartTrainingFragment.newInstance())
                .commit();
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
}
