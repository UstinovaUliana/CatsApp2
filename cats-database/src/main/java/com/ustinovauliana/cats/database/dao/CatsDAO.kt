package com.ustinovauliana.cats.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ustinovauliana.cats.database.models.CatsDBO

@Dao
interface CatsDAO {
    @Query("SELECT * FROM cats")
    suspend fun selectAll(): List<CatsDBO>

    @Insert
    suspend fun insert(cats: List<CatsDBO>)

    @Delete
    suspend fun remove(cats: List<CatsDBO>)

    @Query("DELETE FROM cats")
    suspend fun clean()
}
