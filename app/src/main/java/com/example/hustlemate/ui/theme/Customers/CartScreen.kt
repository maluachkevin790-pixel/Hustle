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
// MAIN SCREEN (ViewModel connected)
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
// PURE UI (Reusable)
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
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        // ✅ Empty state
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
                    color = TextPrimary
                )
            }
        } else {
            // ✅ Proper scrolling list
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(items) { item ->
                    Column(modifier = Modifier.padding(8.dp)) {

                        Text(
                            text = item.product.name,
                            color = TextPrimary
                        )

                        Text(
                            text = "Qty: ${item.quantity}",
                            color = TextPrimary
                        )

                        Text(
                            text = "KES ${item.product.price * item.quantity}",
                            color = TextPrimary
                        )
                    }
                    Divider()
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: KES $total",
            style = MaterialTheme.typography.titleMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onCheckout,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = SkyBlueDark,
                contentColor = White
            )
        ) {
            Text("Proceed to Checkout")
        }
    }
}
