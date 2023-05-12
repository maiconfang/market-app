package com.maif.ca.intro

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.maif.ca.NavRoutes
//import com.maif.ca.intro.composables.MotivationScreen
//import com.maif.ca.intro.composables.RecommendationScreen
import com.maif.ca.intro.composables.WelcomeScreen

fun NavGraphBuilder.introGraph(navController: NavController) {
    navigation(startDestination = IntroNavOption.WelcomeScreen.name, route = NavRoutes.IntroRoute.name) {
        composable(IntroNavOption.WelcomeScreen.name){
            WelcomeScreen(navController)
        }
//        composable(IntroNavOption.MotivationScreen.name){
//            MotivationScreen(navController)
//        }
//        composable(IntroNavOption.RecommendationScreen.name){
//            RecommendationScreen(navController)
//        }
    }
}

enum class IntroNavOption {
    WelcomeScreen,
//    MotivationScreen,
    RecommendationScreen
}
