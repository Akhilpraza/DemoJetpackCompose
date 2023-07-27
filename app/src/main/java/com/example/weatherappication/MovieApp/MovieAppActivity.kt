package com.example.weatherappication.MovieApp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.movieapp.navagation.MovieNavigation
import com.example.weatherappication.LunchActivity
import com.example.weatherappication.MovieApp.ui.theme.WeatherAppicationTheme

class MovieAppActivity() : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.background(color = Color.White)) {
                Button(onClick = {
                    val intent = Intent(this@MovieAppActivity, LunchActivity::class.java)
                    startActivity(intent)
                }) {
                    Text(text = "Go Back")
                }
                MyApp {
                    MovieNavigation()
                }
            }


        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MyApp(content: @Composable () -> Unit) {
    WeatherAppicationTheme {
        content()
    }
}




@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigation()
    }
}