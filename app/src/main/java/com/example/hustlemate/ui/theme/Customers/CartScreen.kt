package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.models.Cart
import com.example.hustlemate.models.Product
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.*
import com.example.hustlemate.viewmodel.CartViewModel

// ----------------------
// MAIN SCREEN
// ----------------------
@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    CartContent(
        items = cartViewModel.cartItems,
        total = cartViewModel.getTotal(),
        onCheckout = {
            navController.navigate(Routes.CHECKOUT)
        }
    )
}

// ----------------------
// UI CONTENT
// ----------------------
@Composable
fun CartContent(
    items: List<Cart>,
    total: Double,
    onCheckout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            text = "My Cart",
            style = MaterialTheme.typography.headlineMedium,
            color = SkyBlueDark   // ✅ themed title
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (items.isEmpty()) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Your cart is empty",
                    style = MaterialTheme.typography.bodyLarge,
                    color = TextSecondary   // softer tone
                )
            }
        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(items) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {

                            Text(
                                text = item.product.name,
                                style = MaterialTheme.typography.titleMedium,
                                color = SkyBlueDark
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Qty: ${item.quantity}",
                                color = TextPrimary
                            )

                            Text(
                                text = "KES ${item.product.price * item.quantity}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = TextPrimary
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: KES $total",
            style = MaterialTheme.typography.titleLarge,
            color = SkyBlueDark   // ✅ highlight total
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onCheckout,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SkyBlueDark,
                contentColor = White
            )
        ) {
            Text(
                text = "Proceed to Checkout",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

// ----------------------
// PREVIEWS (THEMED)
// ----------------------
@Preview(showBackground = true)
@Composable
fun CartPreview() {
    HustleMateTheme {

        val sampleItems = listOf(
            Cart(Product("1", "Nike Air Max", 8500.0, ""), 2),
            Cart(Product("2", "Adidas Hoodie", 4500.0, ""), 1)
        )

        CartContent(
            items = sampleItems,
            total = 21500.0,
            onCheckout = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CartEmptyPreview() {
    HustleMateTheme {
        CartContent(
            items = emptyList(),
            total = 0.0,
            onCheckout = {}
        )
    }
}