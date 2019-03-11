package com.example.alexa.pressupcounter;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

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
    Flowable<List<PressUp2>> getById(long id);


    @Query("SELECT * FROM pressup2 WHERE id = :id")
    Single<List<PressUp2>> getPressUpById(long id);

    @Insert
    Completable insert(PressUp2 pressUp2);

    @Update
    void update(PressUp2 pressUp2);

    @Delete
    void delete(PressUp2 pressUp2);
}
