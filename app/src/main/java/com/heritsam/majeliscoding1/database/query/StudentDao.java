package com.heritsam.majeliscoding1.database.query;

import com.heritsam.majeliscoding1.database.table.StudentEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM studententity")
    List<StudentEntity> select();

    @Insert
    void insert(StudentEntity entity);

    @Update
    void update(StudentEntity entity);

    @Delete
    void delete(StudentEntity entity);
}
