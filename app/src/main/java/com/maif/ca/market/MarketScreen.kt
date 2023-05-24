package com.maif.ca.market

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.DriveEta
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.maif.ca.MainActivity
import com.maif.ca.app.ui.components.appbar.AppBar
import com.maif.ca.app.ui.previews.AllScreenPreview
import com.maif.ca.loggedmaicon
import com.maif.ca.ui.theme.MarketTheme



@Composable
fun MarketScreen(drawerState: DrawerState) {
    Scaffold(
        topBar = { AppBar(drawerState = drawerState) }
    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Market")
//        }
        MarketUIinsertProduct()
    }
}

@AllScreenPreview
@Composable
fun MarketScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    MarketTheme() {
        MarketScreen(drawerState)
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MarketUIinsertProduct() {
    val context = LocalContext.current
    var productDescription by remember { mutableStateOf("") }
    val productList = remember { mutableStateListOf<String>() }

    Column {
        OutlinedTextField(
            value = productDescription,
            onValueChange = { productDescription = it },
            label = { Text(text = "Enter your Product") },
            leadingIcon = {
                Icon(Icons.Default.Description, contentDescription = "description of product")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 70.dp, start = 10.dp, end = 10.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    loggedmaicon(productDescription, context)
                    productList.add(productDescription)
                    productDescription = ""
                },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Insert")
            }

            Button(
                onClick = {
                    if (productList.isNotEmpty()) {
                        productList.removeAt(productList.size - 1)
                    }
                },
                enabled = productList.isNotEmpty(),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Remove")
            }
        }

        // Display the list of items
        Column {
            Text(text = "List of Items:", fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            productList.forEachIndexed { index, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 4.dp,)
                ) {
                    Text(text = item, modifier = Modifier.weight(1f).padding(start = 10.dp))
                    IconButton(
                        onClick = {
                            productList.removeAt(index)
                        },
                        modifier = Modifier.padding(start = 8.dp)
                    ) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove")
                    }
                }
            }
        }
    }
}



@Composable
fun ItemList(items: List<String>) {
    LazyColumn {
        items(items) { item ->
            ListItem(item = item)
        }
    }
}

@Composable
fun ListItem(item: String) {
    Text(
        text = item,
//        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewItemList() {
    val itemList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
    ItemList(items = itemList)
}

fun loggedmaicon(productDescription: String, context: Context) {

    Toast.makeText(context, productDescription, Toast.LENGTH_SHORT).show()


//    if (userId == "maicon" && password == "1234") {
//        Toast.makeText(context, "Logged In Successfully", Toast.LENGTH_SHORT).show()
//

//        context.startActivity(Intent(context, MainActivity::class.java))
//
//    } else {
//        Toast.makeText(context, "Logged In Failed", Toast.LENGTH_SHORT).show()
//    }

}