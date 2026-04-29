package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.ProductCardUI
import com.example.hustlemate.data.getSampleProducts
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.HustleMateTheme

@Composable
fun HomeScreen(navController: NavController) {

    val products = getSampleProducts()

    Column(modifier = Modifier.padding(12.dp)) {

        Text(
            text = "HustleMate",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f)
        ) {

            items(products) { product ->

                ProductCardUI(
                    name = product.name,
                    price = "KES ${product.price}",
                    onClick = {
                        navController.navigate("product_details/${product.id}")
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        HomeScreen(navController)
    }
}
