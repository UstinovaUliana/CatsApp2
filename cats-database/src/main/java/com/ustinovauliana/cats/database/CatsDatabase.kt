package com.ustinovauliana.cats.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ustinovauliana.cats.database.dao.CatsDAO
import com.ustinovauliana.cats.database.models.CatsDBO

class CatsDatabase internal constructor(private val database: CatsRoomDatabase){
    val catsDAO:CatsDAO
        get() = database.catsDAO()
}

@Database(entities = [CatsDBO::class], version = 1)
internal abstract class CatsRoomDatabase : RoomDatabase() {
    abstract fun catsDAO() : CatsDAO
}

fun CatsDatabase(applicationContext: Context) : CatsDatabase {
    return CatsDatabase(
        Room.databaseBuilder(
            checkNotNull(applicationContext.applicationContext),
            CatsRoomDatabase::class.java,
            "cats"
        )
            .build()
    )
}

