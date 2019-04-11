package com.example.alexa.pressupcounter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexandr Mikhalev on 18.01.2019.
 *
 * @author Alexandr Mikhalev
 */
public class Constants {

    public static List<Integer> initList;

    static {
        initList = new ArrayList<>();
        initList.add(2); //FirstRepetition
        initList.add(3); //SecondRepetition
        initList.add(1); //ThirdRepetition
        initList.add(1); //FourthRepetition
        initList.add(3); //FifthRepetition
    }

    //Settings
    public static final int PAGE_COUNT = 3;

    public static final int TIME_OF_MAIN_REST = 10;

    public static final int TIME_OF_ADDITIONAL_REST = 5;

    public static final String LOGGER = "LOGGER";

    public static final String TAG_FOR_IS_SUCCESS_TRAINING = "TAG_FOR_IS_SUCCESS_TRAINING";

    public static final String TEXT_FOR_SET_TIME_STRING = "SET TIME";

    public static final String KEY_FOR_SET_TIME_BUNDLE = "KEY_FOR_SET_TIME_BUNDLE";
}
