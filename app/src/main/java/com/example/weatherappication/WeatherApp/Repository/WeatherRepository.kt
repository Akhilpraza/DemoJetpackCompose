package com.example.weatherappication.WeatherApp.Repository

import android.util.Log
import com.example.weatherappication.WeatherApp.Data.DataOrException
import com.example.weatherappication.WeatherApp.Model2.Weather
import com.example.weatherappication.WeatherApp.Model.WeatherObject
import com.example.weatherappication.WeatherApp.Network.WeatherApi
import retrofit2.http.Header
import retrofit2.http.Headers
import javax.inject.Inject

//@Headers({
//    "X-RapidAPI-Key: 214c500f7fmsh4be6737b93bb288p1438d3jsnb641bb86c5b6"
//    "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com"
//})
class WeatherRepository @Inject  constructor(private val api: WeatherApi) {
    suspend fun getWeather(ForecastQuery: String):DataOrException<Weather,Boolean,Exception>{
    val response = try {
        api.getWeather(query = ForecastQuery)

    }
    catch (e:Exception){
        Log.d("REX","getWeather : $e"    )
        return DataOrException(e =e)
    }
        Log.d("INSIDE","getWeather : $response" )
        return DataOrException(data = response)
    }
}