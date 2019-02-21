package com.heritsam.majeliscoding1.database;

import com.heritsam.majeliscoding1.database.query.StudentDao;
import com.heritsam.majeliscoding1.database.table.StudentEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {
                StudentEntity.class
        },
        version = 1,
        exportSchema = false
)
public abstract class DataHelper extends RoomDatabase {
    public abstract StudentDao studentDao();
}
