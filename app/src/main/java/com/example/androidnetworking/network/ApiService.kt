package com.example.androidnetworking.network

import com.example.androidnetworking.models.Condition
import com.example.androidnetworking.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("v1/current.json")
    suspend fun getCurrentWeather(@Query("key") key: String ="94d124c031ba4486b9c81847222402",@Query("q") cityName: String?): WeatherResponse

}