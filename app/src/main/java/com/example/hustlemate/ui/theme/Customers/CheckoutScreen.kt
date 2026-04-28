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
fun CheckoutScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text("Checkout", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))

        AppButton("Pay with M-Pesa") {
            navController.navigate("order_confirmation/123")
        }

        AppButton("Pay with PayPal") {
            navController.navigate("order_confirmation/123")
        }

        AppButton("Cash on Delivery") {
            navController.navigate("order_confirmation/123")
        }
    }
}