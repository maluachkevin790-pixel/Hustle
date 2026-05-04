package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.data.models.CartManager
import com.example.hustlemate.navigation.Routes
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun PaymentScreen(navController: NavController) {

    val db = FirebaseFirestore.getInstance()

    Column(Modifier.padding(16.dp)) {

        Text("Payment", fontSize = 24.sp)

        Spacer(Modifier.height(20.dp))

        AppButton("Pay Now") {

            val items = CartManager.getItems()
            val total = CartManager.getTotal()

            if (items.isEmpty()) return@AppButton

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

                    // ✅ correct navigation
                    navController.navigate("order_confirmation/$orderId")
                }
        }
    }
}