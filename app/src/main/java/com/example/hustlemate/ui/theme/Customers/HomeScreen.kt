package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.ProductCardUI
import com.example.hustlemate.components.ProductItem
import com.example.hustlemate.data.getSampleProducts
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.*

@Composable
fun HomeScreen(navController: NavController) {

    val products = getSampleProducts()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        // 🔵 Top Bar (Sky Blue Header)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(SkyBlueDark)
                .padding(vertical = 20.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "HustleMate",
                style = MaterialTheme.typography.headlineMedium,
                color = White
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // 🛍 Product Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(products) { product ->

                ProductItem(
                    product = product,
                    onClick = {
                        navController.navigate(Routes.productDetails(product.id))
                    }
                ) }
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