package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.data.models.CartManager
import com.example.hustlemate.ui.theme.*
import com.google.firebase.firestore.FirebaseFirestore

// ----------------------
// MAIN SCREEN (LOGIC)
// ----------------------
@Composable
fun PaymentScreen(navController: NavController) {

    val db = FirebaseFirestore.getInstance()
    val items = CartManager.getItems()
    val total = CartManager.getTotal()

    PaymentContent(
        total = total,
        onPay = {

            if (items.isEmpty()) return@PaymentContent

            val order = hashMapOf(
                "userId" to "demoUser",
                "items" to items.map {
                    mapOf("name" to it.name, "price" to it.price)
                },
                "total" to total,
                "status" to "PENDING",
                "createdAt" to System.currentTimeMillis()
            )

            db.collection("orders")
                .add(order)
                .addOnSuccessListener { doc ->

                    val orderId = doc.id
                    navController.navigate("order_confirmation/$orderId")
                }
        }
    )
}

// ----------------------
// UI CONTENT (PREVIEWABLE)
// ----------------------
@Composable
fun PaymentContent(
    total: Double,
    onPay: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {

            Text(
                text = "Payment",
                style = MaterialTheme.typography.headlineMedium,
                color = SkyBlueDark
            )

            Spacer(Modifier.height(20.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(Modifier.padding(16.dp)) {

                    Text(
                        text = "Total Amount",
                        style = MaterialTheme.typography.bodyMedium,
                        color = TextSecondary
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        text = "KES $total",
                        style = MaterialTheme.typography.headlineSmall,
                        color = SkyBlueDark
                    )
                }
            }
        }

        // Fixed: Removed unsupported parameters 'containerColor' and 'contentColor' from AppButton.
        // AppButton only accepts 'text' and 'onClick' parameters.
        AppButton(
            text = "Pay Now",
            onClick = onPay
        )
    }
}

// ----------------------
// PREVIEW
// ----------------------
@Preview(showBackground = true)
@Composable
fun PaymentPreview() {
    HustleMateTheme {
        PaymentContent(
            total = 12500.0,
            onPay = {}
        )
    }
}