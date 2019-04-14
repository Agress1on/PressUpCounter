package com.example.alexa.pressupcounter.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import androidx.room.TypeConverter;

/**
 * Created by Alexandr Mikhalev on 14.04.2019.
 *
 * @author Alexandr Mikhalev
 */
public class RepetitionsConverter {
    @TypeConverter
    public String fromRepetitions(List<Integer> repetitions) {
        String genreIds = "";
        for (int i : repetitions) {
            genreIds += "," + i;
        }
        return genreIds;
    }

    @TypeConverter
    public List<Integer> toRepetitions(String repetition) {
        List<Integer> list = new ArrayList<>();

        String[] array = repetition.split(",");

        for (String s : array) {
            if (!s.isEmpty()) {
                list.add(Integer.parseInt(s));
            }
        }
        return list;
    }
}
