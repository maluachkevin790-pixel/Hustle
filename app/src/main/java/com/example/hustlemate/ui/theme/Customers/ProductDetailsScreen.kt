package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.data.getSampleProducts
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.viewmodel.CartViewModel

@Composable
fun ProductDetailsScreen(
    navController: NavController,
    productId: String,
    cartViewModel: CartViewModel
) {

    val product = getSampleProducts().find { it.id == productId }

    Column(modifier = Modifier.padding(16.dp)) {

        if (product != null) {

            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("KES ${product.price}")

            Spacer(modifier = Modifier.height(8.dp))

            Text(product.description)

            Spacer(modifier = Modifier.height(24.dp))

            AppButton(text = "Add to Cart") {
                cartViewModel.addToCart(product)
            }

            Spacer(modifier = Modifier.height(12.dp))

            AppButton(text = "Go to Cart") {
                navController.navigate("cart")
            }

        } else {
            Text("Product not found")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsPreview() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    HustleMateTheme {
        ProductDetailsScreen(
            navController = navController,
            productId = "1",
            cartViewModel = cartViewModel
        )
    }
}
