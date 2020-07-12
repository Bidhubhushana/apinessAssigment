package com.example.myapplication.repository;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {PhotoDbEntity.class}, version = 1)
abstract class AppDatabase extends RoomDatabase {
  public abstract PhotoDao photoDao();
}
