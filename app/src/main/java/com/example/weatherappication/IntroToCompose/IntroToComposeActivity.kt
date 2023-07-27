package com.example.weatherappication.IntroToCompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.weatherappication.LunchActivity

class IntroToComposeActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.background(color = Color(0xFF546E7A))) {
                Button(onClick = {
                    val intent = Intent(this@IntroToComposeActivity, LunchActivity::class.java)
                    startActivity(intent)
                }) {
                    Text(text = "Go Back")
                }
                MyApp()
            }


        }
    }
}

@Composable
private fun MyApp() {
    val moneyCounter = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), color = Color(0xFF546E7A)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "$ ${moneyCounter.value}",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Spacer(modifier = Modifier.height(130.dp))
            CreateCircle(moneyCounter = moneyCounter.value){ newvalue ->
                moneyCounter.value = newvalue
                // moneyCounter.value = it+1
            }
            if(moneyCounter.value >25){
                Text(text = "Lots of Money!")
            }
        }


    }
}

@Composable
fun CreateCircle(moneyCounter: Int =0,updateMoneyCounter:(Int) -> Unit) {
//    var moneyCounter = remember {
//        mutableStateOf(0)
//    }
//    var moneyCounter by remember {
//        mutableStateOf(0)
//    }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter + 1)
                // moneyCounter += 1
                // Log.d("Tap", "CreateCircle  $moneyCounter")
            }, shape = CircleShape,
        elevation = 4.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", modifier = Modifier)

        }
    }
}
