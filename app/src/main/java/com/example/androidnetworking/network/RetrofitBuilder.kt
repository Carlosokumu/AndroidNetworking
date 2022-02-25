package com.example.androidnetworking.network

import com.example.androidnetworking.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBuilder {



    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.REST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}