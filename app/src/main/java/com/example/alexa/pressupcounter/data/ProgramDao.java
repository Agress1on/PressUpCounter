package com.example.alexa.pressupcounter.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by Alexandr Mikhalev on 21.02.2019.
 *
 * @author Alexandr Mikhalev
 */
@Dao
public interface ProgramDao {

    @Query("SELECT * FROM Program")
    Single<List<Program>> getAll();

    /*
    @Query("SELECT * FROM pressup2 WHERE id = :id")
    Flowable<List<Program>> getById(long id);
    */

    @Query("SELECT * FROM Program WHERE id = :id")
    Single<List<Program>> getProgramById(long id);

    @Insert
    Completable insert(Program program);

    @Update
    void update(Program program);

    @Delete
    Completable delete(Program program);

    @Query("DELETE FROM Program")
    Completable deleteAll();
}
