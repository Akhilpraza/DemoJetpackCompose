package com.example.weatherappication.WeatherApp.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bawp.jetweatherforecast.R
import com.example.weatherappication.WeatherApp.Data.DataOrException
import com.example.weatherappication.WeatherApp.Main.MainViewModel
import com.example.weatherappication.WeatherApp.Model2.Day
import com.example.weatherappication.WeatherApp.Model2.Forecastday
import com.example.weatherappication.WeatherApp.Model2.Weather
import com.example.weatherappication.WeatherApp.Navigation.WheatherScreen
import com.example.weatherappication.WeatherApp.Utils.formatDate
import com.example.weatherappication.WeatherApp.Utils.formatDateTime
import com.example.weatherappication.WeatherApp.Utils.formatDecimals
import com.example.weatherappication.WeatherApp.Widgets.*


@Composable
fun MainScreen(
    navController: NavController, mainViewModel: MainViewModel = hiltViewModel()
) {
    val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = mainViewModel.getWeatherData()
    }.value

    if (weatherData.loading == true) {
        CircularProgressIndicator()
    } else if (weatherData.data != null) {
        Text(text = "Main Screen ${weatherData.data!!.toString()}")
        MainScaffold(weather = weatherData.data!!, navController)
    }
}

@Composable
fun MainScaffold(weather: Weather, navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = weather.location.name + ",${weather.location.country}",
            //icon = Icons.Default.ArrowBack,
            navController = navController, elevation = 5.dp,
            onAddActionClicked = {
                navController.navigate(WheatherScreen.SearchScreen.name)
            }
        ) {
            Log.d("TAG", "MainScaffold Button Click")
        }
    }) {
        MainContent(data = weather)
    }
}

@Composable
fun MainContent(data: Weather) {
    val weatherItem = data.forecast.forecastday[0]
    // Text(text = data.forecast.forecastday[0].date)

    //val imageUrl = "https://openweathermap.org/img/wn/10d.png${data!!.forecast.forecastday[0].day.condition.icon}.png"
    //val imageUrl = "https://openweathermap.org/img/wn/10d.png$"

    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = formatDate(weatherItem.date_epoch),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )

        Surface(
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp), shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(imageUrl = "https://openweathermap.org/img/wn/10d.png")
                Text(
                    text = formatDecimals(weatherItem.day.maxtemp_f) + "º",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = weatherItem.day.condition.text, fontStyle = FontStyle.Italic)
            }
        }
        HumidityWindPressureRow(forecastday = data.forecast.forecastday[0])
        Divider()
        SunsetSunRiseRow(forecastday = data.forecast.forecastday[0])
        Text(
            text = "Three Day",
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFFEEF1EF),
            shape = RoundedCornerShape(size = 8.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(2.dp),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(items = data.forecast.forecastday){ item: Forecastday ->
                    WeatherDetailRow(forecastday = item)
                }

//                items(items = weatherItem) { item: Forecastday ->
//                    WeatherDetailRow(forecastday = item)
//                }

            }

        }
    }
}
