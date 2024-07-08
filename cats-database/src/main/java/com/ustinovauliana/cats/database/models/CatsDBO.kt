package com.ustinovauliana.cats.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cats")
data class CatsDBO (
    @PrimaryKey val id: String,
    @ColumnInfo("width") val width:  Int,
    @ColumnInfo("height") val height:  Int,
    @ColumnInfo("url") val url:  String,
    @ColumnInfo("breeds") val breeds:  List<Breed>,
    // @ColumnInfo("favourite") val id:  String,
)
data class Breed (
    @ColumnInfo("id") val breedId: String,
    @ColumnInfo("name") val breedName: String,
    @ColumnInfo("temperament") val temperament: String,
    @ColumnInfo("origin") val origin: String,
    @ColumnInfo("life_span") val lifeSpan: String,
    @ColumnInfo("wikipedia_url") val wikiUrl: String,
)
