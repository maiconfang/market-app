package com.maif.ca.meter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maif.ca.app.ui.components.appbar.AppBar
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme
import com.maif.ca.meter.ui.theme.DrawerExampleTheme


/////////////////////////////////////////
@Composable
fun MeterActivity(drawerState: DrawerState) {
    Scaffold(
        topBar = { AppBar(drawerState = drawerState) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Zone")
        }
    }
}

@AllScreenPreview
@Composable
fun MeterActivityPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    AppDrawerExampleTheme {
        MeterActivity(drawerState)
    }
}