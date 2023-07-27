package com.example.movieapp.WeatherForecastApp.di

import androidx.compose.ui.unit.Constraints
import com.example.weatherappication.WeatherApp.Network.WeatherApi
import com.example.weatherappication.WeatherApp.Utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule() {
    @Provides
    @Singleton
    fun provideOpenWeatherApi() : WeatherApi{
    return  Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(WeatherApi::class.java)
    }
}