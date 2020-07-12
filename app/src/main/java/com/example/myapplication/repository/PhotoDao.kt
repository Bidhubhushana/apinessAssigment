package com.example.myapplication.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
internal interface PhotoDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAll(photos: List<PhotoDbEntity>)

  @Query("SELECT * FROM photos WHERE id = :photoId LIMIT 1")
  fun loadPhotoById(photoId: String): PhotoDbEntity?
}
