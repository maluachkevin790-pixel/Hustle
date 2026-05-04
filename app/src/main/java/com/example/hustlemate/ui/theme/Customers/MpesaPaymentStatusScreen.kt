package com.example.hustlemate.ui.theme.Customers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hustlemate.components.AppButton
import com.example.hustlemate.navigation.Routes
import com.example.hustlemate.ui.theme.HustleMateTheme
import com.example.hustlemate.ui.theme.Success
import com.example.hustlemate.ui.theme.Failed
import com.example.hustlemate.ui.theme.TextPrimary
import com.google.firebase.annotations.concurrent.Background
import kotlinx.coroutines.delay
import com.example.hustlemate.ui.theme.Background

enum class MpesaStatus { WAITING, SUCCESS, FAILED }

@Composable
fun MpesaPaymentStatusScreen(navController: NavController, orderId: String) {
    var status by remember { mutableStateOf(MpesaStatus.WAITING) }
    var receiptCode by remember { mutableStateOf("") }

    LaunchedEffect(orderId) {
        delay(5000)
        val paymentSuccess = true // Replace with real backend check

        if (paymentSuccess) {
            status = MpesaStatus.SUCCESS
            receiptCode = "MP" + (100000000..999999999).random().toString()
        } else status = MpesaStatus.FAILED
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (status) {
            MpesaStatus.WAITING -> {
                CircularProgressIndicator(color = Success)
                Spacer(Modifier.height(16.dp))
                Text("Confirming payment for order #$orderId...", color = TextPrimary)
                Spacer(Modifier.height(8.dp))
                Text("Check your phone for the M-Pesa prompt", color = TextPrimary)
                Spacer(Modifier.height(16.dp))
                AppButton("Resend Prompt") { status = MpesaStatus.WAITING }
            }
            MpesaStatus.SUCCESS -> {
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Success, modifier = Modifier.size(64.dp))
                Spacer(Modifier.height(16.dp))
                Text("Payment Successful!", color = Success, style = MaterialTheme.typography.headlineSmall)
                Text("Receipt: $receiptCode", color = TextPrimary)
                Spacer(Modifier.height(16.dp))
                AppButton("Track my order") {
                    navController.navigate(Routes.MY_ORDERS) { popUpTo(Routes.HOME) { inclusive = false } }
                }
            }
            MpesaStatus.FAILED -> {
                Icon(Icons.Default.Close, contentDescription = null, tint = Failed, modifier = Modifier.size(64.dp))
                Spacer(Modifier.height(16.dp))
                Text("Payment Failed", color = Failed, style = MaterialTheme.typography.headlineSmall)
                Spacer(Modifier.height(16.dp))
                AppButton("Try Again") { status = MpesaStatus.WAITING }
                Spacer(Modifier.height(8.dp))
                AppButton("Go Back") { navController.popBackStack() }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MpesaPaymentStatusScreenPreview() {
    val navController = rememberNavController()
    HustleMateTheme {
        MpesaPaymentStatusScreen(navController, orderId = "ORD-12345")
    }
}