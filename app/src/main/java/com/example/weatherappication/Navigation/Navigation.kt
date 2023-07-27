//package com.example.movieapp.navagation
//
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.weatherappication.Basics.BasicActivity
//import com.example.weatherappication.BizCard.BizCardActivity
//import com.example.weatherappication.CalculatorApp.CalculatorAppActivity
//import com.example.weatherappication.IntroToCompose.IntroToComposeActivity
//import com.example.weatherappication.MainActivity
//import com.example.weatherappication.MovieApp.MovieAppActivity
//
//
//@ExperimentalAnimationApi
//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screens.BasicActivity.name){
//        composable(Screens.BasicActivity.name) {
//            //here we pass where this should lead us to
//            BasicActivity(navController = navController)
//        }
//
//        composable(Screens.BizActivity.name) {
//            //here we pass where this should lead us to
//            BizCardActivity(navController = navController)
//        }
//        composable(Screens.IntroToActivity.name) {
//            //here we pass where this should lead us to
//            IntroToComposeActivity(navController = navController)
//        }
//        composable(Screens.CalculatorActivity.name) {
//            //here we pass where this should lead us to
//            CalculatorAppActivity(navController = navController)
//        }
//        composable(Screens.MovieActivity.name) {
//            //here we pass where this should lead us to
//            MovieAppActivity(navController = navController)
//        }
//        composable(Screens.MainActivity.name) {
//            //here we pass where this should lead us to
//            MainActivity(navController = navController)
//        }
//    }
//}