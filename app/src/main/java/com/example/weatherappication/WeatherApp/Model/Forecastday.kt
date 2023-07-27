package com.example.weatherappication.WeatherApp.Model

import com.example.weatherappication.WeatherApp.Model2.Day
import com.example.weatherappication.WeatherApp.Model2.Hour

data class Forecastday(
    val astro: Astro,
    val date: String,
    val date_epoch: Int,
    val day: Day,
    val hour: List<Hour>
)