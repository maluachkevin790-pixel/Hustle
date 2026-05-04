package com.example.hustlemate.ui.theme.Selling

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun SellerDashboardScreen() {

    val db = FirebaseFirestore.getInstance()
    var orders by remember { mutableStateOf(listOf<Pair<String, Map<String, Any>>>()) }

    LaunchedEffect(Unit) {
        db.collection("orders")
            .addSnapshotListener { snapshot, _ ->
                if (snapshot != null) {
                    orders = snapshot.documents.map {
                        Pair(it.id, it.data ?: emptyMap())
                    }
                }
            }
    }

    Column(Modifier.padding(16.dp)) {

        Text("Seller Dashboard", style = MaterialTheme.typography.headlineMedium)

        orders.forEach { (id, order) ->

            Card(Modifier.fillMaxWidth().padding(8.dp)) {
                Column(Modifier.padding(12.dp)) {

                    Text("Order ID: $id")
                    Text("Total: KES ${order["total"]}")
                    Text("Status: ${order["status"]}")

                    Row {

                        Button(onClick = {
                            db.collection("orders").document(id)
                                .update("status", "SHIPPED")
                        }) {
                            Text("Ship")
                        }

                        Spacer(Modifier.width(8.dp))

                        Button(onClick = {
                            db.collection("orders").document(id)
                                .update("status", "DELIVERED")
                        }) {
                            Text("Deliver")
                        }
                    }
                }
            }
        }
    }
}