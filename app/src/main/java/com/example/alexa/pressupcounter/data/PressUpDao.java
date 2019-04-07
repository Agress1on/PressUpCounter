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
public interface PressUpDao {

    @Query("SELECT * FROM PressUp")
    Single<List<PressUp>> getAll();

    /*
    @Query("SELECT * FROM pressup2 WHERE id = :id")
    Flowable<List<PressUp>> getById(long id);
    */

    @Query("SELECT * FROM PressUp WHERE id = :id")
    Single<List<PressUp>> getPressUpById(long id);

    @Insert
    Completable insert(PressUp pressUp);

    @Update
    void update(PressUp pressUp);

    @Delete
    Completable delete(PressUp pressUp);
}
