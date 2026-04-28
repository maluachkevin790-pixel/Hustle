package com.hustlemate.app.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hustlemate.app.components.AppButton
import com.hustlemate.app.components.AppTextField
import com.hustlemate.app.ui.theme.Background

@Composable
fun RegisterScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isSeller by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Create Account 🚀",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        // 👤 Name
        AppTextField(
            value = name,
            label = "Full Name"
        ) { name = it }

        // 📧 Email
        AppTextField(
            value = email,
            label = "Email"
        ) { email = it }

        // 🔒 Password
        AppTextField(
            value = password,
            label = "Password"
        ) { password = it }

        Spacer(modifier = Modifier.height(8.dp))

        // 🧑‍💼 Seller Option
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(
                checked = isSeller,
                onCheckedChange = { isSeller = it }
            )
            Text("Register as Seller")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 📝 Register Button
        AppButton(text = "Register") {
            navController.navigate("home")
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 🔙 Back to Login
        TextButton(onClick = {
            navController.navigate("login")
        }) {
            Text("Already have an account? Login")
        }
    }
}

