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
fun CartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text("Your Cart", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Sneakers - KES 2000")
                Text("Backpack - KES 1500")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Total: KES 3500", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(20.dp))

        AppButton("Proceed to Checkout") {
            navController.navigate("checkout")
        }
    }
}