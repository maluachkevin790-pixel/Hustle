package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hustlemate.models.Product
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.viewmodel.CartViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel) {

    val items = cartViewModel.cartItems

    Column(modifier = Modifier.padding(16.dp)) {

        Text(
            text = "My Cart",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {

            items(items) { item ->

                Column(modifier = Modifier.padding(8.dp)) {

                    Text(text = item.product.name)
                    Text(text = "Qty: ${item.quantity}")
                    Text(text = "KES ${item.product.price * item.quantity}")

                    Spacer(modifier = Modifier.height(8.dp))

                    Row {

                        Button(onClick = {
                            cartViewModel.decreaseQty(item.product.id)
                        }) {
                            Text("-")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(onClick = {
                            cartViewModel.increaseQty(item.product.id)
                        }) {
                            Text("+")
                        }

                        Spacer(modifier = Modifier.width(8.dp))

                        Button(onClick = {
                            cartViewModel.removeFromCart(item.product.id)
                        }) {
                            Text("Remove")
                        }
                    }
                }

                Divider() // ✅ FIXED (instead of HorizontalDivider)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total: KES ${cartViewModel.getTotal()}",
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreenPreview() {

    val cartViewModel: CartViewModel = viewModel()

    // 🔥 sample preview data
    cartViewModel.addToCart(
        Product("1", "Shoes", 2500.0, "Nice shoes")
    )
    cartViewModel.addToCart(
        Product("2", "Phone", 15000.0, "Smart phone")
    )

    HustleMateTheme {
        CartScreen(cartViewModel)
    }
}