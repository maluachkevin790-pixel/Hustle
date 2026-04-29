package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.profille.SettingsScreen

@Composable
fun PaymentScreen(navController: NavController) {
    Column(Modifier.padding(16.dp)) {
        Text("Payment", fontSize = 24.sp)

        Spacer(Modifier.height(20.dp))

        AppButton("Pay Now") {
            navController.navigate(Routes.ORDER_CONFIRMATION)
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PaymentScreenPreview() {
    val navController = rememberNavController()

    HustleMateTheme {
        PaymentScreen(navController)
    }
}
