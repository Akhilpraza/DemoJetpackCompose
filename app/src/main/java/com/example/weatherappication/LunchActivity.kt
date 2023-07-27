package com.example.weatherappication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherappication.Basics.BasicActivity
import com.example.weatherappication.BizCard.BizCardActivity
import com.example.weatherappication.CalculatorApp.CalculatorAppActivity
import com.example.weatherappication.IntroToCompose.IntroToComposeActivity
import com.example.weatherappication.MovieApp.MovieAppActivity
import com.example.weatherappication.ui.theme.WeatherAppicationTheme

class LunchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
//                        Button(onClick = {
//                            val navigate = Intent()
//                            startActivity(navigate)
//                        }, shape = RoundedCornerShape(20.dp)) {
//                            Text(text = "Project 1")
//                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("BasicCompose", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, BasicActivity::class.java)
                            startActivity(intent)
                        })

                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("IntroToCompose", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, IntroToComposeActivity::class.java)
                            startActivity(intent)
                        })

                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("CalculatorApp", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, CalculatorAppActivity::class.java)
                            startActivity(intent)
                        })

                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("BizCard", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, BizCardActivity::class.java)
                            startActivity(intent)
                        })

                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("MovieApp", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, MovieAppActivity::class.java)
                            startActivity(intent)
                        })
                        Spacer(modifier = Modifier.height(16.dp))
                        Greeting("WeatherAppication", onClick = {
                            // this here is MainActivity

                            val intent = Intent(this@LunchActivity, MainActivity::class.java)
                            startActivity(intent)
                        })

                    }
                }
            }
        }
    }
}


//fun startDetailActivity() {
//    val intent = Intent(this@LunchActivity, BasicActivity::class.java)
//    startActivity(intent)
//}


@Composable
fun Greeting(name: String, onClick: () -> Unit) {

    Button(onClick = onClick) {
        Text(text = name)
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    WeatherAppicationTheme {
        Greeting2("Android")
    }
}