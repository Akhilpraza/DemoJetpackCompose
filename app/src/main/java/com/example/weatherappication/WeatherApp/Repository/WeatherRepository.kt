package com.example.weatherappication.WeatherApp.Repository

import android.util.Log
import com.example.weatherappication.WeatherApp.Data.DataOrException
import com.example.weatherappication.WeatherApp.Model2.Weather
import com.example.weatherappication.WeatherApp.Model.WeatherObject
import com.example.weatherappication.WeatherApp.Network.WeatherApi
import retrofit2.http.Header
import retrofit2.http.Headers
import javax.inject.Inject

class WeatherRepository @Inject  constructor(private val api: WeatherApi) {
    suspend fun getWeather():DataOrException<Weather,Boolean,Exception>{
        val response = try {
            api.getWeather()

        }
        catch (e:Exception){
            Log.d("REX","getWeather : $e"    )
            return DataOrException(e =e)
        }
        Log.d("INSIDE","getWeather : $response" )
        return DataOrException(data = response)
    }
}