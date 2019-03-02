package com.example.alexa.pressupcounter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Dao
public interface PressUpDao {

    @Query("SELECT * FROM pressup2")
    List<PressUp2> getAll();

    @Query("SELECT * FROM pressup2 WHERE id = :id")
    PressUp2 getById(long id);

    @Insert
    void insert(PressUp2 pressUp2);

    @Update
    void update(PressUp2 pressUp2);

    @Delete
    void delete(PressUp2 pressUp2);
}
