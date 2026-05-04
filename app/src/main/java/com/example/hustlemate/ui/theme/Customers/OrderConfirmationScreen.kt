package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.hustlemate.data.models.CartManager
import com.example.hustlemate.navigation.Routes
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import java.net.URL

@Composable
fun OrderConfirmationScreen(orderId: String, navController: NavController) {

    var status by remember { mutableStateOf("PENDING") }

    LaunchedEffect(Unit) {

        while (true) {

            try {
                val response = URL("http://10.0.2.2:3000/status").readText()

                if (response.contains("SUCCESS")) {

                    status = "SUCCESS"

                    FirebaseFirestore.getInstance()
                        .collection("orders")
                        .document(orderId)
                        .update("status", "PAID")

                    CartManager.clear()
                    break
                }

                if (response.contains("FAILED")) {
                    status = "FAILED"
                    break
                }

            } catch (_: Exception) {}

            delay(3000)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        when (status) {

            "PENDING" -> {
                CircularProgressIndicator()
                Spacer(Modifier.height(16.dp))
                Text("Check your phone for M-Pesa")
            }

            "SUCCESS" -> {
                Text("Payment Successful")

                Button(onClick = {
                    navController.navigate(Routes.MY_ORDERS)
                }) {
                    Text("Track Order")
                }
            }

            "FAILED" -> {
                Text("Payment Failed")

                Button(onClick = {
                    navController.popBackStack()
                }) {
                    Text("Try Again")
                }
            }
        }
    }
}