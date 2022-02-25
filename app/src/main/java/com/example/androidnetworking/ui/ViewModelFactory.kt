package com.example.androidnetworking.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidnetworking.data.MainRepository
import com.example.androidnetworking.network.RetrofitBuilder

class ViewModelFactory(private val retrofit: RetrofitBuilder) : ViewModelProvider.Factory {



    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(retrofit)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}