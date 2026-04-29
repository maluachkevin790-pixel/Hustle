package com.example.hustlemate.ui.theme.Selling

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.components.AppTextField
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.TextPrimary

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
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddProductScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        AddProductScreen(navController)
    }
}
