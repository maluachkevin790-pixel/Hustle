package com.example.hustlemate.ui.theme.shopping

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.ui.theme.Background
import com.example.hustlemate.ui.theme.HustleMateTheme

@Composable
fun CartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp)
    ) {

        // 🔥 SCREEN TITLE
        Text("Your Cart", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Sneakers - KES 2000")
                Text("Backpack - KES 1500")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("Total: KES 3500", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(20.dp))

        AppButton("Proceed to Checkout") {
            navController.navigate("checkout")
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CartScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        CartScreen(navController)
    }
}
