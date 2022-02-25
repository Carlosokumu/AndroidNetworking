package com.example.androidnetworking.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.androidnetworking.data.MainRepository
import com.example.androidnetworking.network.ApiModel
import kotlinx.coroutines.Dispatchers


class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {




    fun fetchCurrentWeather() = liveData(Dispatchers.IO) {
        emit(ApiModel.loading(data = null))
        try {
            emit(ApiModel.success(data = mainRepository.fetchCurrentWeather()))
        } catch (exception: Exception) {
            emit(ApiModel.error(data = null, message = exception.message ?: "Something went Wrong"))
        }
    }
}