package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore
import com.example.hustlemate.ui.theme.*

// ----------------------
// MAIN SCREEN (Firestore)
// ----------------------
@Composable
fun MyOrdersScreen() {

    val db = FirebaseFirestore.getInstance()
    var orders by remember { mutableStateOf(listOf<Map<String, Any>>()) }

    LaunchedEffect(Unit) {
        db.collection("orders")
            .whereEqualTo("userId", "demoUser")
            .addSnapshotListener { snapshot, _ ->
                if (snapshot != null) {
                    orders = snapshot.documents.map { it.data ?: emptyMap() }
                }
            }
    }

    MyOrdersContent(orders = orders)
}

// ----------------------
// UI CONTENT (Previewable)
// ----------------------
@Composable
fun MyOrdersContent(orders: List<Map<String, Any>>) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            text = "My Orders",
            style = MaterialTheme.typography.headlineMedium,
            color = SkyBlueDark
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (orders.isEmpty()) {
            Text(
                text = "No orders yet",
                color = TextSecondary
            )
        } else {

            LazyColumn {
                items(orders) { order ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = White
                        ),
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Column(Modifier.padding(12.dp)) {

                            Text(
                                text = "Total: KES ${order["total"] ?: 0}",
                                style = MaterialTheme.typography.titleMedium,
                                color = SkyBlueDark
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "Status: ${order["status"] ?: "N/A"}",
                                color = TextPrimary
                            )
                        }
                    }
                }
            }
        }
    }
}

// ----------------------
// PREVIEW (WITH FAKE DATA)
// ----------------------
@Preview(showBackground = true)
@Composable
fun MyOrdersPreview() {

    HustleMateTheme {

        val sampleOrders = listOf(
            mapOf("total" to 2500, "status" to "Delivered"),
            mapOf("total" to 1200, "status" to "Pending"),
            mapOf("total" to 5400, "status" to "Shipped")
        )

        MyOrdersContent(orders = sampleOrders)
    }
}