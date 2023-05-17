package com.maif.ca.logout

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.maif.ca.LoginActivity
import com.maif.ca.MainActivity
import com.maif.ca.app.ui.components.appbar.AppBar
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme

@Composable
fun LogoutScreen(
    drawerState: DrawerState,
) {
    val context = LocalContext.current
    Scaffold(

        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            context.startActivity(Intent(context, LoginActivity::class.java))
            Text("Logout")
        }
    }
}

@AllScreenPreview
@Composable
fun LogoutScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    AppDrawerExampleTheme {
        LogoutScreen(drawerState)
    }
}