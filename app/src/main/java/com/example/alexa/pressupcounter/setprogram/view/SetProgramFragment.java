package com.example.alexa.pressupcounter.setprogram.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexa.pressupcounter.AppDatabase;
import com.example.alexa.pressupcounter.FragmentEvent;
import com.example.alexa.pressupcounter.PressUp2;
import com.example.alexa.pressupcounter.PressUpDao;
import com.example.alexa.pressupcounter.R;
import com.example.alexa.pressupcounter.app.App;
import com.example.alexa.pressupcounter.databinding.FragmentSetProgramBinding;
import com.example.alexa.pressupcounter.setprogram.model.SetProgramModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModel;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelFactory;
import com.example.alexa.pressupcounter.setprogram.viewmodel.SetProgramViewModelImpl;
import com.example.alexa.pressupcounter.testfragment.view.TestFragment;

/**
 * Created by Alexandr Mikhalev on 05.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class SetProgramFragment extends Fragment {

    private SetProgramViewModel mSetProgramViewModel;

    //BD
    private AppDatabase db;
    private PressUpDao pressUpDao;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mSetProgramViewModel = ViewModelProviders.of(this).get(SetProgramViewModelImpl.class);

        //DB
        db = App.getInstance().getDatabase();
        pressUpDao = db.pressUpDao();


        SetProgramModel setProgramModel = new SetProgramModel(db, pressUpDao);
        mSetProgramViewModel = ViewModelProviders.of(this, new SetProgramViewModelFactory(setProgramModel)).get(SetProgramViewModelImpl.class);
        init();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSetProgramBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_program, container, false);
        binding.setViewModel(mSetProgramViewModel);
        return binding.getRoot();
    }

    private void init() {
        mSetProgramViewModel.getFragmentEvent().observe(this, new Observer<FragmentEvent>() {
            @Override
            public void onChanged(@Nullable FragmentEvent fragmentEvent) {
                if (fragmentEvent == null || fragmentEvent.isHappend()) return;

                //db start
                final PressUp2 pressUp2 = new PressUp2();
                pressUp2.id = 1;
                pressUp2.mFirstRepetition = mSetProgramViewModel.getPressUp().get().getFirstRepetition();
                pressUp2.mSecondRepetition = mSetProgramViewModel.getPressUp().get().getSecondRepetition();
                pressUp2.mThirdRepetition = mSetProgramViewModel.getPressUp().get().getThirdRepetition();
                pressUp2.mFourthRepetition = mSetProgramViewModel.getPressUp().get().getFourthRepetition();
                pressUp2.mFifthRepetition = mSetProgramViewModel.getPressUp().get().getFifthRepetition();
                //pressUpDao.insert(pressUp2);

                /*
                Observable.fromCallable(() -> db.pressUpDao().insert(pressUp2))
                        .subscribeOn(Schedulers.io())
                        .subscribe();
                */
                //db end


                getActivity().getSupportFragmentManager().beginTransaction()
                        .addToBackStack(null)
                        //.replace(R.id.fragment_container, StartTrainingFragment.newInstance(mSetProgramViewModel.getPressUp().get()))
                        .replace(R.id.fragment_container, TestFragment.newInstance())
                        .commit();
                fragmentEvent.setHappend(true);
            }
        });
    }

    public static SetProgramFragment newInstance() {
        Bundle args = new Bundle();
        SetProgramFragment fragment = new SetProgramFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
