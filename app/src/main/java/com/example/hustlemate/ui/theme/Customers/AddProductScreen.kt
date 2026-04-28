package com.hustlemate.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hustlemate.app.components.AppButton
import com.hustlemate.app.components.AppTextField
import com.hustlemate.app.ui.theme.*

@Composable
fun AddProductScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            "Add Product",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        AppTextField(name, "Product Name") { name = it }
        AppTextField(price, "Price") { price = it }
        AppTextField(description, "Description") { description = it }

        Spacer(modifier = Modifier.height(16.dp))

        AppButton("Save Product") {
            // TODO: save to database later
            navController.popBackStack()
        }
    }
}