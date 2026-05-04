package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.firestore.FirebaseFirestore

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

    Column(Modifier.padding(16.dp)) {

        Text("My Orders")

        orders.forEach { order ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text("Total: KES ${order["total"] ?: 0}")
                    Text("Status: ${order["status"] ?: "N/A"}")
                }
            }
        }
    }
}