package com.example.alexa.pressupcounter.firstlaunch.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentContainerForTabsBinding;
import com.example.alexa.pressupcounter.events.ActivityEvent;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModel;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModelImpl;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.example.alexa.pressupcounter.settrainingday.view.SetTrainingDayFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class ContainerForTabs extends Fragment {

    private FirstLaunchViewModel mFirstLaunchViewModel;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFirstLaunchViewModel = ViewModelProviders.of(this).get(FirstLaunchViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentContainerForTabsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_container_for_tabs, container, false);
        binding.setViewModel(mFirstLaunchViewModel);
        //
        mPager = binding.pager;
        mPagerAdapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mTabLayout = binding.tabLayout;
        mTabLayout.setupWithViewPager(mPager, true);

        return binding.getRoot();
    }

    private void init() {
        mFirstLaunchViewModel.getActivityEventMutableLiveData().observe(this, new Observer<ActivityEvent>() {
            @Override
            public void onChanged(ActivityEvent activityEvent) {
                if (activityEvent == null || activityEvent.isHappened()) return;
                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.fragment_container, SetProgramFragment.newInstance())
                        .commit();
                activityEvent.setHappened(true);
            }
        });
    }

    public static ContainerForTabs newInstance() {
        Bundle args = new Bundle();
        ContainerForTabs fragment = new ContainerForTabs();
        fragment.setArguments(args);
        return fragment;
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
