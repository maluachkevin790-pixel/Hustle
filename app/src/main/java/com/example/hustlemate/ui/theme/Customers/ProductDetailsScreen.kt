package com.example.hustlemate.ui.theme.shopping

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.ui.theme.HustleMateTheme

@Composable
fun ProductDetailsScreen(
    navController: NavController,
    productId: String
) {

    // Fake product data (replace later with backend)
    val productName = "Premium Sneakers"
    val productPrice = "KES 2500"
    val productDescription = "Comfortable and stylish sneakers for daily wear."

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // 🧾 Title
        Text(
            text = productName,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 💰 Price
        Text(
            text = productPrice,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 📄 Description
        Text(
            text = productDescription,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 🛒 Add to Cart Button
        AppButton(text = "Add to Cart") {
            navController.navigate("cart")
        }

        // 💳 Buy Now Button
        AppButton(text = "Buy Now") {
            navController.navigate("checkout")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        ProductDetailsScreen(navController, "1")
    }
}
