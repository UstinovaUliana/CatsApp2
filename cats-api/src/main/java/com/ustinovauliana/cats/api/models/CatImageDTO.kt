package com.ustinovauliana.cats.api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatImageDTO (
    @SerialName("id") val id:  String,
    @SerialName("width") val width:  Int,
    @SerialName("height") val height:  Int,
    @SerialName("url") val url:  String,
    @SerialName("breeds") val breeds:  List<Breed>,
   // @SerialName("favourite") val id:  String,
    )
data class Breed (
    @SerialName("id") val breedId: String,
    @SerialName("name") val breedName: String,
    @SerialName("temperament") val temperament: String,
    @SerialName("origin") val origin: String,
    @SerialName("life_span") val lifeSpan: String,
    @SerialName("wikipedia_url") val wikiUrl: String,
)
