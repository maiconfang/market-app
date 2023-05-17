package com.maif.ca

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.maif.ca.about.AboutScreen
import com.maif.ca.home.HomeScreen
import com.maif.ca.settings.SettingsScreen
import com.maif.ca.logout.LogoutScreen

fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.HomeScreen.name){
            HomeScreen(drawerState)
        }
        composable(MainNavOption.SettingsScreen.name){
            SettingsScreen(drawerState)
        }
        composable(MainNavOption.AboutScreen.name){
            AboutScreen(drawerState)
        }

        composable(MainNavOption.LogoutScreen.name){
            LogoutScreen(drawerState)
        }




    }
}

enum class MainNavOption {
    HomeScreen,
    AboutScreen,
    SettingsScreen,
    LogoutScreen,
}
