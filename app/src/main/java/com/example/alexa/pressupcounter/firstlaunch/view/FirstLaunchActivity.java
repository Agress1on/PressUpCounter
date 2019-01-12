package com.example.alexa.pressupcounter.firstlaunch.view;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.ActivityFirstLaunchBinding;

public class FirstLaunchActivity extends AppCompatActivity {

    static final  int PAGE_COUNT = 20;

    ViewPager mPager;
    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstLaunchBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first_launch);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
