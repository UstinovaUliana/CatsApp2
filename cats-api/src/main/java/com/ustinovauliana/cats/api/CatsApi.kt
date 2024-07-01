package com.ustinovauliana.cats.api

import androidx.annotation.IntRange
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import com.ustinovauliana.cats.api.utils.CatsApiKeyInterceptor
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

/*
API details: https://developers.thecatapi.com/view-account/ylX4blBYT9FaoVd6OhvR?report=bOoHBz-8t
 */
interface CatsApi {
    @GET("images/search")
    suspend fun searchImages(
        @Query("limit") @IntRange(from = 0, to = 100) limit: Int? = null,
        @Query("page") page: Int? = null,
        @Query("order") order: String? = null,
        //TODO("Make converter for has_breeds 0/1 to false/true")
        @Query("has_breeds")  @IntRange(from = 0, to = 100) hasBreeds: Int? = null,
        @Query("breed_ids") breedIds: String? = null,
        @Query("category_ids") categoryIds: Int? = null,
        @Query("sub_id") subId: Int? = null,
    )
}

fun CatsApi(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json,
) : CatsApi {
    return retrofit(baseUrl,apiKey,okHttpClient,json).create(CatsApi::class.java)
}

private fun retrofit(
    baseUrl: String,
    apiKey: String,
    okHttpClient: OkHttpClient?,
    json: Json,
) : Retrofit {
    val okHttpClientWithInterceptor = (okHttpClient?.newBuilder() ?:OkHttpClient.Builder())
        .addInterceptor(CatsApiKeyInterceptor(apiKey))
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(okHttpClientWithInterceptor)
        .build()
}
