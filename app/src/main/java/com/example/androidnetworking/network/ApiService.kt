package com.example.androidnetworking.network

import com.example.androidnetworking.models.Condition
import retrofit2.http.GET


interface ApiService {

    @GET("/current.json")
    suspend fun getCurrentWeather(): Condition

}