package com.example.hustlemate.ui.theme.Orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.HustleMateTheme


@Composable
fun OrderConfirmationScreen(navController: NavController, orderId: String) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("✅", fontSize = 48.sp)
        Text("Order Successful!", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))

        Text("Order ID: $orderId")

        Spacer(modifier = Modifier.height(20.dp))

        AppButton("View Orders") {
            navController.navigate("my_orders")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OrderConfirmationScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        OrderConfirmationScreen(navController, "12345")
    }
}
