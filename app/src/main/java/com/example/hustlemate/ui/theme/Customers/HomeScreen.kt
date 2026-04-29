package com.example.hustlemate.ui.theme.shopping

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.BannerSection
import com.example.hustlemate.components.CategoryChip
import com.example.hustlemate.components.ProductCardUI
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.TextPrimary

@Composable
fun HomeScreen(navController: NavController) {

    val categories = listOf(
        "Electronics", "Fashion", "Shoes", "Phones", "Beauty"
    )

    val products = listOf(
        "iPhone 14", "Nike Shoes", "Headphones", "Watch",
        "Backpack", "Laptop"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(12.dp)
    ) {

        // 🔥 APP TITLE
        Text(
            "HustleMate",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        // 📢 BANNER (Jumia-style promo cards)
        BannerSection()

        Spacer(modifier = Modifier.height(16.dp))

        // 🧩 CATEGORIES
        Text("Categories", color = TextPrimary)

        LazyRow {
            items(categories) { cat ->
                CategoryChip(cat)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🛍️ PRODUCT GRID
        Text("Trending Products", color = TextPrimary)

        Spacer(modifier = Modifier.height(8.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(products) { product ->

                ProductCardUI(
                    name = product,
                    price = "KES ${(1000..5000).random()}",
                    onClick = {
                        navController.navigate("product_details/1")
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
