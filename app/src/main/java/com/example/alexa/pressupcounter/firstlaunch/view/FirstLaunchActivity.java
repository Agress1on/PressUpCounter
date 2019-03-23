package com.example.alexa.pressupcounter.firstlaunch.view;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import com.example.alexa.pressupcounter.setprogram.view.SetProgramActivity;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityFirstLaunchBinding;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModel;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModelImpl;
import com.example.alexa.pressupcounter.main.view.MainActivity;

public class FirstLaunchActivity extends AppCompatActivity {

    private FirstLaunchViewModel mViewModel;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.d(Constants.LOGGER, "Main");
        ActivityFirstLaunchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_launch);
        mViewModel = new FirstLaunchViewModelImpl(new FirstLaunchViewModelImpl.OnStartMainActivityListener() {
            @Override
            public void onClick() {
                startMainActivity();
            }
        });
        binding.setViewModel(mViewModel);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager, true);
    }

    void startMainActivity() {
        Intent intent = SetProgramActivity.getIntent(this);
        startActivity(intent);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, FirstLaunchActivity.class);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = FirstFragment.newInstance();
                    break;
                case 1:
                    fragment = SecondFragment.newInstance();
                    break;
                case 2:
                    fragment = ThirdFragment.newInstance();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return Constants.PAGE_COUNT;
        }
    }
}
