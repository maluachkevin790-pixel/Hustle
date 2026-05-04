package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.data.getSampleProducts
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.*
import com.example.hustlemate.viewmodel.CartViewModel

// ----------------------
// REAL SCREEN
// ----------------------
@Composable
fun ProductDetailsScreen(
    navController: NavController,
    productId: String,
    cartViewModel: CartViewModel = viewModel()
) {

    val product = getSampleProducts().find { it.id == productId }

    var quantity by remember { mutableStateOf(1) }
    var isWishlisted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        if (product == null) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Product not found", color = TextPrimary)
            }

        } else {

            // 🖼 IMAGE
            AsyncImage(
                model = "https://via.placeholder.com/600x400.png",
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(SkyBlueDark.copy(alpha = 0.15f))
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ❤️ Title + Wishlist
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = product.name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f),
                    color = TextPrimary
                )

                IconButton(
                    onClick = { isWishlisted = !isWishlisted }
                ) {
                    Icon(
                        imageVector = if (isWishlisted)
                            Icons.Default.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = "Wishlist",
                        tint = if (isWishlisted) Color.Red else SkyBlueDark
                    )
                }
            }

            // ⭐ Ratings
            Row(verticalAlignment = Alignment.CenterVertically) {

                repeat(5) { index ->
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = if (index < 4) Color(0xFFFFC107) else Color.LightGray,
                        modifier = Modifier.size(18.dp)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                Text("4.0", color = TextPrimary)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 💰 Price
            Text(
                text = "KES ${product.price}",
                style = MaterialTheme.typography.titleLarge,
                color = SkyBlueDark,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 📝 Description
            Text(
                text = product.description,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(16.dp))

            // ➕ Quantity
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text("Quantity:", color = TextPrimary)

                Spacer(modifier = Modifier.width(12.dp))

                Button(onClick = { if (quantity > 1) quantity-- }) {
                    Text("-")
                }

                Text(
                    text = "$quantity",
                    modifier = Modifier.padding(horizontal = 12.dp),
                    color = TextPrimary
                )

                Button(onClick = { quantity++ }) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // 🔥 ACTIONS
            Column {

                AppButton(text = "Add to Cart") {
                    repeat(quantity) {
                        cartViewModel.addToCart(product)
                    }
                    navController.navigate(Routes.CART)
                }

                Spacer(modifier = Modifier.height(10.dp))

                AppButton(text = "Buy Now") {
                    repeat(quantity) {
                        cartViewModel.addToCart(product)
                    }
                    navController.navigate(Routes.CHECKOUT)
                }
            }
        }
    }
}

// ----------------------
// PREVIEW (FIXED - NO VIEWMODEL)
// ----------------------
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductDetailsPreview() {

    val navController = rememberNavController()
    val fakeProduct = getSampleProducts().firstOrNull()

    HustleMateTheme {

        if (fakeProduct != null) {

            ProductDetailsContentPreview(
                product = fakeProduct
            )

        } else {
            Text("No sample product found")
        }
    }
}

// ----------------------
// PREVIEW UI ONLY (SAFE)
// ----------------------
@Composable
fun ProductDetailsContentPreview(product: com.example.hustlemate.models.Product) {

    var quantity by remember { mutableStateOf(1) }
    var isWishlisted by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        AsyncImage(
            model = "https://via.placeholder.com/600x400.png",
            contentDescription = product.name,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(SkyBlueDark.copy(alpha = 0.15f))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = product.name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.weight(1f),
                color = TextPrimary
            )

            IconButton(onClick = { isWishlisted = !isWishlisted }) {
                Icon(
                    imageVector = if (isWishlisted)
                        Icons.Default.Favorite
                    else Icons.Default.FavoriteBorder,
                    contentDescription = "Wishlist"
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "KES ${product.price}",
            color = SkyBlueDark,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(product.description, color = TextPrimary)
    }
}