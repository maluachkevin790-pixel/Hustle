package com.hustlemate.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.hustlemate.app.components.*
import com.hustlemate.app.ui.theme.*
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