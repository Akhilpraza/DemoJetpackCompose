package com.example.weatherappication.WeatherApp.Network


import com.example.weatherappication.WeatherApp.Model2.Weather
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @GET(value = "forecast.json")
    suspend fun getWeather(
        @Query("q") query: String,
        @Query("days") unit: String = "3",
    ): Weather
}