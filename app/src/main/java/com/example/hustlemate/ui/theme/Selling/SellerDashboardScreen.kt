package com.hustlemate.app.screens

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
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.CardColor
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.TextPrimary
import com.example.hustlemate.ui.theme.TextSecondary

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
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SellerDashboardScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        SellerDashboardScreen(navController)
    }
}

