package com.example.androidpaginglibrary_30_example.network.api

import com.example.androidpaginglibrary_30_example.network.model.PessangerResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PassangerApi {

    @GET("passenger")
    suspend fun getPessagngersData(
        @Query("page")page:Int?,
        @Query("size")size:Int = 10
    ): PessangerResponse
}