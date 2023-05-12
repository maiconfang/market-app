package com.maif.ca.intro.composables

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme
import com.maif.ca.intro.IntroNavOption

@Composable
fun WelcomeScreen(navController: NavController = rememberNavController()) = IntroCompose(
    navController = navController,
    text = "Welcome",
    showBackButton = false
) {
//    navController.navigate(IntroNavOption.MotivationScreen.name)
}


@AllScreenPreview
@Composable
fun WelcomeScreenPreview() {
    AppDrawerExampleTheme {
        WelcomeScreen()
    }
}

