package com.example.alexa.pressupcounter.firstlaunch.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.Constants;
import com.example.alexa.pressupcounter.Logger;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.databinding.FragmentContainerForTabsBinding;
import com.example.alexa.pressupcounter.firstlaunch.router.FirstLaunchRouter;
import com.example.alexa.pressupcounter.firstlaunch.viewmodel.FirstLaunchViewModel;
import com.example.alexa.pressupcounter.setprogram.view.SetProgramFragment;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import dagger.android.support.AndroidSupportInjection;

/**
 * Created by Alexandr Mikhalev on 28.03.2019.
 *
 * @author Alexandr Mikhalev
 */
public class FirstLaunchFragment extends Fragment {

    @Inject
    FirstLaunchViewModel mFirstLaunchViewModel;
    @Inject
    FirstLaunchRouter mFirstLaunchRouter;

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private TabLayout mTabLayout;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentContainerForTabsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_container_for_tabs, container, false);
        binding.setViewModel(mFirstLaunchViewModel);
        Logger.d("FirstLaunchFragment", mFirstLaunchViewModel.toString());
        mPager = binding.pager;
        mPagerAdapter = new MyFragmentPagerAdapter(getActivity().getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mTabLayout = binding.tabLayout;
        mTabLayout.setupWithViewPager(mPager, true);
        mFirstLaunchViewModel.setNewRouter(mFirstLaunchRouter);
        return binding.getRoot();
    }

    public void goToSetProgram() {
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, SetProgramFragment.newInstance())
                .commit();
    }

    public static FirstLaunchFragment newInstance() {
        Bundle args = new Bundle();
        FirstLaunchFragment fragment = new FirstLaunchFragment();
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
