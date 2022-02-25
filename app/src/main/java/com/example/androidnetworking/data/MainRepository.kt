package com.example.androidnetworking.data

import com.example.androidnetworking.network.RetrofitBuilder





class MainRepository(private val retrofit: RetrofitBuilder) {





    suspend fun fetchCurrentWeather(cityName: String) = retrofit.apiService.getCurrentWeather(cityName = cityName)
}