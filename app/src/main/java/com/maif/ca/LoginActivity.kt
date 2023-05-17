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
    var userId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Taxi ID
    Column() {
        Text(
            text = "Market Luna",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = userId,
            onValueChange = { userId = it },
            label = { Text(text = "Enter your User ID") },
            leadingIcon = {
                Icon(Icons.Default.DriveEta, contentDescription = "taxi id")
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
            onClick = { loggedmaicon(userId, password, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        ) {

            Text(
                text = "Login",
                textAlign = TextAlign.Center
            )
        }
    }

}

fun loggedmaicon(userId: String, password: String, context: Context) {


    context.startActivity(Intent(context, MainActivity::class.java))


//    if (userId == "maicon" && password == "1234") {
//        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()
//

//        context.startActivity(Intent(context, MainActivity::class.java))
//
//    } else {
//        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
//    }

}


