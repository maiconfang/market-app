package com.maif.ca

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maif.ca.ui.theme.MarketTheme
import androidx.compose.material.icons.filled.DriveEta
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginUImaicon()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginUImaicon() {

    val context = LocalContext.current
    var taxiId by remember { mutableStateOf("") }
    var driverId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Taxi ID
    Column() {
        Text(
            text = "GREATER MONCTON - MARKET",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Left,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = taxiId,
            onValueChange = { taxiId = it },
            label = { Text(text = "Enter your Taxi ID") },
            leadingIcon = {
                Icon(Icons.Default.DriveEta, contentDescription = "taxi id")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )


        // Driver ID
        OutlinedTextField(
            value = driverId,
            onValueChange = { driverId = it },
            label = { Text(text = "Enter your Driver ID") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter your Password") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(
            onClick = { loggedmaicon(taxiId, driverId, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {

            Text(
                text = "Login teste maicon fang",
                textAlign = TextAlign.Center
            )
        }
    }

}

fun loggedmaicon(taxiId: String, driverId: String, password: String, context: Context) {


    context.startActivity(Intent(context, MainActivity::class.java))


//    if (taxiId == "ca01" && driverId=="hw2" && password == "1234") {
//        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()
//
//        // Open the activity ZoneActivity
//        context.startActivity(Intent(context, ZoneActivity::class.java))
//
//    } else {
//        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
//    }

}


