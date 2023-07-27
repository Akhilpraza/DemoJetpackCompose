package com.example.weatherappication.WeatherApp.screen

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherappication.WeatherApp.Data.DataOrException
import com.example.weatherappication.WeatherApp.Main.MainViewModel
import com.example.weatherappication.WeatherApp.Model.Weather

@Composable
fun MainScreen(navController: NavController, mainViewModel: MainViewModel = hiltViewModel()
){

        ShowData(mainViewModel)
}

@Composable
fun ShowData(mainViewModel: MainViewModel) {
    val  weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue =DataOrException(loading = true)){
       // value =mainViewModel.getWeatherData(city = "seattle")
    }.value

    if (weatherData.loading ==true){
        CircularProgressIndicator()
    }else if (weatherData.data !=null){
        Text(text = "Main Screen ${weatherData.data!!.toString()}")
    }

}
