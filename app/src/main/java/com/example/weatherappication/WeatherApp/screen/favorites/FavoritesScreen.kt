package com.example.weatherappication.WeatherApp.screen.favorites

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.bawp.jetweatherforecast.R
import com.example.weatherappication.WeatherApp.Model.Favorite
import com.example.weatherappication.WeatherApp.Widgets.WeatherAppBar

@Composable
fun FavoriteScreen(navController: NavController){
    Scaffold(topBar = {
        WeatherAppBar(
            title = "Favorite",
            icon = Icons.Default.ArrowBack,
            false,
            navController = navController){
            navController.popBackStack()
        }
    }) {
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Favorite Screen",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold)
            }

        }

    }

}
