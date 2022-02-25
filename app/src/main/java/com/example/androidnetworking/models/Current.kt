package com.example.androidnetworking.models

data class Current(
    val lastUpdatedEpoch: Int,
    val lastUpdated: String,
    val temp_c: Double,
    val temp_f: Double,
    val isDay: Int,
    val condition: Condition,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDir: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val precipMm: Double,
    val precipIn: Double,
    val humidity: Int,
    val cloud: Int?,
    val feelslikeC: Double,
    val feelslikeF: Double,
    val visKm: Double,
    val visMiles: Double,
    val uv: Double,
    val gustMph: Double,
    val gustKph: Double,
)