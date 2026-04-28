package com.hustlemate.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hustlemate.app.components.AppButton
import com.hustlemate.app.ui.theme.*

@Composable
fun SellerDashboardScreen(navController: NavController) {

    val products = listOf("Shoes", "Phone", "Bag")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            "Seller Dashboard",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppButton("Add New Product") {
            navController.navigate("add_product")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Your Products:", color = TextSecondary)

        Spacer(modifier = Modifier.height(8.dp))

        products.forEach { product ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(product)
                    Text("Tap to edit (future feature)", color = TextSecondary)
                }
            }
        }
    }
}

