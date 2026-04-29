package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.CardColor
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.TextPrimary

data class OrderItem(
    val id: String,
    val status: String,
    val total: String
)

@Composable
fun MyOrdersScreen(navController: NavController) {

    val orders = listOf(
        OrderItem("ORD-001", "Pending", "KES 2500"),
        OrderItem("ORD-002", "Delivered", "KES 4000")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        Text(
            "My Orders",
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(orders) { order ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = CardColor)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Order ID: ${order.id}")
                        Text("Status: ${order.status}")
                        Text("Total: ${order.total}")
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyOrdersScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        MyOrdersScreen(navController)
    }
}
