package com.example.weatherappication.Basics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bawp.jetweatherforecast.R
import com.example.weatherappication.LunchActivity


class BasicActivity() : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyBasic()
        }
    }

    @Composable
    private fun MyBasic() {
        Column() {
            Button(onClick = {
                val intent = Intent(this@BasicActivity, LunchActivity::class.java)
                startActivity(intent)
            }) {
                Text(text = "Go Back")
            }
            TextFunction()
            //ImgFunction()
            ButtonFunction()
            ButtonWithColor()
           // ButtonWithIcon()
            ButtonWithRoundCornerShape()
            ButtonWithBorder()
            ButtonWithElevation()
            TestInput()
            OutLineTextField()
            TextFieldWithIcons()
            Card()
            Row()
            Column()
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 1000, showSystemUi = true)
@Composable
private fun Preview() {
    Column() {
        TextFunction()
        ImgFunction()
        ButtonFunction()
        ButtonWithColor()
        //ButtonWithIcon()
        ButtonWithRoundCornerShape()
        ButtonWithBorder()
        ButtonWithElevation()
        TestInput()
        OutLineTextField()
        TextFieldWithIcons()
        Card()
        Row()
        Column()
    }

}

@Composable
fun TextFunction() {
    Text(
        text = "Hello Akhilesh ",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Red,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
fun ButtonFunction() {
    Button(onClick = {

    }) {
        Text(text = "Button")
    }
}

@Composable
fun ImgFunction() {

    Image(
        painter = painterResource(id = R.drawable.home1),
        contentDescription = "Dumi Image",
        //colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ButtonWithColor() {
    Button(
        onClick = {
            //onclick code
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
    )

    {
        Text(text = "Submit with background", color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        //onclick code here
    }) {
        Text(text = "Click ", color = Color.Magenta)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Image(
            painterResource(id = R.drawable.i_card),
            contentDescription = "Cart button icon",
            modifier = Modifier.size(20.dp)
        )
        Text(text = "Add to cart", Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ButtonWithRoundCornerShape() {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Round corner shape")
    }
}

@Composable
fun ButtonWithBorder() {
    Button(
        onClick = {
            //onclick code
        },
        border = BorderStroke(1.dp, Color.Red),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
    ) {
        Text(text = "Button with border", color = Color.DarkGray)
    }
}

@Composable
fun ButtonWithElevation() {
    Button(
        onClick = {
            //onclick code here
        }, elevation = ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(text = "Button with elevation")
    }
}

@Composable
fun TestInput() {
    TextField(value = "Hi akhilesh", onValueChange = {
        Log.d("***Hello**", it)
    },
        label = { Text(text = "Enter any values") }
    )

}
//************** using remember************

@Composable
fun OutLineTextField() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(
        value = text,
        label = { Text(text = "Enter Your Name") },
        onValueChange = {
            text = it
        }
    )
}


@Composable
fun TextFieldWithIcons() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    return OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
        //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
        onValueChange = {
            text = it
        },
        label = { Text(text = "Email address") },
        placeholder = { Text(text = "Enter your e-mail") },
    )
}

@Composable
fun Card() {
    val paddingModifier = Modifier.padding(10.dp)
    Card(elevation = 10.dp, modifier = paddingModifier) {
        Text(
            text = "Card with elevation",
            modifier = paddingModifier
        )
    }
}


//**********************Row,Column & Modifier ***********

@Composable
fun Row() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = " Text 1")
        Text(text = " Text 2")
        Text(text = " Text 3")
    }
}


@Composable
fun Column() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "Text 1", Modifier.background(Color.Red))
        Text(text = "Text 2", Modifier.background(Color.White))
        Text(text = "Text 3", Modifier.background(Color.Green))
    }
}
