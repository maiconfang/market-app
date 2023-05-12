package com.maif.ca.zone

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.maif.ca.app.ui.components.appbar.AppBar
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.app.ui.theme.AppDrawerExampleTheme

@Composable
fun ZoneScreen(drawerState: DrawerState) {
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

        WebViewWithAutoFillLoginAndPassword("https://gmta.gethugo.ca/dash",
            "ra01","schimmi")
    }
}

@AllScreenPreview
@Composable
fun ZoneScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    AppDrawerExampleTheme {
        ZoneScreen(drawerState)
    }
}

@Composable
fun WebViewWithAutoFillLoginAndPassword(url: String, login: String, password: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            WebView(context).apply {
                webViewClient = object : WebViewClient() {
                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        // Inject JavaScript to set the login and password field values

                        // Inject JavaScript to set the username and password fields
                        view?.loadUrl("""
                            javascript:document.getElementById("username").value="$password";
                            document.getElementById("password").value="$login";
                            document.getElementById("submit").click();
                        """.trimIndent())

                        //*[@id="header"]/div[1]/a/span
                        evaluateJavascript("//*[@id='header']/div[1]/a/span", null)



                        val loginResult = evaluateJavascript("document.getElementById('userid').value = '$login';", null)
                        val passwordResult=  evaluateJavascript("document.querySelector('#floatingPassword').value = '$login';", null)
                        if (passwordResult == null || loginResult == null) {
                            // Show an error message if the password field cannot be found
                            // Here, we use a Compose Text element to show the error message
                            System.out.println("Failed to fill in password field")
                        }
                        evaluateJavascript("//*[@id='floatingPassword'] = '$login';", null)
                        //*[@id='floatingPassword']



                        evaluateJavascript("document.getElementById('floatingPassword').value = '$password';", null)
                    }
                }
            }
        },
        update = { webView ->
            webView.loadUrl(url)
        }
    )

//    // A Compose TextFields to input the login and password
//    Column(Modifier.padding(16.dp)) {
//        TextField(
//            value = login,
//            onValueChange = { },
//            label = { Text("Login") }
//        )
//        TextField(
//            value = password,
//            onValueChange = { },
//            label = { Text("Password") },
//            visualTransformation = PasswordVisualTransformation()
//        )
//    }
}
