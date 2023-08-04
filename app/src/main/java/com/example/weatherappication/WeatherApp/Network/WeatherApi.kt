package com.example.weatherappication.WeatherApp.Network


import com.example.weatherappication.WeatherApp.Model2.Weather
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {
    @Headers(
        "X-RapidAPI-Key: 214c500f7fmsh4be6737b93bb288p1438d3jsnb641bb86c5b6",
        "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
    )
    @GET(value = "forecast.json")
    suspend fun getWeather(
        @Query("q") query: String ="London",
        @Query("days") unit: String = "3",
    ): Weather
}