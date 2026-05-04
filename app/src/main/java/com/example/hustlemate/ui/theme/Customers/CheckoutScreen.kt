package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.TextPrimary
import com.google.firebase.annotations.concurrent.Background

@Composable
fun CheckoutScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {
        Text(
            "Checkout",
            style = MaterialTheme.typography.headlineSmall,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppButton("Pay with M-Pesa") {
            navController.navigate(Routes.PAYMENT)
        }

        AppButton("Pay with PayPal") {
            navController.navigate(Routes.PAYMENT)
        }

        AppButton("Cash on Delivery") {
            navController.navigate(Routes.ORDER_CONFIRMATION + "/123")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CheckoutScreenPreview() {
    val navController = rememberNavController()
    HustleMateTheme {
        CheckoutScreen(navController)
    }
}