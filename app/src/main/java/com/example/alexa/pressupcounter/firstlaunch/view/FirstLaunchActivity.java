package com.example.alexa.pressupcounter.firstlaunch.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityFirstLaunchBinding;
import com.example.alexa.pressupcounter.events.ActivityEvent;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModel;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModelImpl;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramActivity;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

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
        mViewModel = ViewModelProviders.of(this).get(FirstLaunchViewModelImpl.class);
        binding.setViewModel(mViewModel);
        init();
        /*
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager, true);
        */
        mPager = binding.pager;
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mTabLayout = binding.tabLayout;
        mTabLayout.setupWithViewPager(mPager, true);
    }

    private void startSetProgramActivity() {
        Intent intent = SetProgramActivity.getIntent(this);
        startActivity(intent);
    }

    private void init() {
        mViewModel.getActivityEventMutableLiveData().observe(this, new Observer<ActivityEvent>() {
            @Override
            public void onChanged(ActivityEvent activityEvent) {
                if (activityEvent == null || activityEvent.isHappened()) return;
                startSetProgramActivity();
                activityEvent.setHappened(true);
            }
        });
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
