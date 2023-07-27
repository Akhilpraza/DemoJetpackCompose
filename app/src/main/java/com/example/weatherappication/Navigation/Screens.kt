//package com.example.movieapp.navagation
//
//import com.example.weatherappication.BizCard.BizCardActivity
//
//enum class Screens{
//    BasicActivity,
//    BizActivity,
//    IntroToActivity,
//    CalculatorActivity,
//    MovieActivity,
//    MainActivity;
//    companion object{
//        fun fromRoute(route:String?):Screens
//        =when(route?.substringBefore("/")){
//            BasicActivity.name -> BasicActivity
//            BizActivity.name -> BizActivity
//            IntroToActivity.name ->IntroToActivity
//            CalculatorActivity.name ->CalculatorActivity
//            MovieActivity.name -> MovieActivity
//            MovieActivity.name ->MainActivity
//            null -> BasicActivity
//            else -> throw IllegalAccessException("Route $route is not recognize")
//        }
//    }
//}