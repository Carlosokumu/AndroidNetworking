package com.example.androidnetworking.network

import com.example.androidnetworking.models.Condition
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("/current.json")
    suspend fun getCurrentWeather(@Query("q") cityName: String): Condition

}