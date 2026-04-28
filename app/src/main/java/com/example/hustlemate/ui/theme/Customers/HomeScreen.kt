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
fun HomeScreen(navController: NavController) {
    val products = listOf("Sneakers", "iPhone", "Backpack")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            "HustleMate",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(16.dp))

        products.forEachIndexed { index, product ->
            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = CardColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("product_details/$index")
                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(product, style = MaterialTheme.typography.titleMedium)
                    Text("KES ${(index + 1) * 1000}", color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        AppButton("Go to Cart") {
            navController.navigate("cart")
        }
    }
}
