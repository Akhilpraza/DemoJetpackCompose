package com.example.weatherappication.WeatherApp.Navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherappication.WeatherApp.Main.MainViewModel
import com.example.weatherappication.WeatherApp.screen.MainScreen
import com.example.weatherappication.WeatherApp.screen.WeatherSpalshScreen


@SuppressLint("SuspiciousIndentation")
@Composable
fun WeatherNavigation() {
 val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = WheatherScreen.SpalshScreen.name ){
        composable(WheatherScreen.SpalshScreen.name){
            WeatherSpalshScreen(navController =navController)
        }
        composable(WheatherScreen.MainScreen.name){
           // val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController =navController)
        }
    }
}