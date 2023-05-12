package com.maif.ca.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maif.ca.app.ui.components.appbar.AppBar
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme

@Composable
fun SettingsScreen(
    drawerState: DrawerState,
) {
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
            Text("Settigs")
        }
    }
}

@AllScreenPreview
@Composable
fun SettingsScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    AppDrawerExampleTheme {
        SettingsScreen(drawerState)
    }
}